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
    single { get<AppDatabase>().customerDao() }
    single { get<AppDatabase>().customerDefaultDao() }
    single { get<AppDatabase>().customerExistingLoanDetailDao() }
    single { get<AppDatabase>().customerFamilyMemberDetailsDao() }
    single { get<AppDatabase>().customerLoanDisbursementDao() }
    single { get<AppDatabase>().customerStatusDao() }
    single { get<AppDatabase>().customerTransactionDataDao() }
    single { get<AppDatabase>().customerTransactionsDetailsDao() }
    single { get<AppDatabase>().imageDetailDao() }
    single { get<AppDatabase>().imageTrackingRecordDao() }
    single { get<AppDatabase>().kYCDocCategoryDao() }
    single { get<AppDatabase>().kYCDocConfigurationDao() }
    single { get<AppDatabase>().kYCDocumentDao() }
    single { get<AppDatabase>().kYCStatusConditionDao() }
    single { get<AppDatabase>().kYCStatusDao() }
    single { get<AppDatabase>().loanClosureDao() }
    single { get<AppDatabase>().loanRepaymentDao() }
    single { get<AppDatabase>().loanScheduleDao() }
    single { get<AppDatabase>().mSTAssetsValuationDao() }
    single { get<AppDatabase>().mSTBankBranchDao() }
    single { get<AppDatabase>().mSTBankDao() }
    single { get<AppDatabase>().mSTBranchDao() }
    single { get<AppDatabase>().mSTCenterDao() }
    single { get<AppDatabase>().mSTComboBox_NDao() }
    single { get<AppDatabase>().mSTDistrictDao() }
    single { get<AppDatabase>().mSTLoanOfficerDao() }
    single { get<AppDatabase>().mSTLoanProductDao() }
    single { get<AppDatabase>().mSTLoanTypeDao() }
    single { get<AppDatabase>().mSTMFILoanProductDao() }
    single { get<AppDatabase>().mSTMonthlyIncomeMarksDao() }
    single { get<AppDatabase>().mSTPovertyStatusDao() }
    single { get<AppDatabase>().mSTStateDao() }
    single { get<AppDatabase>().mSTVillageDao() }
    single { get<AppDatabase>().registrationStatusDao()}
    single { get<AppDatabase>().tabletMenuDao() }
    single { get<AppDatabase>().tabletMenuRoleDao() }
    single { get<AppDatabase>().userBranchDao() }
    single { get<AppDatabase>().userResponseDao() }
    single { get<AppDatabase>().usersDao() }
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