package com.psc.elekha.expectfile

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import com.psc.elekha.utils.AppPermission
import org.koin.mp.KoinPlatform

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val appContext = KoinPlatform.getKoin().get<Application>()
    val dbFile = appContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}

actual class PermissionManager {

    @Composable
    actual fun hasPermission(permission: AppPermission): Boolean {
        val context = LocalContext.current
        val androidPermission = permission.toAndroidPermission()
        return ContextCompat.checkSelfPermission(
            context,
            androidPermission
        ) == PackageManager.PERMISSION_GRANTED
    }

    @Composable
    actual fun requestPermission(
        permission: AppPermission,
        onResult: (Boolean) -> Unit
    ) {
        val context = LocalContext.current
        val androidPermission = permission.toAndroidPermission()

        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            onResult(granted)
        }

        LaunchedEffect(Unit) {
            if (
                ContextCompat.checkSelfPermission(
                    context,
                    androidPermission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                launcher.launch(androidPermission)
            } else {
                onResult(true)
            }
        }
    }
}

private fun AppPermission.toAndroidPermission(): String =
    when (this) {
        AppPermission.CAMERA -> Manifest.permission.CAMERA
        AppPermission.STORAGE -> Manifest.permission.READ_EXTERNAL_STORAGE
        AppPermission.LOCATION -> Manifest.permission.ACCESS_FINE_LOCATION
        AppPermission.MICROPHONE -> Manifest.permission.RECORD_AUDIO
    }