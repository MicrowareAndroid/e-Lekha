package com.psc.elekha.expectfile

import androidx.compose.runtime.Composable
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.utils.AppPermission

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>


expect class PermissionManager {
    suspend fun checkPermission(permission: AppPermission): PermissionStatus
    suspend fun requestPermission(permission: AppPermission): PermissionStatus
    suspend fun requestMultiplePermissions(permissions: List<AppPermission>): Map<AppPermission, PermissionStatus>
    fun openAppSettings()
}

enum class PermissionStatus {
    GRANTED,
    DENIED,
    DENIED_PERMANENTLY,
    NOT_DETERMINED
}


expect class DatabaseExporter() {
    fun exportAndShare(dbBaseName: String)

}

