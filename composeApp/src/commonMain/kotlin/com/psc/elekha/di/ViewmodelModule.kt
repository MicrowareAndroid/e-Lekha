package com.psc.elekha.di



import com.psc.elekha.database.viewmodel.CustomerDefaultViewModel
import com.psc.elekha.database.viewmodel.CustomerExistingLoanDetailViewModel
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.database.viewmodel.CustomerLoanDisbursementViewModel
import com.psc.elekha.database.viewmodel.CustomerMovableAssetsViewModel
import com.psc.elekha.database.viewmodel.CustomerStatusViewModel
import com.psc.elekha.database.viewmodel.CustomerTransactionDataViewModel
import com.psc.elekha.database.viewmodel.CustomerTransactionsDetailsViewModel
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.database.viewmodel.ImageDetailViewModel
import com.psc.elekha.database.viewmodel.ImageTrackingRecordViewModel
import com.psc.elekha.database.viewmodel.KYCDocCategoryViewModel
import com.psc.elekha.database.viewmodel.KYCDocConfigurationViewModel
import com.psc.elekha.database.viewmodel.KYCDocumentViewModel
import com.psc.elekha.database.viewmodel.KYCStatusConditionViewModel
import com.psc.elekha.database.viewmodel.KYCStatusViewModel
import com.psc.elekha.database.viewmodel.LoanClosureViewModel
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.database.viewmodel.LoanScheduleViewModel
import com.psc.elekha.database.viewmodel.MSTAssetsValuationViewModel
import com.psc.elekha.database.viewmodel.MSTBankBranchViewModel
import com.psc.elekha.database.viewmodel.MSTBankViewModel
import com.psc.elekha.database.viewmodel.MSTBranchViewModel
import com.psc.elekha.database.viewmodel.MSTCenterViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.database.viewmodel.MSTDistrictViewModel
import com.psc.elekha.database.viewmodel.MSTLoanOfficerViewModel
import com.psc.elekha.database.viewmodel.MSTLoanProductViewModel
import com.psc.elekha.database.viewmodel.MSTLoanTypeViewModel
import com.psc.elekha.database.viewmodel.MSTMonthlyIncomeMarksViewModel
import com.psc.elekha.database.viewmodel.MSTPovertyStatusViewModel
import com.psc.elekha.database.viewmodel.MSTStateViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.database.viewmodel.RegistrationStatusViewModel
import com.psc.elekha.database.viewmodel.TabletMenuRoleViewModel
import com.psc.elekha.database.viewmodel.TabletMenuViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupMemberViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupStatusViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupViewModel
import com.psc.elekha.database.viewmodel.UserBranchViewModel
import com.psc.elekha.database.viewmodel.UserContactDetailViewModel
import com.psc.elekha.database.viewmodel.UserResponseViewModel
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.ui.screen.bankdetails.BankDetailViewModel
import com.psc.elekha.ui.screen.familydetails.FamilyMemberViewModel
import com.psc.elekha.ui.screen.gtrlist.GtrViewModel
import com.psc.elekha.ui.screen.kycdetails.KycDetailViewModel
import com.psc.elekha.ui.screen.login.LoginViewModel
import com.psc.elekha.ui.screen.personaldetails.PersonalDetailViewModel
import com.psc.elekha.ui.screen.repayment.RepaymentViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf

import org.koin.dsl.module

val viewmodelModule = module {


    viewModelOf(::CustomerViewModel)
    viewModelOf(::CustomerDefaultViewModel)
    viewModelOf(::CustomerExistingLoanDetailViewModel)
    viewModelOf(::CustomerFamilyMemberDetailsViewModel)
    viewModelOf(::CustomerLoanDisbursementViewModel)
    viewModelOf(::CustomerStatusViewModel)
    viewModelOf(::CustomerTransactionDataViewModel)
    viewModelOf(::CustomerTransactionsDetailsViewModel)
    viewModelOf(::ImageDetailViewModel)
    viewModelOf(::ImageTrackingRecordViewModel)
    viewModelOf(::KYCDocCategoryViewModel)
    viewModelOf(::KYCDocConfigurationViewModel)
    viewModelOf(::KYCDocumentViewModel)
    viewModelOf(::KYCStatusConditionViewModel)
    viewModelOf(::KYCStatusViewModel)
    viewModelOf(::LoanClosureViewModel)
    viewModelOf(::LoanRepaymentViewModel)
    viewModelOf(::LoanScheduleViewModel)
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
    viewModelOf(::KycDetailViewModel)
    viewModelOf(::BankDetailViewModel)
    viewModelOf(::PersonalDetailViewModel)
    viewModelOf(::TrainingGroupViewModel)
    viewModelOf(::UserContactDetailViewModel)
    viewModelOf(::TrainingGroupStatusViewModel)
    viewModelOf(::MSTLoanTypeViewModel)
    viewModelOf(::FamilyMemberViewModel)
    viewModelOf(::RepaymentViewModel)
    viewModelOf(::TrainingGroupMemberViewModel)
    viewModelOf(::RepaymentViewModel)
    viewModelOf(::CustomerMovableAssetsViewModel)
    viewModel {
        LoginViewModel(

            mstComboBoxNViewModel = get(),
            apiRepository = get(),
            usersViewModel = get(),
            tabletMenuViewModel = get(),
            tabletMenuRoleViewModel = get(),
            mstStateViewModel = get(),
            mstDistrictViewModel = get(),
            mstBranchViewModel = get(),
            mstVillageViewModel = get(),
            mstAssetsValuationViewModel = get(),
            mstBankViewModel = get(),
            mstCenterViewModel = get(),
            mstPovertyStatusViewModel = get(),
            customerStatusViewModel = get(),
            mstLoanTypeViewModel = get(),
            trainingGroupStatusViewModel = get(),
            mstMonthlyIncomeMarksViewModel = get(),
            userBranchViewModel = get(),
            mstLoanOfficerViewModel = get(),
            kycDocCategoryViewModel = get(),
            kycDocConfigurationViewModel = get(),
            kycDocumentViewModel = get(),
            kycStatusViewModel = get(),
            kycStatusConditionViewModel = get(),
            appPreferences = get()
        )
    }
    viewModel {
        GtrViewModel(
            apiRepository = get(),
            trainingGroupViewModel = get(),
            trainingGroupMemberViewModel = get()
        )
    }

}