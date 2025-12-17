package com.psc.elekha.expectfile

import androidx.compose.runtime.Composable
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.utils.AppPermission

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

expect class PermissionManager {

    @Composable
    fun hasPermission(permission: AppPermission): Boolean

    @Composable
    fun requestPermission(
        permission: AppPermission,
        onResult: (Boolean) -> Unit
    )
}