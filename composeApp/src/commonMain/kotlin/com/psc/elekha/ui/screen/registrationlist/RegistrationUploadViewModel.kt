package com.psc.elekha.ui.screen.registrationlist

import androidx.lifecycle.viewModelScope
import com.psc.elekha.apicall.APiState
import com.psc.elekha.apicall.ApiRepository
import com.psc.elekha.database.viewmodel.CustomerExistingLoanDetailViewModel
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.database.viewmodel.CustomerMovableAssetsViewModel
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.mapper.toUploadDTO

import com.psc.elekha.model.RegistrationUploadRequest
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class RegistrationUploadViewModel(
    private val apiRepository: ApiRepository,
    val appPreferences: AppPreferences,
    val customerViewModel: CustomerViewModel,
    val customerExistingLoanDetailViewModel: CustomerExistingLoanDetailViewModel,
    val customerFamilyMemberDetailViewModel: CustomerFamilyMemberDetailsViewModel,
    val customerMovableAssestsViewModel: CustomerMovableAssetsViewModel
) : BaseValidationViewModel() {
    private val _uploadState = MutableStateFlow<APiState>(APiState.idle)
    val uploadState: StateFlow<APiState> = _uploadState

    fun uploadRegistrationData() {
        viewModelScope.launch {
            _uploadState.value = APiState.loading

            try {
                val customers = customerViewModel.getUploadData()
                val familyMembers = customerFamilyMemberDetailViewModel.getUploadData()
                val loans = customerExistingLoanDetailViewModel.getUploadData()
                val assets = customerMovableAssestsViewModel.getUploadData()

                if (
                    customers.isEmpty() &&
                    familyMembers.isEmpty() &&
                    loans.isEmpty() &&
                    assets.isEmpty()
                ) {
                    _uploadState.value = APiState.error("No data to upload")
                    return@launch
                }

                val customerDTOs = customers.map { it.toUploadDTO() }
                val familyDTOs = familyMembers.map { it.toUploadDTO() }
                val loanDTOs = loans.map { it.toUploadDTO() }
                val assetDTOs = assets.map { it.toUploadDTO() }

                val request = RegistrationUploadRequest(
                    customers = customerDTOs,
                    familyMembers = familyDTOs,
                    existingLoans = loanDTOs,
                    movableAssets = assetDTOs
                )
                val requestJson = Json.encodeToString(request)

                println("UPLOAD_REQUEST_JSON =====> $requestJson")

                val response = apiRepository.uploadRegistrationData(request)
                val code = response.status.value

                if (code == 200) {

                    /*
                    customerViewModel.markUploaded()
                    customerFamilyMemberDetailViewModel.markUploaded()
                    customerExistingLoanDetailViewModel.markUploaded()
                    customerMovableAssestsViewModel.markUploaded()
                    */

                    _uploadState.value = APiState.success("Upload successful")

                } else if (code == 401) {
                    _uploadState.value =
                        APiState.error("Unauthorized, please login again")
                } else {
                    _uploadState.value =
                        APiState.error("Something went wrong")
                }

            } catch (e: Exception) {
                e.printStackTrace()
                _uploadState.value =
                    APiState.error(e.message ?: "Unknown error")
            }
        }
    }







}