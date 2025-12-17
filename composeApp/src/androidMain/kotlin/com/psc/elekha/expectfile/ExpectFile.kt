package com.psc.elekha.expectfile

import android.app.Application
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import org.koin.mp.KoinPlatform
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val appContext = KoinPlatform.getKoin().get<Application>()
    val dbFile = appContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
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

