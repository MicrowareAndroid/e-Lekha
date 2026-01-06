package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupMemberViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupViewModel
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.response.GtrResponse
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

class GtrViewModel(
    private val apiRepository: ApiRepository,
    private val trainingGroupViewModel: TrainingGroupViewModel,
    private val trainingGroupMemberViewModel: TrainingGroupMemberViewModel,
//    val loanRepaymentViewModel: LoanRepaymentViewModel
) : BaseValidationViewModel() {

    private var _customerImage by mutableStateOf("")
    private var _guarantorImage by mutableStateOf("")
    private var _eMeterImage by mutableStateOf("")
    private var _houseVerificationImage by mutableStateOf("")
    val customerImage: String get() = _customerImage
    val guarantorImage: String get() = _guarantorImage
    val eMeterImage: String get() = _eMeterImage
    val houseVerificationImage: String get() = _houseVerificationImage

    var eBillRemark by mutableStateOf("")
    var houseVerificationRemark by mutableStateOf("")
    var loanRecommendationID by mutableStateOf(0)
    var loanRecommendationRemark by mutableStateOf("")

    val focusRequesterEBillRemark = FocusRequester()
    val bringIntoViewRequesterEBillRemark = BringIntoViewRequester()

    val focusRequesterHouseVerificationRemark= FocusRequester()
    val bringIntoViewRequesterHouseVerificationRemark = BringIntoViewRequester()

    val focusRequesterLoanRecommendationID = FocusRequester()
    val bringIntoViewRequesterLoanRecommendationID = BringIntoViewRequester()

    val focusRequesterLoanRecommendationRemark = FocusRequester()
    val bringIntoViewRequesterLoanRecommendationRemark = BringIntoViewRequester()


    private val _downloadState = MutableStateFlow<APiState>(APiState.idle)
    val downloadState: StateFlow<APiState> = _downloadState

    fun getGTRData(username: String, password: String) {
        viewModelScope.launch {
            _downloadState.value = APiState.loading

            try {
                val request = MasterRequest(username, password)
                val response = apiRepository.getGTRData(request)

                val code = response.status.value
                if (code == 200) {

                    val body = response.body<GtrResponse>()
                    body.let {
//                        trainingGroupViewModel.deleteAllTrainingGroup {  }
//                        trainingGroupMemberViewModel.deleteAllTrainingGroupStatus {  }

                        trainingGroupViewModel.insertAllTrainingGroup(it.trainingGroupEntity)
                        trainingGroupMemberViewModel.insertAllTrainingGroupStatus(it.trainingGroupMemberEntity)
                    }
                    _downloadState.value = APiState.success("GTR data download successfully")
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

    fun setCustomerImage(path: String) {
        _customerImage = path
    }

    fun setGuarantorImage(path: String) {
        _guarantorImage = path
    }

    fun setEMeterImage(path: String) {
        _eMeterImage = path
    }

    fun setHouseVerificationImage(path: String) {
        _houseVerificationImage = path
    }

    fun saveData() {
        viewModelScope.launch {
            val validation = checkValidation()
            if (validation.isValid) {
//                loanRepaymentViewModel.updateLoanRepaymentData(0.0, "", 0.0, 0.0, "", modeID, "")
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

            returnStringValue(_customerImage).isBlank() -> {
                val label = getString(Res.string.click_customer_image)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label
                )
            }

            returnStringValue(_guarantorImage).isBlank() -> {
                val label = getString(Res.string.click_guarantor_image)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label
                )
            }

            returnStringValue(eBillRemark).isBlank() -> {
                val label = getString(Res.string.enter_electricity_bill_remark)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label,
                    focusRequester = focusRequesterEBillRemark,
                    bringIntoViewRequester = bringIntoViewRequesterEBillRemark
                )
            }

            returnStringValue(_eMeterImage).isBlank() -> {
                val label = getString(Res.string.click_e_meter_image)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label
                )
            }

            returnStringValue(_houseVerificationImage).isBlank() -> {
                val label = getString(Res.string.click_house_verification_image)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label
                )
            }

            returnStringValue(houseVerificationRemark).isBlank() -> {
                val label = getString(Res.string.enter_house_verification_remark)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label,
                    focusRequester = focusRequesterHouseVerificationRemark,
                    bringIntoViewRequester = bringIntoViewRequesterHouseVerificationRemark
                )
            }

            returnIntegerValue(loanRecommendationID.toString()) == 0 -> {
                val label = getString(Res.string.select_loan_recommendation)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label,
                    focusRequester = focusRequesterLoanRecommendationID,
                    bringIntoViewRequester = bringIntoViewRequesterLoanRecommendationID
                )
            }

            returnStringValue(loanRecommendationRemark).isBlank() -> {
                val label = getString(Res.string.enter_loan_recommendation_remark)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = label,
                    focusRequester = focusRequesterLoanRecommendationRemark,
                    bringIntoViewRequester = bringIntoViewRequesterLoanRecommendationRemark
                )
            }

            else -> ValidationModelContorl(isValid = true)

        }
    }
}