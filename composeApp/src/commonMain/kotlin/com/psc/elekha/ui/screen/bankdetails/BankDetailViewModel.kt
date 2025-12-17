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

class BankDetailViewModel(
    var appPreferences: AppPreferences,
    var customerDefaultViewModel: CustomerDefaultViewModel
): BaseValidationViewModel()
{
 var accountName by   mutableStateOf("")
 var accountNumber by mutableStateOf("")
 var selectedBankname by mutableStateOf(0)
 var selectedBranchname by mutableStateOf(0)
 var ifscCode by mutableStateOf("")
 var passbookImage by mutableStateOf("")




 fun saveData() {
  viewModelScope.launch {
   saveBankDetail()

  }
 }

 private suspend fun saveBankDetail() {
  val guid = appPreferences.getString(AppSP.customerGuid)
  customerDefaultViewModel.updateBankDetail(
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
  customerDefaultViewModel.loadCustomerDefaultGUID(saveGuid)
  val listData = customerDefaultViewModel.customerDefaultGUIDList.value
   if(!listData.isNullOrEmpty())
   {
    var data=listData[0]
    accountNumber = returnStringValue(data.CKYC_BankAccountNumber)
    selectedBankname = returnIntegerValue(data.CKYC_Bank.toString())
    ifscCode = returnStringValue(data.CustomerBankIFSCCode)
    //passbookImage = returnStringValue(data.Image)



   }
 }
 }



}