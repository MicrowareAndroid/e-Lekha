package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerDefaultEntity
import com.psc.elekha.database.entity.CustomerEntity
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
import kotlinx.coroutines.launch

import org.jetbrains.compose.resources.getString

class KycDetailViewModel(
    var appPreferences: AppPreferences,
    var customerViewModel: CustomerViewModel
): BaseValidationViewModel() {
    var billName by mutableStateOf("")
    var billNameIdProof by mutableStateOf("")
    var accountNumber by mutableStateOf("")
    var accountNumberIdProof by mutableStateOf("")
    var kNumber by mutableStateOf("")
    var kNumberIdProof by mutableStateOf("")
    var ebImagePath by mutableStateOf("")
    var aadharno by mutableStateOf("")
    var aadharnoIdProof by mutableStateOf("")

    var adharbackproof by mutableStateOf("")
    var nameonadhar by mutableStateOf("")
    var nameonadharIdProof by mutableStateOf("")
    var voterno by mutableStateOf("")
    var voternoIdProof by mutableStateOf("")
    var nameonvid by mutableStateOf("")
    var nameonvidIdProof by mutableStateOf("")
    var panNumber by mutableStateOf("")
    var panFrontImagePath by mutableStateOf("")
    var nameOnPan by mutableStateOf("")
    var gAadharNo by mutableStateOf("")
    var gAadharFrontPath by mutableStateOf("")
    var gAadharBackPath by mutableStateOf("")
    var gAadharName by mutableStateOf("")

     // -------- GKYC Electricity --------
     var gBillName by mutableStateOf("")
     var gAccountNumber by mutableStateOf("")
     var gKNumber by mutableStateOf("")
     var gEbImagePath by mutableStateOf("")

     // -------- GKYC Voter --------
     var gVoterNo by mutableStateOf("")
     var gVoterName by mutableStateOf("")
     var gVoterImagePath by mutableStateOf("")

     // -------- GKYC PAN --------
     var gPanNumber by mutableStateOf("")
     var gPanName by mutableStateOf("")
     var gPanImagePath by mutableStateOf("")

}


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


fun updateKyc(onSuccess: () -> Unit) {
 viewModelScope.launch {
  updateKycUpdate()
  showSaveAlert = true
  onSuccess()
 }
}

 private suspend fun updateKycUpdate() {

  val guid = returnStringValue(appPreferences.getString(AppSP.customerGuid))
  if (guid.isEmpty()) return

  customerViewModel.updateMyKyc(

   CKYC_Aadhar_Name = nameonadhar,
   CKYC_UID = aadharno,
   CKYC_UID_Image = aadharnoIdProof,
   CKYC_ElectricityBill = accountNumber,
   CKYC_ElectricityBill_Image = ebImagePath,
   CKYC_ElectricityBill_Name = billName,
   KElectricNumber = kNumber,
   CKYC_VoterCard = voterno,
   CKYC_VoterCard_Image = voternoIdProof,
   CKYC_VoterId_Name = nameonvid,
   GKYC_Aadhar_Name = null,
   GKYC_UID = null,
   GKYC_UID_Image = null,
   GKYC_UID_Image2 = null,
   GKYC_ElectricityBill = null,
   GKYC_ElectricityBill_Image = null,
   GurantorKElectricNumber = null,
   GKYC_VoterCard = null,
   GKYC_VoterCard_Image = null,
   GKYC_VoterId_Name = null,
   GKYC_PANCard = panNumber,
   GKYC_PANCard_Image = panFrontImagePath,
   GKYC_Pancard_Name = nameOnPan,
   UpdatedBy = returnStringValue(appPreferences.getString(AppSP.userId)),
   UpdatedOn = currentDatetime(),
   GUID = guid
  )

  saveMessage = getString(Res.string.data_saved_successfully)
 }

 fun setEbImage(path: String) {
  ebImagePath = path
 }
 fun setAadhaarFrontImage(path: String) {
  aadharnoIdProof = path
 }

 fun setAadhaarBackImage(path: String) {
  adharbackproof = path
 }

 fun setVidFrontImage(path: String) {
  voternoIdProof = path
 }

 fun setPanFrontImage(path: String) {
  panFrontImagePath = path
 }
 fun setGAadhaarFront(path: String) {
  gAadharFrontPath = path
 }

 fun setGAadhaarBack(path: String) {
  gAadharBackPath = path
 }

 fun setGEbImage(path: String) {
  gEbImagePath = path
 }

 fun setGVoterImage(path: String) {
  gVoterImagePath = path
 }

 fun setGPanImage(path: String) {
  gPanImagePath = path
 }


}

/* fun loadSaveData(){

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
 }*/

 /*suspend fun checkValidation(): ValidationModelContorl{
   return when{
    return

   }
 }*/

