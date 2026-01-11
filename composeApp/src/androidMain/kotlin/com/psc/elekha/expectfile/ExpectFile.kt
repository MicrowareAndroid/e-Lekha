package com.psc.elekha.expectfile

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application

import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider

import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import com.psc.elekha.utils.AppPermission
import com.psc.elekha.utils.Config
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import org.koin.mp.KoinPlatform
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@SuppressLint("ContextCastToActivity")
@Composable
actual fun AppBackHandler(onBack: () -> Unit) {
    BackHandler {
        onBack()

    }
}
actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val appContext = KoinPlatform.getKoin().get<Application>()
    val dbFile = appContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}


actual class PermissionManager(
    private val context: Context
) {
    actual suspend fun checkPermission(
        permission: AppPermission
    ): PermissionStatus {

        val androidPermissions = permission.toAndroidPermissions()

        if (androidPermissions.isEmpty()) {
            return PermissionStatus.GRANTED
        }

        val allGranted = androidPermissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }

        if (allGranted) return PermissionStatus.GRANTED

        val activity = context.findActivity() ?: return PermissionStatus.DENIED

        val shouldShowRationale = androidPermissions.any {
            ActivityCompat.shouldShowRequestPermissionRationale(activity, it)
        }

        val prefs = context.getSharedPreferences("permissions", Context.MODE_PRIVATE)
        val wasRequested = prefs.getBoolean(permission.name, false)

        return when {
            shouldShowRationale -> PermissionStatus.DENIED
            wasRequested -> PermissionStatus.DENIED_PERMANENTLY
            else -> PermissionStatus.NOT_DETERMINED
        }
    }

    actual suspend fun requestPermission(
        permission: AppPermission
    ): PermissionStatus {

        return checkPermission(permission)
    }

    actual suspend fun requestMultiplePermissions(
        permissions: List<AppPermission>
    ): Map<AppPermission, PermissionStatus> {
        return permissions.associateWith { checkPermission(it) }
    }

    actual fun openAppSettings() {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", context.packageName, null)
        ).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }

    private fun AppPermission.toAndroidPermissions(): List<String> =
        when (this) {
            AppPermission.CAMERA -> listOf(Manifest.permission.CAMERA)

            AppPermission.STORAGE ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    listOf(
                        Manifest.permission.READ_MEDIA_IMAGES,
                        Manifest.permission.READ_MEDIA_VIDEO,
                        Manifest.permission.READ_MEDIA_AUDIO
                    )
                } else {
                    listOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                }

            AppPermission.LOCATION -> listOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )

            AppPermission.MICROPHONE ->
                listOf(Manifest.permission.RECORD_AUDIO)
        }
}

fun Context.findActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
}


actual class DatabaseExporter {

    private val context: Context
        get() = AndroidContextProvider.context

    actual fun exportAndShare(dbBaseName: String) {
        val zip = prepareDatabaseZip(context, dbBaseName)
        if (zip != null) {
            val pm = context.packageManager
            val waPkg = listOf("com.whatsapp", "com.whatsapp.w4b")
                .firstOrNull {
                    try {
                        pm.getPackageInfo(it, 0)
                        true
                    } catch (_: Exception) {
                        false
                    }
                }
            shareFile(context, zip, waPkg)
        }
    }
}


fun prepareDatabaseZip(context: Context, dbBaseName: String = dbFileName): File? {
    val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val exportBase = "Elekha_$timestamp"
    val zipName = "$exportBase.db.zip"
    val zipFile = File(context.externalCacheDir, zipName)

    try {
        // Find actual DB file
        val possibleNames = listOf("$dbBaseName.db", dbBaseName)
        val dbFile = possibleNames.map { context.getDatabasePath(it) }
            .firstOrNull { it.exists() && it.length() > 0 } ?: return null

        // Flush WAL to DB
        try {
            val openedDb = SQLiteDatabase.openDatabase(
                dbFile.absolutePath,
                null,
                SQLiteDatabase.OPEN_READWRITE
            )
            openedDb.rawQuery("PRAGMA wal_checkpoint(FULL);", null).close()
            openedDb.close()
        } catch (_: Exception) {
        }

        // Copy main + wal + shm (if present), rename with timestamp
        val filesToZip = mutableListOf<File>()
        val tempFolder = File(context.externalCacheDir, "helpage_tmp_$timestamp").apply { mkdirs() }

        fun copyFile(src: File, newName: String) {
            if (src.exists()) {
                val dst = File(tempFolder, newName)
                FileInputStream(src).use { input ->
                    FileOutputStream(dst).use { output ->
                        input.copyTo(output)
                    }
                }
                filesToZip.add(dst)
            }
        }

        copyFile(dbFile, "$exportBase.db")
        copyFile(File(dbFile.absolutePath + "-wal"), "$exportBase.db-wal")
        copyFile(File(dbFile.absolutePath + "-shm"), "$exportBase.db-shm")

        // Create the ZIP
        ZipOutputStream(FileOutputStream(zipFile)).use { zos ->
            filesToZip.forEach { file ->
                FileInputStream(file).use { fis ->
                    zos.putNextEntry(ZipEntry(file.name))
                    fis.copyTo(zos)
                    zos.closeEntry()
                }
            }
        }

        // Cleanup temp
        filesToZip.forEach { it.delete() }
        tempFolder.delete()

        return zipFile
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}

fun shareFile(
    context: Context,
    file: File,
    targetPackage: String? = null,
    chooserTitle: String = "Share Database via"
)
{
    try {
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/zip"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        val intentToStart = if (targetPackage != null) {
            shareIntent.setPackage(targetPackage)
            if (shareIntent.resolveActivity(context.packageManager) != null) shareIntent
            else Intent.createChooser(shareIntent, chooserTitle)
        } else {
            Intent.createChooser(shareIntent, chooserTitle)
        }
        intentToStart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intentToStart)
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Failed to share: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


actual fun resolveImagePath(imageName: String): String? {
    if (imageName.isBlank()) return null

    val context = AndroidContextProvider.context
    val file = File(context.filesDir, imageName)

    return if (file.exists()) file.absolutePath else null
}

actual class PlatformImage(val bitmap: ImageBitmap) {
    actual fun toImageBitmap(): Any? = bitmap
}

actual fun loadImageFromLocalOrServer(
    imageName: String,
    onLoaded: (PlatformImage?) -> Unit
) {
    val scope = MainScope()

    scope.launch {
        if (imageName.isBlank()) {
            onLoaded(null)
            return@launch
        }

        // Try local storage
        val localPath = resolveImagePath(imageName)
        if (localPath != null) {
            val bitmap = BitmapFactory.decodeFile(localPath)?.asImageBitmap()
            onLoaded(bitmap?.let { PlatformImage(it) })
            return@launch
        }

        // Try loading from server (no explicit connectivity check)
        try {
            val url = "${Config.BASE_IMAGE_URL}$imageName"

            val bitmap = withContext(Dispatchers.IO) {
                java.net.URL(url).openStream().use {
                    BitmapFactory.decodeStream(it)
                }
            }

            onLoaded(bitmap?.asImageBitmap()?.let { PlatformImage(it) })
        } catch (e: Exception) {
            // Offline / timeout / 404 / etc.
            e.printStackTrace()
            onLoaded(null)
        }
    }
}



