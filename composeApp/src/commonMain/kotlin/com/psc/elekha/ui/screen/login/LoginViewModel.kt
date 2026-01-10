package com.psc.elekha.ui.screen.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.repository.UsersRepository
import com.psc.elekha.database.viewmodel.CustomerStatusViewModel
import com.psc.elekha.database.viewmodel.ImageDetailViewModel
import com.psc.elekha.database.viewmodel.KYCDocCategoryViewModel
import com.psc.elekha.database.viewmodel.KYCDocConfigurationViewModel
import com.psc.elekha.database.viewmodel.KYCDocumentViewModel
import com.psc.elekha.database.viewmodel.KYCStatusConditionViewModel
import com.psc.elekha.database.viewmodel.KYCStatusViewModel
import com.psc.elekha.database.viewmodel.MSTAssetsValuationViewModel
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
import com.psc.elekha.database.viewmodel.TabletMenuRoleViewModel
import com.psc.elekha.database.viewmodel.TabletMenuViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupStatusViewModel
import com.psc.elekha.database.viewmodel.UserBranchViewModel
import com.psc.elekha.database.viewmodel.UserContactDetailViewModel
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.response.MasterResponse
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.NetworkMonitor
import e_lekha.composeapp.generated.resources.*
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString


class LoginViewModel(

    private val mstComboBoxNViewModel: MSTComboBox_NViewModel,
    private val apiRepository: ApiRepository,
    private val usersViewModel: UsersViewModel,
    private val tabletMenuViewModel: TabletMenuViewModel,
    private val tabletMenuRoleViewModel: TabletMenuRoleViewModel,
    private val mstStateViewModel: MSTStateViewModel,
    private val mstDistrictViewModel: MSTDistrictViewModel,
    private val mstBranchViewModel: MSTBranchViewModel,
    private val mstVillageViewModel: MSTVillageViewModel,
    private val mstAssetsValuationViewModel: MSTAssetsValuationViewModel,
    private val mstBankViewModel: MSTBankViewModel,
    private val mstCenterViewModel: MSTCenterViewModel,
    private val mstPovertyStatusViewModel: MSTPovertyStatusViewModel,
    private val customerStatusViewModel: CustomerStatusViewModel,
    private val mstLoanTypeViewModel: MSTLoanTypeViewModel,
    private val mstLoanProductViewModel: MSTLoanProductViewModel,
    private val trainingGroupStatusViewModel: TrainingGroupStatusViewModel,
    private val mstMonthlyIncomeMarksViewModel: MSTMonthlyIncomeMarksViewModel,
    private val userBranchViewModel: UserBranchViewModel,
    private val mstLoanOfficerViewModel: MSTLoanOfficerViewModel,
    private val kycDocCategoryViewModel: KYCDocCategoryViewModel,
    private val kycDocConfigurationViewModel: KYCDocConfigurationViewModel,
    private val kycDocumentViewModel: KYCDocumentViewModel,
    private val kycStatusViewModel: KYCStatusViewModel,
    private val kycStatusConditionViewModel: KYCStatusConditionViewModel,
    private val imageDetailViewModel: ImageDetailViewModel,
    private val appPreferences: AppPreferences,
    private val userContactDetailViewModel: UserContactDetailViewModel,
    private val usersRepository: UsersRepository,
    private val networkMonitor: NetworkMonitor,
) : ViewModel() {

    private val _loginState = MutableStateFlow<APiState>(APiState.idle)
    private val _verifyState = MutableStateFlow<APiState>(APiState.idle)
    val loginState: StateFlow<APiState> = _loginState
    val verifyState: StateFlow<APiState> = _verifyState

    val isNetworkAvailable: StateFlow<Boolean> = networkMonitor.isConnected


    fun getAuthentication(username: String, password: String) {
        viewModelScope.launch {

            if (!isNetworkAvailable.value) {
                _loginState.value = APiState.error(getString(Res.string.no_internet))
                return@launch
            }

            _loginState.value = APiState.loading

            try {
                val response = apiRepository.getAuthentication(MasterRequest(username, password))

                if (response.status.value == 200) {
                    val body = response.body<String>()
                    if (body.length > 5) {
                        getMaster(username, password)
                    } else {
                        _loginState.value =
                            APiState.error(getString(Res.string.invalid_username_pwd))
                    }
                } else {
                    _loginState.value =
                        APiState.error(getString(Res.string.something_wentwrong))
                }

            } catch (e: Exception) {
                _loginState.value =
                    APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    fun getOTP(mobileNo: String) {
        viewModelScope.launch {
            try {
                val response = apiRepository.getOTP(mobileNo)
                val code = response.status.value
                if (code == 200) {
                    val body = response.body<String>()
                } else if (code == 401) {
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                } else {
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    fun verifyOTP(mobileNo: String, enteredOTP: String) {
        viewModelScope.launch {
            _verifyState.value = APiState.loading
            try {
                val response = apiRepository.verifyOTP(mobileNo, enteredOTP)
                val code = response.status.value
                if (code == 200) {
                    val body = response.body<String>()
                    if (body.equals("true", false)) {
                        _verifyState.value =
                            APiState.success(getString(Res.string.verified_success))
                    } else {
                        _verifyState.value = APiState.error(getString(Res.string.invalid_otp))
                    }
                } else if (code == 401) {
                    _verifyState.value = APiState.error(getString(Res.string.something_wentwrong))
                } else {
                    _verifyState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _verifyState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    fun getMaster(username: String, password: String) {
        viewModelScope.launch {
            try {
                val request = MasterRequest(username, password)
                val response = apiRepository.getMaster(request)

                val code = response.status.value
                if (code == 200) {
                    val body = response.body<MasterResponse>()
                    appPreferences.putString(AppSP.username, username)
                    appPreferences.putString(AppSP.password, password)
                    body.let {
                        usersViewModel.insertAllUsers(it.user)
                        val matchedUser = it.user.find { it.UserName.equals(username, ignoreCase = true) && it.Password == password }
                        val userId: String = matchedUser?.UserId?:""
                        appPreferences.putString(AppSP.userId, userId)
                        tabletMenuViewModel.insertAllTabletMenu(it.tabletMenu)
                        tabletMenuRoleViewModel.insertAllTabletMenuRole(it.tabletMenuRole)
                        mstStateViewModel.insertAllState(it.state)
                        mstDistrictViewModel.insertAllDistrict(it.district)
                        mstBranchViewModel.insertAllBranch(it.branch)
                        mstVillageViewModel.insertAllVillage(it.village)
                        mstAssetsValuationViewModel.insertAllAssetsValuation(it.assetValuation)
                        mstBankViewModel.insertAllBank(it.bank)
                        mstCenterViewModel.insertAllCenter(it.center)
                        mstPovertyStatusViewModel.insertAllPovertyStatus(it.povertyStatus)
                        customerStatusViewModel.insertAllCustomerStatus(it.customerStatus)
                        mstLoanTypeViewModel.insertAllLoanType(it.loanType)
                        trainingGroupStatusViewModel.insertAllTrainingGroupStatus(it.trainingGroupStatus)
                        mstMonthlyIncomeMarksViewModel.insertAllMonthlyIncomeMarks(it.monthlyIncomeMarks)
                        userBranchViewModel.insertAllUserBranch(it.userBranch)
                        mstLoanOfficerViewModel.insertAllLoanOfficer(it.loanOfficer)
                        kycDocCategoryViewModel.insertAllCategories(it.kycDocCategory)
                        kycDocConfigurationViewModel.insertAllConfigurations(it.kycDocConfiguration)
                        kycDocumentViewModel.insertAllDocuments(it.kycDocument)
                        kycStatusViewModel.insertAllStatus(it.kycStatus)
                        kycStatusConditionViewModel.insertAllConditions(it.kycStatusCondition)
                        mstComboBoxNViewModel.insertAllComboBox(it.mstComboBoxN)
                        mstLoanProductViewModel.insertAllLoanProduct(it.mstLoanProduct)

                        imageDetailViewModel.insertAllImageDetail(it.imageDetailEntity)

                        userContactDetailViewModel.insertAllUserContactDetail(it.userContactDetails)
                        _loginState.value = APiState.success("Login successfully")
                    }

                } else if (code == 401) {
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                } else {
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

}
