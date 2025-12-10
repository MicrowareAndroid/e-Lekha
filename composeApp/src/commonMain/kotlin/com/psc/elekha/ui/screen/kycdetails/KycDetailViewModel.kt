package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.viewmodel.CustomerDefaultViewModel
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
import kotlinx.coroutines.launch

import org.jetbrains.compose.resources.getString

class KycDetailViewModel(
    var appPreferences: AppPreferences,
    var customerDefaultViewModel: CustomerDefaultViewModel
): BaseValidationViewModel()
{

    var customerName by mutableStateOf("")
    var aadharCard by mutableStateOf("")
   var aadhaarImage1 by mutableStateOf("")
    var aadhaarImage2 by mutableStateOf("")
    var voterCard by mutableStateOf("")
    var voterIDCardImage1 by mutableStateOf("")
    var voterIDCardImage2 by mutableStateOf("")
    var rationCard by mutableStateOf("")
    var rationCardIDImage1 by mutableStateOf("")
    var rationCardIDImage2 by mutableStateOf("")
    var gurantorName by mutableStateOf("")
    var gurantorAadharCard by mutableStateOf("")
    var guarantorAadhaarCardImage1 by mutableStateOf("")
    var guarantorAadhaarCardImage2 by mutableStateOf("")
    var electricityBIllsImage1 by mutableStateOf("")
    var electricityBIllsImage2 by mutableStateOf("")
    var electricityKNo1 by mutableStateOf("")
    var electricityName1 by mutableStateOf("")
    var electricityAccountNo1 by mutableStateOf("")
    var electricityRelation1 by mutableStateOf("")
    var electricityKNo2 by mutableStateOf("")
    var electricityName2 by mutableStateOf("")
    var electricityAccountNo2 by mutableStateOf("")
    var electricityRelation2 by mutableStateOf("")

    val bringIntoViewRequesterCustomerName = BringIntoViewRequester()
    val bringIntoViewRequesterAadharCard = BringIntoViewRequester()
    val bringIntoViewRequesterAadhaarImage1 =BringIntoViewRequester()
    val bringIntoViewRequesterAadhaarImage2 =BringIntoViewRequester()
    val bringIntoViewRequesterVoterCard = BringIntoViewRequester()
    val bringIntoViewRequesterVoterIDCardImage1 = BringIntoViewRequester()
    val bringIntoViewRequesterVoterIDCardImage2 = BringIntoViewRequester()
    val bringIntoViewRequesterRationCard = BringIntoViewRequester()
    val bringIntoViewRequesterRationCardIDImage1 = BringIntoViewRequester()
    val bringIntoViewRequesterRationCardIDImage2 = BringIntoViewRequester()
    val bringIntoViewRequestergurantorName = BringIntoViewRequester()
    val bringIntoViewRequesterGurantorAadharCard = BringIntoViewRequester()
    val bringIntoViewRequesterGuarantorAadhaarCardImage1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityBIllsImage1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityBIllsImage2 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityKNo1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityName1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityAccountNo1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityRelation1 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityKNo2 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityName2 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityAccountNo2 = BringIntoViewRequester()
    val bringIntoViewRequesterElectricityRelation2 = BringIntoViewRequester()

 val focusRequesterCustomerName = FocusRequester()
 val focusRequesterAadharCard = FocusRequester()
 val focusRequesterAadhaarImage1 = FocusRequester()
 val focusRequesterAadhaarImage2 = FocusRequester()
 val focusRequesterVoterCard = FocusRequester()
 val focusRequesterVoterIDCardImage1 = FocusRequester()
 val focusRequesterVoterIDCardImage2 = FocusRequester()
 val focusRequesterRationCard = FocusRequester()
 val focusRequesterRationCardIDImage1 = FocusRequester()
 val focusRequesterRationCardIDImage2 = FocusRequester()
 val focusRequesterGurantorAadharCard = FocusRequester()
 val focusRequestergurantorName = FocusRequester()
 val focusRequesterGuarantorAadhaarCardImage1 = FocusRequester()
 val focusRequesterElectricityBIllsImage1 = FocusRequester()
 val focusRequesterElectricityBIllsImage2 = FocusRequester()
 val focusRequesterElectricityKNo1 = FocusRequester()
 val focusRequesterElectricityName1 = FocusRequester()
 val focusRequesterElectricityAccountNo1 = FocusRequester()
 val focusRequesterElectricityRelation1 = FocusRequester()
 val focusRequesterElectricityKNo2 = FocusRequester()
 val focusRequesterElectricityName2 = FocusRequester()
 val focusRequesterElectricityAccountNo2 = FocusRequester()
 val focusRequesterElectricityRelation2 = FocusRequester()

 suspend fun SaveKyc()
 {
  val guid=appPreferences.getString(AppSP.customerGuid)
  if(returnStringValue(guid).isEmpty())
  {
   val newGuid= generateRandomId()
   val entity= CustomerDefaultEntity(
    newGuid,
    "",
    "",
    0,
    "",
    0,
    customerName,
    "",
    "",
    "",
    gurantorName,
    "",
    "",
    guarantorAadhaarCardImage1,
    "",
    0,
    0,
    "",
    0,
    "",
    aadharCard,
    aadhaarImage1,
    aadhaarImage2,
    voterCard,
    voterIDCardImage1,
    voterIDCardImage2,
    electricityAccountNo1,
    returnIntegerValue(electricityRelation1),
    electricityBIllsImage1,
    electricityName1,
    "",
    "",
    0,
    "",
    "",
    "",
    "",
    "",
    "",
    appPreferences.getString(AppSP.userId),
    currentDatetime(),
    "",
    "",
    1,
    false,
    0,
    "",
    "",
    "",
    "",
    "",
    "",
    rationCard,
    rationCardIDImage1,
    rationCardIDImage2,
    0,
    "",
    "",
    "",
    "",
    false,
    0,
    "",
    0,
    0,
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    0,
    "",
    "",
    "",
    "",
    "",
    0,
    0,
    ""
   )
   customerDefaultViewModel.insertCustomer(entity)
   appPreferences.putString(AppSP.customerGuid,newGuid)
   saveMessage= getString(Res.string.data_saved_successfully)
    showSaveAlert=true
  }
 }

 fun loadSaveData(){

  viewModelScope.launch {
  val saveGuid=returnStringValue(appPreferences.getString(AppSP.customerGuid))
  customerDefaultViewModel.loadCustomerDefaultGUID(saveGuid)
  val listData = customerDefaultViewModel.customerDefaultGUIDList.value
   if(!listData.isNullOrEmpty())
   {
    var data=listData[0]


   }
 }
 }

 /*suspend fun checkValidation(): ValidationModelContorl{
   return when{
    return

   }
 }*/


}