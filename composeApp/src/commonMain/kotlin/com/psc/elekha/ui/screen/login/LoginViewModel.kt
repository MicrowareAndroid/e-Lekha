package com.psc.elekha.ui.screen.login

/*import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wise.astitva.apicall.APiState
import com.wise.astitva.apicall.ApiRepository
import com.wise.astitva.database.viewmodel.BlockViewModel
import com.wise.astitva.database.viewmodel.CaseCategoryQuestionViewmodel
import com.wise.astitva.database.viewmodel.CaseFlagViewmodel
import com.wise.astitva.database.viewmodel.CaseReportingViewmodel
import com.wise.astitva.database.viewmodel.CategoryViewmodel
import com.wise.astitva.database.viewmodel.CriminalCaseTrackingViewmodel
import com.wise.astitva.database.viewmodel.CrossCuttingViewmodel
import com.wise.astitva.database.viewmodel.DistrictViewModel
import com.wise.astitva.database.viewmodel.LookUpValueViewmodel
import com.wise.astitva.database.viewmodel.LookupViewmodel
import com.wise.astitva.database.viewmodel.MstLanguageViewmodel
import com.wise.astitva.database.viewmodel.StateViewModel
import com.wise.astitva.database.viewmodel.SubCategoryViewmodel
import com.wise.astitva.database.viewmodel.TrackSubCategoryViewmodel
import com.wise.astitva.model.LoginRequest
import com.wise.astitva.response.LocationResponse
import com.wise.astitva.response.LoginResponse
import com.wise.astitva.response.MasterResponse
import com.wise.astitva.utils.AppPreferences
import com.wise.astitva.utils.AppSP
import com.wise.astitva.utils.returnStringValue
import astitva.composeapp.generated.resources.Res
import astitva.composeapp.generated.resources.incorrect_username_password
import astitva.composeapp.generated.resources.something_wentwrong
import astitva.composeapp.generated.resources.userloginsuccessfully
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString*/

/*
class LoginViewModel(
    private val apiRepository: ApiRepository,
    private val pref: AppPreferences,
    private val lookupViewmodel: LookupViewmodel,
    private val lookUpValueViewmodel: LookUpValueViewmodel,
    private val caseCategoryQuestionViewmodel: CaseCategoryQuestionViewmodel,
    private val caseFlagViewmodel: CaseFlagViewmodel,
    private val caseReportingViewmodel: CaseReportingViewmodel,
    private val criminalCaseTrackingViewmodel: CriminalCaseTrackingViewmodel,
    private val crossCuttingViewmodel: CrossCuttingViewmodel,
    private val mstLanguageViewmodel: MstLanguageViewmodel,
    private val subCategoryViewmodel: SubCategoryViewmodel,
    private val trackSubCategoryViewmodel: TrackSubCategoryViewmodel,
    private val categoryViewmodel: CategoryViewmodel,
    private val stateViewModel: StateViewModel,
    private val districtViewModel: DistrictViewModel,
    private val blockViewModel: BlockViewModel,
) : ViewModel() {

    private val _loginState = MutableStateFlow<APiState>(APiState.idle)
    val loginState: StateFlow<APiState> = _loginState

    fun getToken(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = APiState.loading
            try {
                val loginRequest = LoginRequest(username, password)
                val response = apiRepository.getToken(loginRequest)
                val code = response.status.value
                if (code == 200){
                    val body = response.body<LoginResponse>()
                    pref.putString(AppSP.token, body.accessToken)
                    pref.putString(AppSP.username, username)
                    _loginState.value = APiState.success(body.accessToken, body.refreshToken)
                }else if(code == 401){
                    _loginState.value = APiState.error(getString(Res.string.incorrect_username_password))
                }else{
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    fun getMaster(token: String) {
        viewModelScope.launch {
            try {
                val response = apiRepository.getMaster(token)
                val code = response.status.value
                if (code == 200){
                    val body = response.body<MasterResponse>()
                    lookupViewmodel.insertLookUps(body.data?.get(0)!!.tbllookup)
                    lookUpValueViewmodel.insertLookUpValues(body.data?.get(0)!!.tbllookupvalues)
                    categoryViewmodel.insertCategory(body.data?.get(0)!!.categories)
                    caseCategoryQuestionViewmodel.insertCaseCategoryQuestion(body.data?.get(0)!!.casecategoryquestions)
                    caseFlagViewmodel.insertCaseFlag(body.data?.get(0)!!.caseflags)
                    criminalCaseTrackingViewmodel.insertCriminalCaseTrack(body.data?.get(0)!!.criminalcasetrack)
                    crossCuttingViewmodel.insertCrossCuttingFlag(body.data?.get(0)!!.crosscuttingflags)
                    mstLanguageViewmodel.insertMstLanguage(body.data?.get(0)!!.mstlanguage)
                    subCategoryViewmodel.insertSubCategory(body.data?.get(0)!!.subCategories)
                    trackSubCategoryViewmodel.insertTrackSubCategory(body.data?.get(0)!!.tracksubcategory)
                    getLocation()
                }else if(code == 401){
                    _loginState.value = APiState.error(getString(Res.string.incorrect_username_password))
                }else{
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    private fun getLocation() {
        viewModelScope.launch {
            try{
                val response= apiRepository.getLocation(returnStringValue(pref.getString(AppSP.username)), returnStringValue(pref.getString(AppSP.token)))
                val code = response.status.value
                if (code == 200){
                    val body = response.body<LocationResponse>()
                    stateViewModel.insertStates(body.data?.get(0)!!.mstState)
                    districtViewModel.insertDistricts(body.data?.get(0)!!.mstDistrict)
                    blockViewModel.insertBlocks(body.data?.get(0)!!.mstBlock)
                    _loginState.value = APiState.finish(Res.string.userloginsuccessfully)
                } else if(code == 401){
                    _loginState.value = APiState.error(getString(Res.string.incorrect_username_password))
                }else{
                    _loginState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            }
            catch (e: Exception) {
                _loginState.value = APiState.error(e.message ?: "Unknown error")
            }
        }

    }

}*/
