package com.psc.elekha.expectfile

import androidx.compose.runtime.Composable
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.utils.AppPermission

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

<<<<<<< HEAD
expect class PermissionManager {

    @Composable
    fun hasPermission(permission: AppPermission): Boolean

    @Composable
    fun requestPermission(
        permission: AppPermission,
        onResult: (Boolean) -> Unit
    )
=======
expect class DatabaseExporter() {
    fun exportAndShare(dbBaseName: String)
>>>>>>> 600e007581c4eacc7ef0adb63cea590ee8001a8a
}