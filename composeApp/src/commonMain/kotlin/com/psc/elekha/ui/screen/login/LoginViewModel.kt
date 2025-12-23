package com.psc.elekha.ui.screen.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.dao.TrainingGroupStatusDao
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.entity.UsersEntity
import com.psc.elekha.database.viewmodel.CustomerStatusViewModel
import com.psc.elekha.database.viewmodel.CustomerViewModel
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
import com.psc.elekha.database.viewmodel.MSTLoanTypeViewModel
import com.psc.elekha.database.viewmodel.MSTMonthlyIncomeMarksViewModel
import com.psc.elekha.database.viewmodel.MSTPovertyStatusViewModel
import com.psc.elekha.database.viewmodel.MSTStateViewModel
import com.psc.elekha.database.viewmodel.MSTVillageViewModel
import com.psc.elekha.database.viewmodel.TabletMenuRoleViewModel
import com.psc.elekha.database.viewmodel.TabletMenuViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupStatusViewModel
import com.psc.elekha.database.viewmodel.UserBranchViewModel
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.response.MasterResponse
import com.psc.elekha.utils.MasterXmlParser
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import e_lekha.composeapp.generated.resources.something_wentwrong
import io.ktor.client.call.body
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.jetbrains.compose.resources.getString


class LoginViewModel(
    private val mSTComboBoxNViewModel: MSTComboBox_NViewModel,
    private val apiRepository: ApiRepository,

   private val usersViewModel: UsersViewModel,
    /*private val tabletMenuViewModel: TabletMenuViewModel,
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
   private val trainingGroupStatusViewModel: TrainingGroupStatusViewModel,
   private val mstMonthlyIncomeMarksViewModel: MSTMonthlyIncomeMarksViewModel,
   private val userBranchViewModel: UserBranchViewModel,
   private val mstLoanOfficerViewModel: MSTLoanOfficerViewModel,
   private val kycDocCategoryViewModel: KYCDocCategoryViewModel,
   private val kycDocConfigurationViewModel: KYCDocConfigurationViewModel,
   private val kycDocumentViewModel: KYCDocumentViewModel,
   private val kycStatusViewModel: KYCStatusViewModel,
   private val kycStatusConditionViewModel: KYCStatusConditionViewModel,*/
) : ViewModel() {

    private val _loginState = MutableStateFlow<APiState>(APiState.idle)
    val loginState: StateFlow<APiState> = _loginState


    fun updateData() {
        val maritalStatusList = listOf(
            MSTComboBox_NEntity(1, "Single", 1, "en", false),
            MSTComboBox_NEntity(2, "Married", 1, "en", false),
            MSTComboBox_NEntity(3, "Divorced", 1, "en", false),
            MSTComboBox_NEntity(1, "12th", 2, "en", false),
            MSTComboBox_NEntity(2, "Graduation", 2, "en", false),
            MSTComboBox_NEntity(3, "Post Graduation", 2, "en", false),
            MSTComboBox_NEntity(1, "Hindu", 3, "en", false),
            MSTComboBox_NEntity(2, "Muslim", 3, "en", false),
            MSTComboBox_NEntity(1, "Business", 4, "en", false),
            MSTComboBox_NEntity(2,  "Study Loan", 4, "en", false),
            MSTComboBox_NEntity(2,  "Home Loan", 4, "en", false),
            MSTComboBox_NEntity(1, "Brother", 5, "en", false),
            MSTComboBox_NEntity(2,   "Husband", 5, "en", false),
            MSTComboBox_NEntity(1, "West", 6, "en", false),
            MSTComboBox_NEntity(2,   "South" , 6, "en", false),
            MSTComboBox_NEntity(1, "Delhi", 7, "en", false),
            MSTComboBox_NEntity(2,   "Punjab" , 7, "en", false),
            MSTComboBox_NEntity(1, "Male", 8, "en", false),
            MSTComboBox_NEntity(2, "Female", 8, "en", false),
            MSTComboBox_NEntity(3, "Other", 8, "en", false),
            MSTComboBox_NEntity(1, "Doctor", 9, "en", false),
            MSTComboBox_NEntity(2, "Teacher", 9, "en", false),
            MSTComboBox_NEntity(3, "Driver", 9, "en", false),
            MSTComboBox_NEntity(4, "Engineer", 9, "en", false),
            MSTComboBox_NEntity(5, "Business", 9, "en", false),
            MSTComboBox_NEntity(6, "Other", 9, "en", false),
            MSTComboBox_NEntity(1, "Card", 10, "en", false),
            MSTComboBox_NEntity(2, "Bank", 10, "en", false),
            MSTComboBox_NEntity(1, "Truck", 10, "en", false),
            MSTComboBox_NEntity(1, "SBI", 11, "en", false),
            MSTComboBox_NEntity(2, "HDFC", 11, "en", false),
            MSTComboBox_NEntity(3, "AXIS", 11, "en", false),
            MSTComboBox_NEntity(1, "SBI Delhi", 12, "en", false),
            MSTComboBox_NEntity(2, "SBI Gurgaon", 12, "en", false),
            MSTComboBox_NEntity(3, "HDFC Delhi", 12, "en", false),
            MSTComboBox_NEntity(4, "HDFC Gurgaon", 12, "en", false),
            MSTComboBox_NEntity(5, "AXIS Delhi", 12, "en", false),
            MSTComboBox_NEntity(6, "AXIS Gurgaon", 12, "en", false),
        )

        mSTComboBoxNViewModel.insertAllComboBox(maritalStatusList)
    }


    fun getMaster(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = APiState.loading

            try {
                val request = MasterRequest(username, password)
                val response = apiRepository.getMaster(request)

                val code = response.status.value
                if (code == 200){

                    val body = response.body<MasterResponse>()
                    body.let{
                        usersViewModel.insertAllUsers(it.user)

                    }
                    _loginState.value=APiState.success("Login successfully")


                }else if(code == 401){
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }else{
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }




}
