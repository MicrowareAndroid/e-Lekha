package com.psc.elekha.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.expectfile.getDatabaseBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val databaseModule = module {
    single { getRoomDatabase(getDatabaseBuilder()) }
    single { get<AppDatabase>().userDao() }
//    single { get<AppDatabase>().lookUpDao() }
//    single { get<AppDatabase>().lookUpvalueDao() }
//    single { get<AppDatabase>().caseCategoryQuestionDao() }
//    single { get<AppDatabase>().caseFlagDao() }
//    single { get<AppDatabase>().caseReportingDao() }
//    single { get<AppDatabase>().criminalCaseTrackDao() }
//    single { get<AppDatabase>().crossCuttingFlagDao() }
//    single { get<AppDatabase>().mstLanguageDao() }
//    single { get<AppDatabase>().subCategoryDao() }
//    single { get<AppDatabase>().trackSubCategoryDao() }
//    single { get<AppDatabase>().categoryDao() }
//    single { get<AppDatabase>().stateDao() }
//    single { get<AppDatabase>().distictDao() }
//    single { get<AppDatabase>().blockDao() }
//    single { get<AppDatabase>().profileComplainantDao() }
//    single { get<AppDatabase>().caseIdentifierDao() }
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}