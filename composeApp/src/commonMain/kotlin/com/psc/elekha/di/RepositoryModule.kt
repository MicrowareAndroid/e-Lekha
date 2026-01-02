package com.psc.elekha.di

import CustomerRepository
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.apicall.ApiService
import com.psc.elekha.database.repository.CustomerDefaultRepository
import com.psc.elekha.database.repository.CustomerExistingLoanDetailRepository
import com.psc.elekha.database.repository.CustomerFamilyMemberDetailsRepository
import com.psc.elekha.database.repository.CustomerLoanDisbursementRepository
import com.psc.elekha.database.repository.CustomerStatusRepository
import com.psc.elekha.database.repository.CustomerTransactionDataRepository
import com.psc.elekha.database.repository.CustomerTransactionsDetailsRepository
import com.psc.elekha.database.repository.ImageDetailRepository
import com.psc.elekha.database.repository.ImageTrackingRecordRepository
import com.psc.elekha.database.repository.KYCDocCategoryRepository
import com.psc.elekha.database.repository.KYCDocConfigurationRepository
import com.psc.elekha.database.repository.KYCDocumentRepository
import com.psc.elekha.database.repository.KYCStatusConditionRepository
import com.psc.elekha.database.repository.KYCStatusRepository
import com.psc.elekha.database.repository.LoanClosureRepository
import com.psc.elekha.database.repository.LoanRepaymentRepository
import com.psc.elekha.database.repository.LoanScheduleRepository
import com.psc.elekha.database.repository.MSTAssetsValuationRepository
import com.psc.elekha.database.repository.MSTBankBranchRepository
import com.psc.elekha.database.repository.MSTBankRepository
import com.psc.elekha.database.repository.MSTBranchRepository
import com.psc.elekha.database.repository.MSTCenterRepository
import com.psc.elekha.database.repository.MSTComboBox_NRepository
import com.psc.elekha.database.repository.MSTDistrictRepository
import com.psc.elekha.database.repository.MSTLoanOfficerRepository
import com.psc.elekha.database.repository.MSTLoanProductRepository
import com.psc.elekha.database.repository.MSTLoanTypeRepository
import com.psc.elekha.database.repository.MSTMFILoanProductRepository
import com.psc.elekha.database.repository.MSTMonthlyIncomeMarksRepository
import com.psc.elekha.database.repository.MSTPovertyStatusRepository
import com.psc.elekha.database.repository.MSTStateRepository
import com.psc.elekha.database.repository.MSTVillageRepository
import com.psc.elekha.database.repository.RegistrationStatusRepository
import com.psc.elekha.database.repository.TabletMenuRepository
import com.psc.elekha.database.repository.TabletMenuRoleRepository
import com.psc.elekha.database.repository.TrainingGroupMemberRepository
import com.psc.elekha.database.repository.TrainingGroupRepository
import com.psc.elekha.database.repository.TrainingGroupStatusRepository
import com.psc.elekha.database.repository.UserBranchRepository
import com.psc.elekha.database.repository.UserContactDetailRepository
import com.psc.elekha.database.repository.UserResponseRepository
import com.psc.elekha.database.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ApiService(get()) }
    single { ApiRepository(get()) }
    single { CustomerRepository( get())  }
    single { CustomerDefaultRepository( get()) }
    single { CustomerExistingLoanDetailRepository( get()) }
    single { CustomerFamilyMemberDetailsRepository( get()) }
    single { CustomerLoanDisbursementRepository( get()) }
    single { CustomerStatusRepository( get()) }
    single { CustomerTransactionDataRepository( get()) }
    single { CustomerTransactionsDetailsRepository( get()) }
    single { ImageDetailRepository( get()) }
    single { ImageTrackingRecordRepository( get()) }
    single { KYCDocCategoryRepository( get()) }
    single { KYCDocConfigurationRepository( get()) }
    single { KYCDocumentRepository( get()) }
    single { KYCStatusConditionRepository( get()) }
    single { KYCStatusRepository( get()) }
    single { LoanClosureRepository( get()) }
    single { LoanRepaymentRepository( get()) }
    single { LoanScheduleRepository( get()) }
    single { MSTAssetsValuationRepository(get()) }
    single { MSTBankBranchRepository(get()) }
    single { MSTBankRepository(get()) }
    single { MSTBranchRepository(get()) }
    single { MSTCenterRepository(get()) }
    single { MSTComboBox_NRepository(get()) }
    single { MSTDistrictRepository(get()) }
    single { MSTLoanOfficerRepository(get()) }
    single { MSTLoanProductRepository(get()) }
    single { MSTLoanTypeRepository(get()) }
    single { MSTMFILoanProductRepository(get()) }
    single { MSTMonthlyIncomeMarksRepository(get()) }
    single { MSTPovertyStatusRepository(get()) }
    single { MSTStateRepository(get()) }
    single { MSTVillageRepository(get()) }
    single { RegistrationStatusRepository(get()) }
    single { TabletMenuRepository(get()) }
    single { TabletMenuRoleRepository(get()) }
    single { UserBranchRepository(get()) }
    single { UserResponseRepository(get()) }
    single { UsersRepository(get()) }
    single { TrainingGroupRepository(get()) }
    single { UserContactDetailRepository(get()) }
    single { TrainingGroupStatusRepository(get()) }
    single { TrainingGroupMemberRepository(get()) }





}