package com.psc.elekha.database.appdatabase

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.microlekha.psc.dao.MSTMonthlyIncomeMarksDao
import com.psc.elekha.database.dao.AdminDashboardDao
import com.psc.elekha.database.dao.BranchManagerDashbordDao
import com.psc.elekha.database.dao.CustomerDao
import com.psc.elekha.database.dao.CustomerDefaultDao
import com.psc.elekha.database.dao.CustomerExistingLoanDetailDao
import com.psc.elekha.database.dao.CustomerFamilyMemberDetailsDao
import com.psc.elekha.database.dao.CustomerLoanDisbursementDao
import com.psc.elekha.database.dao.CustomerStatusDao
import com.psc.elekha.database.dao.CustomerTransactionDataDao
import com.psc.elekha.database.dao.CustomerTransactionsDetailsDao
import com.psc.elekha.database.dao.ImageDetailDao
import com.psc.elekha.database.dao.ImageTrackingRecordDao
import com.psc.elekha.database.dao.KYCDocCategoryDao
import com.psc.elekha.database.dao.KYCDocConfigurationDao
import com.psc.elekha.database.dao.KYCDocumentDao
import com.psc.elekha.database.dao.KYCStatusConditionDao
import com.psc.elekha.database.dao.KYCStatusDao
import com.psc.elekha.database.dao.LoanClosureDao
import com.psc.elekha.database.dao.LoanRepaymentDao
import com.psc.elekha.database.dao.LoanScheduleDao
import com.psc.elekha.database.dao.LoanofficerDashBoardDataDao
import com.psc.elekha.database.dao.MSTAssetsValuationDao
import com.psc.elekha.database.dao.MSTBankBranchDao
import com.psc.elekha.database.dao.MSTBankDao
import com.psc.elekha.database.dao.MSTBranchDao
import com.psc.elekha.database.dao.MSTCenterDao
import com.psc.elekha.database.dao.MSTComboBox_NDao
import com.psc.elekha.database.dao.MSTDistrictDao
import com.psc.elekha.database.dao.MSTLoanOfficerDao
import com.psc.elekha.database.dao.MSTLoanProductDao
import com.psc.elekha.database.dao.MSTLoanTypeDao
import com.psc.elekha.database.dao.MSTMFILoanProductDao
import com.psc.elekha.database.dao.MSTPovertyStatusDao
import com.psc.elekha.database.dao.MSTStateDao
import com.psc.elekha.database.dao.MSTVillageDao
import com.psc.elekha.database.dao.RegistrationStatusDao
import com.psc.elekha.database.dao.TabletMenuDao
import com.psc.elekha.database.dao.TabletMenuRoleDao
import com.psc.elekha.database.dao.TrainingGroupDao
import com.psc.elekha.database.dao.TrainingGroupStatusDao
import com.psc.elekha.database.dao.UserBranchDao
import com.psc.elekha.database.dao.UserResponseDao
import com.psc.elekha.database.dao.UsersDao
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerLoanDisbursementEntity
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.CustomerTransactionDataEntity
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.entity.ImageTrackingRecordEntity
import com.psc.elekha.database.entity.KYCDocCategoryEntity
import com.psc.elekha.database.entity.KYCDocConfigurationEntity
import com.psc.elekha.database.entity.KYCDocumentEntity
import com.psc.elekha.database.entity.KYCStatusConditionEntity
import com.psc.elekha.database.entity.KYCStatusEntity
import com.psc.elekha.database.entity.LoanClosureEntity
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.entity.LoanScheduleEntity
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity
import com.psc.elekha.database.entity.MSTAssetsValuationEntity
import com.psc.elekha.database.entity.MSTBankBranchEntity
import com.psc.elekha.database.entity.MSTBankEntity
import com.psc.elekha.database.entity.MSTBranchEntity
import com.psc.elekha.database.entity.MSTCenterEntity
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.entity.MSTDistrictEntity
import com.psc.elekha.database.entity.MSTLoanOfficerEntity
import com.psc.elekha.database.entity.MSTLoanProductEntity
import com.psc.elekha.database.entity.MSTLoanTypeEntity
import com.psc.elekha.database.entity.MSTMFILoanProductEntity
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity
import com.psc.elekha.database.entity.MSTPovertyStatusEntity
import com.psc.elekha.database.entity.MSTStateEntity
import com.psc.elekha.database.entity.MSTVillageEntity
import com.psc.elekha.database.entity.MstLoanDetailsEntity
import com.psc.elekha.database.entity.RegistrationStatusEntity
import com.psc.elekha.database.entity.TabletMenuEntity
import com.psc.elekha.database.entity.TabletMenuRoleEntity
import com.psc.elekha.database.entity.TrainingGroup
import com.psc.elekha.database.entity.UserBranchEntity
import com.psc.elekha.database.entity.UserResponseEntity
import com.psc.elekha.database.entity.UsersEntity
import com.psc.elekha.database.entity.TrainingGroupStatusEntity
import com.psc.elekha.database.entity.AdminDashbordEntity
import com.psc.elekha.database.entity.BranchManagerDashbordEntity
@Database(entities = [
    CustomerStatusEntity::class, MSTAssetsValuationEntity::class, MSTBankBranchEntity::class, MSTBankEntity::class,
    MSTBranchEntity::class, MSTCenterEntity::class, MSTComboBox_NEntity::class, MSTDistrictEntity::class,
    MSTLoanOfficerEntity::class, MSTLoanProductEntity::class, MSTLoanTypeEntity::class, MSTMFILoanProductEntity::class,
    MSTMonthlyIncomeMarksEntity::class, MSTPovertyStatusEntity::class, MSTStateEntity::class, MSTVillageEntity::class,
    TabletMenuEntity::class, TabletMenuRoleEntity::class, UserBranchEntity::class,
    UsersEntity::class, KYCDocCategoryEntity::class, KYCDocConfigurationEntity::class, KYCDocumentEntity::class,
    KYCStatusEntity::class, KYCStatusConditionEntity::class, CustomerEntity::class, CustomerExistingLoanDetailEntity::class,
    CustomerFamilyMemberDetailsEntity::class, LoanClosureEntity::class, LoanRepaymentEntity::class, LoanScheduleEntity::class,
    CustomerLoanDisbursementEntity::class, ImageTrackingRecordEntity::class, ImageDetailEntity::class, UserResponseEntity::class,
    CustomerDefaultEntity::class, MstLoanDetailsEntity::class, RegistrationStatusEntity::class, CustomerTransactionDataEntity::class,
    CustomerTransactionsDetailsEntity::class, TrainingGroup::class, LoanofficerDashBoardDataEntity::class,
    AdminDashbordEntity::class, BranchManagerDashbordEntity::class, TrainingGroupStatusEntity::class],
    version = 1, exportSchema = true)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun customerStatusDao(): CustomerStatusDao
    abstract fun mSTAssetsValuationDao(): MSTAssetsValuationDao
    abstract fun mSTBankBranchDao(): MSTBankBranchDao
    abstract fun mSTBankDao(): MSTBankDao
    abstract fun mSTBranchDao(): MSTBranchDao
    abstract fun mSTCenterDao(): MSTCenterDao
    abstract fun mSTComboBox_NDao(): MSTComboBox_NDao
    abstract fun mSTDistrictDao(): MSTDistrictDao
    abstract fun mSTLoanOfficerDao(): MSTLoanOfficerDao
    abstract fun mSTLoanProductDao(): MSTLoanProductDao
    abstract fun mSTLoanTypeDao(): MSTLoanTypeDao
    abstract fun mSTMFILoanProductDao(): MSTMFILoanProductDao
    abstract fun mSTMonthlyIncomeMarksDao(): MSTMonthlyIncomeMarksDao
    abstract fun mSTPovertyStatusDao(): MSTPovertyStatusDao
    abstract fun mSTStateDao(): MSTStateDao
    abstract fun mSTVillageDao(): MSTVillageDao
    abstract fun tabletMenuDao(): TabletMenuDao
    abstract fun tabletMenuRoleDao(): TabletMenuRoleDao
    abstract fun userBranchDao(): UserBranchDao
    abstract fun usersDao(): UsersDao
    abstract fun kYCDocCategoryDao(): KYCDocCategoryDao
    abstract fun kYCDocConfigurationDao(): KYCDocConfigurationDao
    abstract fun kYCDocumentDao(): KYCDocumentDao
    abstract fun kYCStatusDao(): KYCStatusDao
    abstract fun kYCStatusConditionDao(): KYCStatusConditionDao
    abstract fun customerDao(): CustomerDao
    abstract fun customerExistingLoanDetailDao(): CustomerExistingLoanDetailDao
    abstract fun customerFamilyMemberDetailsDao(): CustomerFamilyMemberDetailsDao
    abstract fun loanClosureDao(): LoanClosureDao
    abstract fun loanRepaymentDao(): LoanRepaymentDao
    abstract fun loanScheduleDao(): LoanScheduleDao
    abstract fun customerLoanDisbursementDao(): CustomerLoanDisbursementDao
    abstract fun imageTrackingRecordDao(): ImageTrackingRecordDao
    abstract fun imageDetailDao(): ImageDetailDao
    abstract fun userResponseDao(): UserResponseDao
    abstract fun customerDefaultDao(): CustomerDefaultDao
    abstract fun registrationStatusDao(): RegistrationStatusDao
    abstract fun customerTransactionDataDao(): CustomerTransactionDataDao
    abstract fun customerTransactionsDetailsDao(): CustomerTransactionsDetailsDao
    abstract fun trainingGroupDao(): TrainingGroupDao
    abstract fun loanofficerDashBoardDataDao(): LoanofficerDashBoardDataDao
    abstract fun admissionDashboardDao(): AdminDashboardDao
    abstract fun branchManagerDashboardDao(): BranchManagerDashbordDao
    abstract fun trainingGroupStatusDao(): TrainingGroupStatusDao

}

internal const val dbFileName = "eLekhaDatabase.db"
