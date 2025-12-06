package com.psc.elekha.di

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
import com.psc.elekha.database.repository.UserBranchRepository
import com.psc.elekha.database.repository.UserRepository
import com.psc.elekha.database.repository.UserResponseRepository
import com.psc.elekha.database.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
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
    single { UserRepository(get()) }
    single { UserResponseRepository(get()) }
    single { UsersRepository(get()) }





}