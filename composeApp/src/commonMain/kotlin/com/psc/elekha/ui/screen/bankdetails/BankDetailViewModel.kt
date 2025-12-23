package com.psc.elekha.ui.screen.bankdetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.viewmodel.CustomerDefaultViewModel
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.model.ValidationModelContorl
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.currentDatetime
import com.psc.elekha.utils.generateRandomId
import com.psc.elekha.utils.returnIntegerValue
import com.psc.elekha.utils.returnStringValue
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.data_saved_successfully
import e_lekha.composeapp.generated.resources.personal_customer_name
import e_lekha.composeapp.generated.resources.personal_district
import e_lekha.composeapp.generated.resources.personal_education
import e_lekha.composeapp.generated.resources.personal_education_selection
import e_lekha.composeapp.generated.resources.personal_father
import e_lekha.composeapp.generated.resources.personal_full_address
import e_lekha.composeapp.generated.resources.personal_gurantor_mobile
import e_lekha.composeapp.generated.resources.personal_gurantor_name
import e_lekha.composeapp.generated.resources.personal_husband_name
import e_lekha.composeapp.generated.resources.personal_landmark
import e_lekha.composeapp.generated.resources.personal_marital
import e_lekha.composeapp.generated.resources.personal_maternal_address
import e_lekha.composeapp.generated.resources.personal_maternal_mobile
import e_lekha.composeapp.generated.resources.personal_medical
import e_lekha.composeapp.generated.resources.personal_mobile_number
import e_lekha.composeapp.generated.resources.personal_payment_daily
import e_lekha.composeapp.generated.resources.personal_pincode
import e_lekha.composeapp.generated.resources.personal_purpose
import e_lekha.composeapp.generated.resources.personal_relation
import e_lekha.composeapp.generated.resources.personal_religion
import e_lekha.composeapp.generated.resources.personal_state
import e_lekha.composeapp.generated.resources.personal_tehsil
import e_lekha.composeapp.generated.resources.personal_village
import e_lekha.composeapp.generated.resources.pls_enter_name_on_account
import kotlinx.coroutines.launch

import org.jetbrains.compose.resources.getString

