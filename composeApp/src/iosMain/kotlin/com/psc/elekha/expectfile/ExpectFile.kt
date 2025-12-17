package com.psc.elekha.expectfile


import androidx.compose.runtime.Composable
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import com.psc.elekha.utils.AppPermission
import platform.Foundation.NSHomeDirectory

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/${dbFileName}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    )
}

<<<<<<< HEAD
actual class PermissionManager {

    @Composable
    actual fun hasPermission(permission: AppPermission): Boolean {
        return true
    }

    @Composable
    actual fun requestPermission(
        permission: AppPermission,
        onResult: (Boolean) -> Unit
    ) {
        onResult(true)
    }
}
=======
actual class DatabaseExporter {
    actual fun exportAndShare(dbBaseName: String) {
        // For now, do nothing
    }
}
>>>>>>> 600e007581c4eacc7ef0adb63cea590ee8001a8a
