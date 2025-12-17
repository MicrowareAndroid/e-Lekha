package com.psc.elekha.expectfile


import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import platform.Foundation.NSHomeDirectory

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/${dbFileName}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    )
}

actual class DatabaseExporter {
    actual fun exportAndShare(dbBaseName: String) {
        // For now, do nothing
    }
}