class BankDetailViewModel(
    var appPreferences: AppPreferences,
    var customerViewModel: CustomerViewModel
): BaseValidationViewModel()
{
 var accountName by   mutableStateOf("")
 var accountNumber by mutableStateOf("")
 var selectedBankname by mutableStateOf(0)
 var selectedBranchname by mutableStateOf(0)
 var ifscCode by mutableStateOf("")
 var passbookImage by mutableStateOf("")

 val focusRequesterAccountName = FocusRequester()
 val focusRequesterAccountNumber = FocusRequester()
 val focusRequesterBankName = FocusRequester()
 val focusRequesterBranchName = FocusRequester()


 val bringIntoViewRequesterAccountName = BringIntoViewRequester()
 val bringIntoViewRequesterAccountNumber = BringIntoViewRequester()
 val bringIntoViewRequesterBankName = BringIntoViewRequester()
 val bringIntoViewRequesterBranchName = BringIntoViewRequester()





 fun saveData() {
  viewModelScope.launch {
   //saveBankDetail()

  }
 }

 private suspend fun saveBankDetail() {
  val guid = appPreferences.getString(AppSP.customerGuid)
  customerViewModel.updateBankDetail(
   returnStringValue(guid),
   returnStringValue(accountNumber),
   selectedBankname,
   returnStringValue(ifscCode),
   appPreferences.getInt(AppSP.userId),
   currentDatetime()

  )
  saveMessage = getString(Res.string.data_saved_successfully)

 }

 fun loadSaveData(){
  viewModelScope.launch {
  val saveGuid=returnStringValue(appPreferences.getString(AppSP.customerGuid))
   val listData=customerViewModel.getCustomerDetailGuid(saveGuid)
   if(listData.isNotEmpty()) {
    var data=listData[0]
    accountNumber = returnStringValue(data.CKYC_BankAccountNumber)
    selectedBankname = returnIntegerValue(data.CKYC_Bank.toString())
    ifscCode = returnStringValue(data.CustomerBankIFSCCode)




   }
 }
 }

 /*private suspend fun checkValidation(): ValidationModelContorl {

  return when {
   returnStringValue(accountName).isBlank() -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = getString(Res.string.pls_enter_name_on_account),
     focusRequester = focusRequesterAccountName,
     bringIntoViewRequester = bringIntoViewRequesterAccountName
    )
   }




   returnStringValue(accountNumber) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleasemaritalstatus,
     focusRequester = focusRequesterMaritalStatusId,
     bringIntoViewRequester = bringIntoViewRequesterMaritalStatusId
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

   returnIntegerValue(religionId.toString()) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleaseReligion,
     focusRequester = focusRequesterReligionId,
     bringIntoViewRequester = bringIntoViewRequesterReligionId
    )
   }
   returnIntegerValue(purposeId.toString()) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleasePurpose,
     focusRequester = focusRequesterPurposeId,
     bringIntoViewRequester = bringIntoViewRequesterPurposeId
    )
   }
   returnStringValue(mobileNumber).length < 10 -> {
    val msg = getString(Res.string.personal_mobile_number)
    ValidationModelContorl(
     isValid = false,
     errorMessage = msg,
     focusRequester = focusRequesterMobileNumber,
     bringIntoViewRequester = bringIntoViewRequesterMobileNumber
    )
   }
   returnStringValue(husbandName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_husband_name)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterHusbandName,
     bringIntoViewRequester = bringIntoViewRequesterHusbandName
    )
   }

   returnStringValue(gurantorName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_gurantor_name)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterGurantorName,
     bringIntoViewRequester = bringIntoViewRequesterGurantorName
    )
   }
   returnIntegerValue(relationId.toString()) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleaseRelation,
     focusRequester = focusRequesterRelationId,
     bringIntoViewRequester = bringIntoViewRequesterRelationId
    )
   }

   returnStringValue(gurantormobileNumber).length < 10 -> {
    val nameLabel = getString(Res.string.personal_gurantor_mobile)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterGurantormobileNumber,
     bringIntoViewRequester = bringIntoViewRequesterGurantormobileNumber
    )
   }

   returnStringValue(fulladdresss).isBlank() -> {
    val nameLabel = getString(Res.string.personal_full_address)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterFullAddress,
     bringIntoViewRequester = bringIntoViewRequesterFullAddress
    )
   }
   returnIntegerValue(stateId.toString()) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleaseState,
     focusRequester = focusRequesterStateId,
     bringIntoViewRequester = bringIntoViewRequesterStateId
    )
   }
   returnIntegerValue(districtId.toString()) == 0 -> {
    ValidationModelContorl(
     isValid = false,
     errorMessage = pleaseDistrict,
     focusRequester = focusRequesterDistrictId,
     bringIntoViewRequester = bringIntoViewRequesterDistrictId
    )
   }
   returnStringValue(villageName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_village)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterVillageName,
     bringIntoViewRequester = bringIntoViewRequesterVillageName
    )
   }
   returnStringValue(tehsilName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_tehsil)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterTehsilName,
     bringIntoViewRequester = bringIntoViewRequesterTehsilName
    )
   }
   returnStringValue(landMark).isBlank() -> {
    val nameLabel = getString(Res.string.personal_landmark)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterLandMark,
     bringIntoViewRequester = bringIntoViewRequesterLandMark
    )
   }
   returnStringValue(pinCode).length < 6 -> {
    val nameLabel = getString(Res.string.personal_pincode)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterPinCode,
     bringIntoViewRequester = bringIntoViewRequesterPinCode
    )
   }
   returnStringValue(maternalAddress).isBlank() -> {
    val nameLabel = getString(Res.string.personal_maternal_address)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterMaternalAddress,
     bringIntoViewRequester = bringIntoViewRequesterMaternalAddress
    )
   }

   returnStringValue(maternalMobileNo).isBlank() -> {
    val nameLabel = getString(Res.string.personal_maternal_mobile)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterMaternalMobileNo,
     bringIntoViewRequester = bringIntoViewRequesterMaternalMobileNo
    )
   }
   returnStringValue(fatherName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_father)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterFatherName,
     bringIntoViewRequester = bringIntoViewRequesterFatherName
    )
   }
   returnStringValue(husbandName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_husband_name)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterHusbandName,
     bringIntoViewRequester = bringIntoViewRequesterHusbandName
    )
   }
   returnStringValue(dailyExpense).isBlank() -> {
    val nameLabel = getString(Res.string.personal_payment_daily)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterDailyExpense,
     bringIntoViewRequester = bringIntoViewRequesterDailyExpense
    )
   }
   returnStringValue(educationExpense).isBlank() -> {
    val nameLabel = getString(Res.string.personal_education_selection)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterHusbandName,
     bringIntoViewRequester = bringIntoViewRequesterHusbandName
    )
   }
   returnStringValue(medicalExpense).isBlank() -> {
    val nameLabel = getString(Res.string.personal_medical)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterHusbandName,
     bringIntoViewRequester = bringIntoViewRequesterHusbandName
    )
   }
   returnStringValue(husbandName).isBlank() -> {
    val nameLabel = getString(Res.string.personal_husband_name)
    ValidationModelContorl(
     isValid = false,
     errorMessage = nameLabel,
     focusRequester = focusRequesterHusbandName,
     bringIntoViewRequester = bringIntoViewRequesterHusbandName
    )
   }


   else -> ValidationModelContorl(isValid = true)

  }
 }*/






}