package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.repository.CustomerExistingLoanDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

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


    // -------------------------------------------------
    // LOAD ALL LOANS BY GUID
    // -------------------------------------------------
    fun loadAllLoans(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoans.value = repository.getAllCustomerExistingLoan(guid)
        }
    }

    // -------------------------------------------------
    // INSERT ONE LOAN
    // -------------------------------------------------
    fun insertCustomerExistingLoan(
        loan: CustomerExistingLoanDetailEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerExistingLoan(loan)
            onComplete?.invoke()
        }
    }

    // -------------------------------------------------
    // INSERT ALL LOANS
    // -------------------------------------------------
    fun insertAllCustomerExistingLoan(
        loans: List<CustomerExistingLoanDetailEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerExistingLoan(loans)
            onComplete?.invoke()
        }
    }

    // -------------------------------------------------
    // DELETE ALL EXISTING LOANS
    // -------------------------------------------------
    fun deleteAllLoans() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerExistingLoan()
        }
    }

    // -------------------------------------------------
    // GET LOAN COUNT
    // -------------------------------------------------
    fun loadLoanCount(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loanCount.value = repository.getMyLoanCount(guid)
        }
    }

    // -------------------------------------------------
    // UPDATE LOAN
    // -------------------------------------------------
    fun updateMyLoan(
        loanAmount: Int,
        loanPurposeId: Int,
        guid: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateMyLoan(loanAmount, loanPurposeId, guid)
            onComplete?.invoke()
        }
    }

    // -------------------------------------------------
    // UPDATE MFI DETAILS
    // -------------------------------------------------
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

    // -------------------------------------------------
    // LOAD EDITED LOANS FOR UPLOAD
    // -------------------------------------------------
    fun loadLoanUploadList() {
        viewModelScope.launch(Dispatchers.IO) {
            _loanUploadList.value =
                repository.getAllCustomerExistingLoanUpload()
        }
    }

    // -------------------------------------------------
    // MARK DATA AS UPLOADED
    // -------------------------------------------------
    fun updateUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploaded()
        }
    }

    // -------------------------------------------------
    // GET UPLOADED FLAG BY GUID
    // -------------------------------------------------
    fun loadIsUploaded(guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isUploaded.value = repository.getIsUploaded(guid)
        }
    }

    // -------------------------------------------------
    // GET COUNT OF UPLOADABLE DATA
    // -------------------------------------------------
    fun loadUploadCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _uploadCount.value = repository.getUploadCount()
        }
    }
}
