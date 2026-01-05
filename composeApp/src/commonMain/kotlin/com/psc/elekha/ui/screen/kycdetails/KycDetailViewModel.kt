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
): BaseValidationViewModel()
{
    var billName by   mutableStateOf("")
    var accountNumber by mutableStateOf("")
    var accountNumberIdProof by mutableStateOf("")
    var kNumber by  mutableStateOf("")
    var kNumberIdProof by  mutableStateOf("")
    var ebImagePath by mutableStateOf("")
    var aadharno by  mutableStateOf("")
    var aadharnoIdProof by  mutableStateOf("")

    var adharbackproof by  mutableStateOf("")
    var nameonadhar by  mutableStateOf("")
    var nameonadharIdProof by  mutableStateOf("")
    var voterno by mutableStateOf("")
    var voternoIdProof by mutableStateOf("")
    var nameonvid by mutableStateOf("")
    var panFrontImagePath by mutableStateOf("")
    var gAadharNo by mutableStateOf("")
    var gAadharFrontPath by mutableStateOf("")
    var gAadharBackPath by mutableStateOf("")
    var gAadharName by mutableStateOf("")

    // -------- GKYC Electricity --------
    var gBillName by mutableStateOf("")
    var gAccountNumber by mutableStateOf("")
    var gKNumber by mutableStateOf("")
    var gadharname by mutableStateOf("")
    var gadharnumber by mutableStateOf("")
    var gEbImagePath by mutableStateOf("")
    // -------- GKYC Voter --------
    var gVoterNo by mutableStateOf("")
    var gVoterName by mutableStateOf("")
    var gelecricityno by mutableStateOf("")
    var gVoterImagePath by mutableStateOf("")
    // -------- GKYC PAN --------
    var gPanNumber by mutableStateOf("")
    var gPanName by mutableStateOf("")
    var gPanImagePath by mutableStateOf("")
    // CKYC Customer
    val bringIntoViewBillName = BringIntoViewRequester()
    val focusBillName = FocusRequester()
    val bringIntoViewAccountNumber = BringIntoViewRequester()
    val focusAccountNumber = FocusRequester()
    val bringIntoViewKNumber = BringIntoViewRequester()
    val focusKNumber = FocusRequester()
    val bringIntoViewAadharNo = BringIntoViewRequester()
    val focusAadharNo = FocusRequester()
    val bringIntoViewNameOnAadhar = BringIntoViewRequester()
    val focusNameOnAadhar = FocusRequester()

    val bringIntoViewVoterNo = BringIntoViewRequester()
    val focusVoterNo = FocusRequester()

    val bringIntoViewNameOnVid = BringIntoViewRequester()
    val focusNameOnVid = FocusRequester()

    val bringIntoViewGBillName = BringIntoViewRequester()
    val focusGBillName = FocusRequester()

    val bringIntoViewGAccountNumber = BringIntoViewRequester()
    val focusGAccountNumber = FocusRequester()

    val bringIntoViewGKNumber = BringIntoViewRequester()
    val focusGKNumber = FocusRequester()

    val bringIntoViewGAadharNo = BringIntoViewRequester()
    val focusGAadharNo = FocusRequester()

    val bringIntoViewGAadharName = BringIntoViewRequester()
    val focusGAadharName = FocusRequester()

    val bringIntoViewGVoterNo = BringIntoViewRequester()
    val focusGVoterNo = FocusRequester()

    val bringIntoViewGVoterName = BringIntoViewRequester()
    val focusGVoterName = FocusRequester()

    val bringIntoViewgPanNumber = BringIntoViewRequester()
    val focusgPanNumber = FocusRequester()

    val bringIntoViewNameOnPan = BringIntoViewRequester()
    val focusNameOnPan = FocusRequester()

    fun onNextClick(onSuccess: () -> Unit) {
       /* if (!validateKyc()) {
            saveFlag = 0
            showSaveAlert = true
            return
        }
*/
        viewModelScope.launch {
            updateKycUpdate()
            saveFlag = 1
            showSaveAlert = true
            onSuccess()
        }
    }


    //validation for ckyc
    private fun validateCkycElectricity(): Boolean {
        if (billName.isBlank()) {
            saveMessage = "Please enter Electricity Bill Name"
            requestFocus(bringIntoViewBillName, focusBillName)
            return false
        }
        if (accountNumber.isBlank()) {
            saveMessage = "Please enter Account Number"
            requestFocus(bringIntoViewAccountNumber, focusAccountNumber)
            return false
        }
        if (kNumber.isBlank()) {
            saveMessage = "Please enter K Number"
            requestFocus(bringIntoViewKNumber, focusKNumber)
            return false
        }
        if (ebImagePath.isBlank()) {
            saveMessage = "Please upload Elecricity Image"
            return false
        }
        return true
    }
    //validatiion ckycadhar
    private fun validateCkycAadhaar(): Boolean {
        if (aadharno.isBlank()) {
            saveMessage = "Please enter Aadhaar Number"
            requestFocus(bringIntoViewAadharNo, focusAadharNo)
            return false
        }
        if (nameonadhar.isBlank()) {
            saveMessage = "Please enter Name on Aadhaar"
            requestFocus(bringIntoViewNameOnAadhar, focusNameOnAadhar)
            return false
        }
        if (aadharnoIdProof.isBlank()) {
            saveMessage = "Please upload AadharCard Front Image"
            return false
        }
        if (gAadharBackPath.isBlank()) {
            saveMessage = "Please upload Guarantor AadharBack Image"
            return false
        }
        return true
    }
    //ckyc voterid
    private fun validateCkycVoter(): Boolean {
        if (voterno.isBlank()) {
            saveMessage = "Please enter Voter Number"
            requestFocus(bringIntoViewVoterNo, focusVoterNo)
            return false
        }
        if (nameonvid.isBlank()) {
            saveMessage = "Please enter Name on Voter ID"
            requestFocus(bringIntoViewNameOnVid, focusNameOnVid)
            return false
        }
        if (voternoIdProof.isBlank()) {
            saveMessage = "Please upload Voter Id Image"
            return false
        }
        return true
    }
    //gkyc elecricity
    private fun validateGkycElectricity(): Boolean {
        if (gelecricityno.isBlank()) {
            saveMessage = "Please enter Guarantor Electricity Number"
            return false
        }
        if (gKNumber.isBlank()) {
            saveMessage = "Please enter Guarantor K Number"
            return false
        }
        if (gEbImagePath.isBlank()) {
            saveMessage = "Please upload Guarantor Electriicity Image"
            return false
        }
        return true
    }
    //gkyc adhar
    private fun validateGkycAadhaar(): Boolean {
        if (gAadharNo.isBlank()) {
            saveMessage = "Please enter Guarantor Aadhaar Number"
            return false
        }
        if (gAadharName.isBlank()) {
            saveMessage = "Please enter Name on Guarantor Aadhaar"
            return false
        }
        if (gAadharFrontPath.isBlank()) {
            saveMessage = "Please upload Guarantor AadharFront Image"
            return false
        }
        if (gAadharBackPath.isBlank()) {
            saveMessage = "Please upload Guarantor AadharBack Image"
            return false
        }
        return true
    }

    //gkyc voter id
    private fun validateGkycVoter(): Boolean {
        if (gVoterNo.isBlank()) {
            saveMessage = "Please enter Guarantor Voter Number"
            return false
        }
        if (gVoterName.isBlank()) {
            saveMessage = "Please enter Name on Guarantor Voter ID"
            return false
        }
        if (gVoterImagePath.isBlank()) {
            saveMessage = "Please upload Guarantor Voter Image"
            return false
        }
        return true
    }

    //kyc pancard
    private fun validateGkycPan(): Boolean {
        if (gPanNumber.isBlank()) {
            saveMessage = "Please enter Guarantor PAN Number"
            return false
        }
        if (gPanName.isBlank()) {
            saveMessage = "Please enter Name on Guarantor PAN"
            return false
        }
        if (gPanImagePath.isBlank()) {
            saveMessage = "Please upload Guarantor PAN Image"
            return false
        }
        return true
    }


    private suspend fun updateKycUpdate() {

        val guid = returnStringValue(appPreferences.getString(AppSP.customerGuid))
        if (guid.isEmpty()) return

        customerViewModel.updateMyKyc(
            CKYC_Aadhar_Name = nameonadhar,
            CKYC_UID = aadharno,
            CKYC_UID_Image = aadharnoIdProof,
            CKYC_UID_Image2 = adharbackproof,
            CKYC_ElectricityBill = accountNumber,
            CKYC_ElectricityBill_Image = ebImagePath,
            CKYC_ElectricityBill_Name = billName,
            KElectricNumber = kNumber,
            CKYC_VoterCard = voterno,
            CKYC_VoterCard_Image = voternoIdProof,
            CKYC_VoterId_Name = nameonvid,
            GKYC_Aadhar_Name = gAadharName,
            GKYC_UID = gAadharNo,
            GKYC_UID_Image = gAadharFrontPath,
            GKYC_UID_Image2 = gAadharBackPath,
            GKYC_ElectricityBill = gelecricityno,
            GKYC_ElectricityBill_Image = gEbImagePath,
            GurantorKElectricNumber = gKNumber,
            GKYC_VoterCard = gVoterNo,
            GKYC_VoterCard_Image = gVoterImagePath,
            GKYC_VoterId_Name = gVoterName,
            GKYC_PANCard = gPanNumber,
            GKYC_PANCard_Image = gPanImagePath,
            GKYC_Pancard_Name = gPanName,
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
    fun setGAadhaarFront(path: String) {
        gAadharFrontPath = path
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
    fun validateKyc(): Boolean {
        showSaveAlert = false
        saveMessage = ""

        return validateCkycElectricity()
                && validateCkycAadhaar()
                && validateCkycVoter()
                && validateGkycElectricity()
                && validateGkycAadhaar()
                && validateGkycVoter()
                && validateGkycPan()
    }

    private fun requestFocus(
        bringIntoView: BringIntoViewRequester,
        focusRequester: FocusRequester
    ) {
        viewModelScope.launch {
            bringIntoView.bringIntoView()
            focusRequester.requestFocus()
        }
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

