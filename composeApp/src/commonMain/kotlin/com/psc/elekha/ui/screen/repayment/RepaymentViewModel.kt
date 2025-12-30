package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.response.MasterResponse
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.something_wentwrong
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class RepaymentViewModel(private val apiRepository: ApiRepository):BaseValidationViewModel()  {

    var villageId by mutableStateOf(0)
    var modeID by mutableStateOf(0)
    var centerId by mutableStateOf(0)
    var customerID by mutableStateOf("")
    var utrNo by mutableStateOf("")
    var totalAmt by mutableStateOf("")
    val focusRequesterVlgId = FocusRequester()
    val focusRequesterCenterId = FocusRequester()
    val focusRequesterCustID = FocusRequester()
    val bringIntoViewRequesterVlgId = BringIntoViewRequester()
    val bringIntoViewRequesterCenterId = BringIntoViewRequester()
    val bringIntoViewRequesterCustID = BringIntoViewRequester()
    private val _downloadState = MutableStateFlow<APiState>(APiState.idle)
    val downloadState: StateFlow<APiState> = _downloadState
    fun getLoanRepayment(username: String, password: String) {
        viewModelScope.launch {
            _downloadState.value = APiState.loading

            try {
                val request = MasterRequest(username, password)
                val response = apiRepository.getMaster(request)

                val code = response.status.value
                if (code == 200){

                    val body = response.body<MasterResponse>()
                    body.let{

                    }
                    _downloadState.value=APiState.success("Loan download successfully")


                }else if(code == 401){
                    _downloadState.value = APiState.error(getString(Res.string.something_wentwrong))
                }else{
                    _downloadState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _downloadState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }
}