package com.psc.elekha.database.appdatabase

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import platform.Foundation.NSHomeDirectory

actual object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    actual override fun initialize(): AppDatabase {
        val dbFilePath = NSHomeDirectory() + "/$dbFileName"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFilePath
        ).build()
    }
}
