package com.psc.elekha.di

import com.psc.elekha.database.viewmodel.MSTAssetsValuationViewModel
import com.psc.elekha.database.viewmodel.MSTBankBranchViewModel
import com.psc.elekha.database.viewmodel.MSTBankViewModel
import com.psc.elekha.database.viewmodel.MSTBranchViewModel
import com.psc.elekha.database.viewmodel.MSTCenterViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.database.viewmodel.MSTDistrictViewModel
import com.psc.elekha.database.viewmodel.MSTLoanOfficerViewModel
import com.psc.elekha.database.viewmodel.MSTLoanProductViewModel
import com.psc.elekha.database.viewmodel.MSTMonthlyIncomeMarksViewModel
import com.psc.elekha.database.viewmodel.MSTPovertyStatusViewModel
import com.psc.elekha.database.viewmodel.MSTStateViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.database.viewmodel.RegistrationStatusViewModel
import com.psc.elekha.database.viewmodel.TabletMenuRoleViewModel
import com.psc.elekha.database.viewmodel.TabletMenuViewModel
import com.psc.elekha.database.viewmodel.UserBranchViewModel
import com.psc.elekha.database.viewmodel.UserResponseViewModel
import com.psc.elekha.database.viewmodel.UserViewmodel
import com.psc.elekha.database.viewmodel.UsersViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewmodelModule = module {
    viewModelOf(::MSTAssetsValuationViewModel)
    viewModelOf(::MSTBankBranchViewModel)
    viewModelOf(::MSTBankViewModel)
    viewModelOf(::MSTBranchViewModel)
    viewModelOf(::MSTCenterViewModel)
    viewModelOf(::MSTComboBox_NViewModel)
    viewModelOf(::MSTDistrictViewModel)
    viewModelOf(::MSTLoanOfficerViewModel)
    viewModelOf(::MSTLoanProductViewModel)
    viewModelOf(::MSTMonthlyIncomeMarksViewModel)
    viewModelOf(::MSTPovertyStatusViewModel)
    viewModelOf(::MSTStateViewModel)
    viewModelOf(::MSTVillageViewModel)
    viewModelOf(::RegistrationStatusViewModel)
    viewModelOf(::TabletMenuRoleViewModel)
    viewModelOf(::TabletMenuViewModel)
    viewModelOf(::UserBranchViewModel)
    viewModelOf(::UsersViewModel)
    viewModelOf(::UserResponseViewModel)
    viewModelOf(::UserViewmodel)






}