package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.repository.LoanRepaymentRepository
import com.psc.elekha.database.viewmodel.LoanClosureViewModel
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.database.viewmodel.MSTBranchViewModel
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.response.LoanRepaymentResponse
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.*
import io.ktor.client.call.body
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class RepaymentViewModel(
    private val apiRepository: ApiRepository,
    private val loanRepaymentViewModel: LoanRepaymentViewModel,
    private val loanClosureViewModel: LoanClosureViewModel,
    private val mstBranchViewModel: MSTBranchViewModel,
    private val repository: LoanRepaymentRepository, val appPreferences: AppPreferences
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

    private val _loanRepayment = MutableStateFlow(LoanRepaymentEntity(""))
    val loanRepayment: StateFlow<LoanRepaymentEntity> = _loanRepayment

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
                        loanRepaymentViewModel.insertAllLoanRepayment(it.loanRepayment)
                        loanClosureViewModel.insertAllLoanClosure(it.loanClouser)
                        mstBranchViewModel.insertAllBranch(it.mstBranch)
                    }
                    _downloadState.value =
                        APiState.success(getString(Res.string.loan_download_success))
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
    fun getLoanRepaymentByGUID(
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val guid=appPreferences.getString(AppSP.LoanRepaymentGUID)
            val data=repository.getLoanRepaymentByGUID(guid)
            _loanRepayment.value= data
            modeID=data.PaymentType!!
        }
    }
    fun setPaymentImage(path: String) {
        _paymentImage = path
    }

    fun saveData(guid: String) {
        viewModelScope.launch {
            val validation = checkValidation()
            if (validation.isValid) {
                loanRepaymentViewModel.updateLoanRepaymentData(0.0, "", 0.0, 0.0, "", modeID, guid)
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

    fun filterLoan() {
        viewModelScope.launch {
            val validation = checkFilterValidation()
            if (validation.isValid) {
                showSaveAlert = true
                saveFlag = 1
            } else {
                showValidationError(validation)
            }
        }
    }

    private suspend fun checkFilterValidation(): ValidationModelContorl {

        return when {
            returnIntegerValue(villageId.toString()) == 0 && returnStringValue(customerID).isBlank() -> {
                val pleasepaymentmode = getString(Res.string.select_vlg_custid)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleasepaymentmode
                )
            }

            returnIntegerValue(villageId.toString()) >0 && returnIntegerValue(centerId.toString()) == 0 -> {
                val utrLabel = getString(Res.string.select_centre)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = utrLabel
                )
            }

            else -> ValidationModelContorl(isValid = true)

        }
    }
}