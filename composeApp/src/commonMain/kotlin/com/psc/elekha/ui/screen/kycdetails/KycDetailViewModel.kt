package com.psc.elekha.ui.screen.kycdetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.psc.elekha.database.viewmodel.CustomerDefaultViewModel
import com.psc.elekha.ui.screen.base.BaseValidationViewModel
import com.psc.elekha.utils.AppPreferences

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
    var gurantorDetail by mutableStateOf("")
    var customerNames by mutableStateOf("")
    var gurantorAadharCard by mutableStateOf("")
    var guarantorAadhaarCardImage1 by mutableStateOf("")
    var guarantorAadhaarCardImage2 by mutableStateOf("")
    var electricityBill by mutableStateOf("")

}