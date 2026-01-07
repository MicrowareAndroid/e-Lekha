package com.psc.elekha.ui.screen.economicdetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity
import com.psc.elekha.database.viewmodel.CustomerFamilyMemberDetailsViewModel
import com.psc.elekha.database.viewmodel.CustomerMovableAssetsViewModel
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.ensureCustomerGuid
import com.psc.elekha.utils.generateRandomId
import com.psc.elekha.utils.parseNameDynamic
import com.psc.elekha.utils.returnIntToString
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import e_lekha.composeapp.generated.resources.data_updated_successfully

import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class MovableAssetsViewModel(
    private val appPreferences: AppPreferences,
    private val movableAssetsViewmodel: CustomerMovableAssetsViewModel
) : BaseValidationViewModel() {

    var vehicleNo by mutableStateOf("")

    var selectedAssetsId by mutableStateOf(0)
    private var _vehicleImage by mutableStateOf("")
    val vehicleImage: String
        get() = _vehicleImage

    val bringIntoViewRequesterAssetsId = BringIntoViewRequester()
    val bringIntoViewRequesterVehicleNo= BringIntoViewRequester()


    val focusRequesterAssestsId = FocusRequester()
    val focusRequesterVehicleNo = FocusRequester()



    suspend fun saveMovableAsets() {
        val assetsGuid = appPreferences.getString(AppSP.MovableAssetsGuid)
        val customerGuid = ensureCustomerGuid(appPreferences)

        if (assetsGuid.isNullOrEmpty()) {
            val newGuid = generateRandomId()

            val entity = CustomerMovableAssetsEntity(
                newGuid,
                customerGuid,
                selectedAssetsId,
                vehicleNo,
                vehicleImage,
                0,
                1,
                0,

            )

            movableAssetsViewmodel.insert(entity)
            appPreferences.putString(AppSP.MovableAssetsGuid, newGuid)
            saveMessage = getString(Res.string.data_saved_successfully)
            showSaveAlert = true
        } else {

        }
    }

    fun setVehicleImage(path: String) {
        _vehicleImage = path
    }


    fun saveData() {
        viewModelScope.launch {
            saveMovableAsets()
            showSaveAlert = true
            saveFlag = 1

           /*val validation = checkValidation()
            if (validation.isValid) {
                saveFamilyMember()
                showSaveAlert = true
                saveFlag = 1
            } else {
                showValidationError(validation)
            }*/
        }
    }

  /*  private suspend fun checkValidation(): ValidationModelContorl {
        val pleaseRemarks = getString(Res.string.personal_remarks)
        val pleaseEducation = getString(Res.string.personal_education)
        val pleaseGender = getString(Res.string.personal_gender)
        val pleaseOccupation = getString(Res.string.personal_occupation)
        val pleaseIncome = getString(Res.string.personal_income)

        return when {

            returnStringValue(memberName).isBlank() -> {
                val nameLabel = getString(Res.string.personal_customer_name)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterMemberName,
                    bringIntoViewRequester = bringIntoViewRequesterMemberName
                )
            }


            returnIntegerValue(gender.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseGender,
                    focusRequester = focusRequesterGender,
                    bringIntoViewRequester = bringIntoViewRequesterGender
                )
            }

            returnStringValue(age).isBlank() -> {
                val nameLabel = getString(Res.string.personal_age)
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = nameLabel,
                    focusRequester = focusRequesterAge,
                    bringIntoViewRequester = bringIntoViewRequesterAge
                )
            }

            returnIntegerValue(educationId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseEducation,
                    focusRequester = focusRequesterEducationId,
                    bringIntoViewRequester = bringIntoViewRequesterEducationId
                )
            }
            returnIntegerValue(occupationId.toString()) == 0 -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseOccupation,
                    focusRequester = focusRequesterOccupationId,
                    bringIntoViewRequester = bringIntoViewRequesterOccupationId
                )
            }

            returnStringValue(monthlyIncome).isBlank() -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseIncome,
                    focusRequester = focusRequesterMonthlyIncome,
                    bringIntoViewRequester = bringIntoViewRequesterMonthlyIncome
                )
            }

            returnStringValue(remarks).isBlank() -> {
                ValidationModelContorl(
                    isValid = false,
                    errorMessage = pleaseRemarks,
                    focusRequester = focusRequesterRemarks,
                    bringIntoViewRequester = bringIntoViewRequesterRemarks
                )
            }


            else -> ValidationModelContorl(isValid = true)
        }
    }*/

}

