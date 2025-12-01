package com.psc.elekha.expectfile

import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>