package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.entity.ImageTrackingRecordEntity
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.database.viewmodel.ImageDetailViewModel
import com.psc.elekha.database.viewmodel.ImageTrackingRecordViewModel
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupMemberViewModel
import com.psc.elekha.database.viewmodel.TrainingGroupViewModel
import com.psc.elekha.model.GtrRequest
import com.psc.elekha.model.MasterRequest
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.response.GtrResponse
import com.psc.elekha.response.LoanRepaymentResponse
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.NetworkMonitor
import com.psc.elekha.utils.convertDateFormatDDMMYYYY
import com.psc.elekha.utils.currentDatetime
import com.psc.elekha.utils.returnIntToString
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.*
import io.ktor.client.call.body
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.getString

class GtrViewModel(
    val appPreferences: AppPreferences,
    private val apiRepository: ApiRepository,
    private val trainingGroupViewModel: TrainingGroupViewModel,
    private val trainingGroupMemberViewModel: TrainingGroupMemberViewModel,
    private val customerViewModel: CustomerViewModel,
    private val imageDetailViewModel: ImageDetailViewModel,
    private val imageTrackingRecordViewModel: ImageTrackingRecordViewModel,
    private val networkMonitor: NetworkMonitor
) : BaseValidationViewModel() {

    val isNetworkAvailable: StateFlow<Boolean> = networkMonitor.isConnected
    private var _customerImage by mutableStateOf("")
    private var _customerImageName by mutableStateOf("")

    val customerImageName: String get() = _customerImageName
    private var _eMeterImage by mutableStateOf("")

    private var _eMeterImageName by mutableStateOf("")

    val eMeterImageName: String get() = _eMeterImageName
    private var _houseVerificationImage by mutableStateOf("")

    private var _houseVerificationImageName by mutableStateOf("")

    val houseVerificationImageName: String get() = _houseVerificationImageName
    var eBillRemark by mutableStateOf("")
    var houseVerificationRemark by mutableStateOf("")
    var loanRecommendationID by mutableStateOf(0)
    var loanRecommendationRemark by mutableStateOf("")

    val focusRequesterPurposeId = FocusRequester()
    val bringIntoViewRequesterPurposeId = BringIntoViewRequester()

    val focusRequesterEBillRemark = FocusRequester()
    val bringIntoViewRequesterEBillRemark = BringIntoViewRequester()

    val focusRequesterHouseVerificationRemark = FocusRequester()
    val bringIntoViewRequesterHouseVerificationRemark = BringIntoViewRequester()

    val focusRequesterLoanRecommendationID = FocusRequester()
    val bringIntoViewRequesterLoanRecommendationID = BringIntoViewRequester()

    val focusRequesterLoanRecommendationRemark = FocusRequester()
    val bringIntoViewRequesterLoanRecommendationRemark = BringIntoViewRequester()


    private val _downloadState = MutableStateFlow<APiState>(APiState.idle)
    val downloadState: StateFlow<APiState> = _downloadState

    fun getGTRData(username: String, password: String, loanOfficerId: String, villageId: Int) {
        viewModelScope.launch {
            if (!isNetworkAvailable.value) {
                _downloadState.value = APiState.error(getString(Res.string.no_internet))
                return@launch
            }
            _downloadState.value = APiState.loading

            try {
                val request = GtrRequest(username, password, loanOfficerId, villageId)
                val response = apiRepository.getGTRData(request)

                val code = response.status.value
                println("GtrRequest res : $response, code : $code")
                if (code == 200) {
                    val body = response.body<GtrResponse>()

                    val json = Json { prettyPrint = true }.encodeToString(body)

                    println("GtrResponse FULL DATA:\n$json")
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

    fun setCustomerImage(imageName: String, path: String) {
        _customerImageName = imageName
        _customerImage = path

        println("Customer Image Name: $_customerImageName")
        println("Customer Image Path: $_customerImage")
    }

    fun setEMeterImage(imageName: String, path: String) {
        _eMeterImageName = imageName
        _eMeterImage = path

        println("Meter Image Name: $_eMeterImageName")
        println("Meter Image Path: $_eMeterImage")
    }

    fun setHouseVerificationImage(imageName: String, path: String) {
        _houseVerificationImageName = imageName
        _houseVerificationImage = path

        println("House Image Name: $_houseVerificationImageName")
        println("House Image Path: $_houseVerificationImage")
    }

    fun loadSavedData() {
        viewModelScope.launch {
            val savedGuid = returnStringValue(appPreferences.getString(AppSP.customerGuid))
            if (savedGuid.isNotEmpty()) {

                val listData = customerViewModel.getCustomerDetailGuid(savedGuid)
                if (listData.isNotEmpty()) {

                    val data = listData[0]

                    _customerImageName = returnStringValue(data.CustomerImage)

                    eBillRemark = returnStringValue(data.FirstName)

                    loanRecommendationID = returnIntegerValue(data.LoanAppliedID?.toString())
                    houseVerificationRemark = returnStringValue(data.ContactNo)
                    loanRecommendationRemark = returnStringValue(data.HusbandFName)

                }
            }
        }

    }

    fun saveData() {
        viewModelScope.launch {
            val validation = checkValidation()
            if (validation.isValid) {
                customerViewModel.updateGTRDetail(
                    customerImageName,
                    eMeterImageName,
                    houseVerificationImageName,
                    loanRecommendationID,
                    appPreferences.getString(AppSP.userId)?.toIntOrNull() ?: 0,
                    currentDatetime(),
                    appPreferences.getString(AppSP.customerGuid)!!
                )
                if (customerImageName.isNotEmpty()) {
                    saveImage(customerImageName, 1)
                }

                if (eMeterImageName.isNotEmpty()) {
                    saveImage(eMeterImageName, 1)
                }

                if (houseVerificationImageName.isNotEmpty()) {
                    saveImage(houseVerificationImageName, 1)
                }
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

    suspend fun saveImage(imageName: String, refField: Int) {
        val sCustomerGUID = returnStringValue(appPreferences.getString(AppSP.customerGuid))
        val sRefField = returnStringValue(refField.toString())


        val imageCount = imageTrackingRecordViewModel.getCountImageTrackingRecord(
            sRefField,
            sCustomerGUID
        )

        if (imageCount != null && imageCount > 0) {
            imageTrackingRecordViewModel.updateRecord(
                imageName,
                1,
                0,
                sRefField,
            )
        } else {
            val imageData = imageDetailViewModel.loadImageDetailsOnce(refField)
            if (imageData != null && imageData.isNotEmpty()) {
                val rename =
                    sCustomerGUID + returnStringValue(imageData[0].RenameImage).trim() + ".jpg"

                val imageTrackingRecordEntity = ImageTrackingRecordEntity(
                    sCustomerGUID,
                    sRefField,
                    imageName,
                    returnStringValue(imageData[0].ImageFieldName).trim(),
                    rename,
                    1,
                    0,
                    0
                )
                imageTrackingRecordViewModel.insertRecord(imageTrackingRecordEntity)
            }
        }
    }

}