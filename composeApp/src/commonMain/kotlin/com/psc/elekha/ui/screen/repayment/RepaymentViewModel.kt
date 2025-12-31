package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.response.LoanRepaymentResponse
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.*
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class RepaymentViewModel(
    private val apiRepository: ApiRepository,
    val loanRepaymentViewModel: LoanRepaymentViewModel
) : BaseValidationViewModel() {

    private var _paymentImage by mutableStateOf("")
    val paymentImage: String
        get() = _paymentImage
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
                val response = apiRepository.getLoanRepayment(request)

                val code = response.status.value
                if (code == 200) {

                    val body = response.body<LoanRepaymentResponse>()
                    body.let {

                    }
                    _downloadState.value = APiState.success("Loan download successfully")


                } else if (code == 401) {
                    _downloadState.value = APiState.error(getString(Res.string.something_wentwrong))
                } else {
                    _downloadState.value = APiState.error(getString(Res.string.something_wentwrong))
                }
            } catch (e: Exception) {
                _downloadState.value = APiState.error(e.message ?: "Unknown error")
            }
        }
    }

    fun setPaymentImage(path: String) {
        _paymentImage = path
    }

    fun saveData() {
        viewModelScope.launch {
            val validation = checkValidation()
            if (validation.isValid) {
                loanRepaymentViewModel.updateLoanRepaymentData(0.0, "", 0.0, 0.0, "", modeID, "")
                saveMessage = getString(Res.string.data_updated_successfully)
                showSaveAlert = true
                saveFlag = 1
            } else {
                showValidationError(validation)
            }
        }
    }

    private suspend fun checkValidation(): ValidationModelContorl {

        return when {
            returnIntegerValue(modeID.toString()) == 0 -> {
                val pleasepaymentmode = getString(Res.string.select_pay_mode)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleasepaymentmode
                )
            }

            returnStringValue(utrNo).isBlank() -> {
                val utrLabel = getString(Res.string.enter_utr)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = utrLabel
                )
            }

            returnStringValue(totalAmt).isBlank() -> {
                val paymentLabel = getString(Res.string.enter_total_payment)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = paymentLabel
                )
            }

            else -> ValidationModelContorl(isValid = true)

        }
    }
}