package com.psc.elekha.database.appdatabase

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.psc.elekha.database.entity.UserEntity
import com.psc.elekha.database.dao.UserDao
@Database(entities = [UserEntity::class],
    version = 1, exportSchema = false)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}

internal const val dbFileName = "eLekhaDatabase.db"
