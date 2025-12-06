package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.repository.CustomerExistingLoanDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class CustomerExistingLoanDetailViewModel(
    private val repository: CustomerExistingLoanDetailRepository
) : ViewModel() {

    private val _allLoans = MutableStateFlow<List<CustomerExistingLoanDetailEntity>>(emptyList())
    val allLoans: StateFlow<List<CustomerExistingLoanDetailEntity>> = _allLoans

    private val _loanUploadList =
        MutableStateFlow<List<CustomerExistingLoanDetailEntity>>(emptyList())
    val loanUploadList: StateFlow<List<CustomerExistingLoanDetailEntity>> = _loanUploadList

    private val _loanCount = MutableStateFlow<Int?>(null)
    val loanCount: StateFlow<Int?> = _loanCount

    private val _isUploaded = MutableStateFlow<Int?>(null)
    val isUploaded: StateFlow<Int?> = _isUploaded

    private val _uploadCount = MutableStateFlow<Int>(0)
    val uploadCount: StateFlow<Int> = _uploadCount

    // --------------------------------
    // Load All Loans for a Customer
    // --------------------------------
    fun loadAllLoans(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllCustomerExistingLoan(guid) ?: emptyList()
            _allLoans.value = data
        }
    }

    // --------------------------------
    // Insert Single Loan
    // --------------------------------
    fun insertCustomerExistingLoan(
        loan: CustomerExistingLoanDetailEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerExistingLoan(loan)
            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Insert All Loans
    // --------------------------------
    fun insertAllCustomerExistingLoan(
        loans: List<CustomerExistingLoanDetailEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerExistingLoan(loans)
            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Delete All Loans
    // --------------------------------
    fun deleteAllLoans() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerExistingLoan()
        }
    }

    // --------------------------------
    // Get Loan Count
    // --------------------------------
    fun loadLoanCount(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loanCount.value = repository.getMyLoanCount(guid)
        }
    }

    // --------------------------------
    // Update Loan (Simple)
    // --------------------------------
    fun updateMyLoan(
        loanAmount: Int,
        loanPurposeId: Int,
        guid: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMyLoan(
                loanAmount,
                loanPurposeId,
                guid
            )
            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Update MFI Details
    // --------------------------------
    fun updateMFI(
        loanAmount: Int,
        loanPurposeId: Int,
        mfiId: Int,
        outstandingAmount: Int,
        memberName: String,
        emi: Int,
        isEdited: Int,
        mfiGuid: String,
        guid: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMFI(
                loanAmount,
                loanPurposeId,
                mfiId,
                outstandingAmount,
                memberName,
                emi,
                isEdited,
                mfiGuid,
                guid
            )
            onComplete?.invoke()
        }
    }

    // --------------------------------
    // Load All Edited Loans for Upload
    // --------------------------------
    fun loadLoanUploadList() {
        viewModelScope.launch(Dispatchers.IO) {
            _loanUploadList.value = repository.getAllCustomerExistingLoanUpload() ?: emptyList()
        }
    }

    // --------------------------------
    // Update Uploaded
    // --------------------------------
    fun updateUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploaded()
        }
    }

    // --------------------------------
    // load upload flag by GUID
    // --------------------------------
    fun loadIsUploaded(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isUploaded.value = repository.getIsUploaded(guid)
        }
    }

    // --------------------------------
    // Load Upload Count
    // --------------------------------
    fun loadUploadCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _uploadCount.value = repository.getUploadCount()
        }
    }
}
