package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
 var billName by   mutableStateOf("")
 var accountNumber by mutableStateOf("")
 var kNumber by  mutableStateOf("")

 var aadharno by  mutableStateOf("")
 var nameonadhar by  mutableStateOf("")
 var voterno by mutableStateOf("")
 var nameonvid by mutableStateOf("")
 var panNumber by mutableStateOf("")
 var nameOnPan by  mutableStateOf("")


/*    val bringIntoViewRequesterCustomerName = BringIntoViewRequester()
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
 val focusRequesterElectricityRelation2 = FocusRequester()*/

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
    0,
    "",
    0,
    "",
    "",
    "",
    "",
    voterno,
    "",
    "",
    accountNumber,
    returnIntegerValue(""),
    "",
    billName,
    kNumber,
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
    "",
    "",
    "",
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
    panNumber,
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    nameonvid,
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    nameOnPan,
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
   println( "billName$billName")
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
    billName = returnStringValue(data.CKYC_ElectricityBill_Name)
    kNumber = returnStringValue(data.KElectricNumber)
    voterno = returnStringValue(data.CKYC_VoterCard)
    accountNumber = returnStringValue(data.CKYC_ElectricityBill)
    panNumber = returnStringValue(data.CKYC_PANCard)
    nameonvid = returnStringValue(data.CKYC_VoterCard)
    nameOnPan = returnStringValue(data.CKYC_PANCard)


   }
 }
 }

 /*suspend fun checkValidation(): ValidationModelContorl{
   return when{
    return

   }
 }*/


}