package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.repository.LoanRepaymentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoanRepaymentViewModel(
    private val repository: LoanRepaymentRepository
) : ViewModel() {

    private val _allLoanRepayments = MutableStateFlow<List<LoanRepaymentEntity>>(emptyList())
    val allLoanRepayments: StateFlow<List<LoanRepaymentEntity>> = _allLoanRepayments

    private val _loanRepaymentUploadData = MutableStateFlow<List<LoanRepaymentEntity>>(emptyList())
    val loanRepaymentUploadData: StateFlow<List<LoanRepaymentEntity>> = _loanRepaymentUploadData

    private val _loanRepaymentUploadCount = MutableStateFlow(0)
    val loanRepaymentUploadCount: StateFlow<Int> = _loanRepaymentUploadCount


    fun loadAllLoanRepayment() {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanRepayments.value = repository.getAllLoanRepayment() ?: emptyList()
        }
    }

    fun loadLoanRepaymentUploadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loanRepaymentUploadData.value =
                repository.getLoanRepaymentUploadData() ?: emptyList()

            _loanRepaymentUploadCount.value =
                repository.getLoanRepaymentUploadDataCount()
        }
    }


    fun insertLoanRepayment(
        loanRepayment: LoanRepaymentEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanRepayment(loanRepayment)
            onComplete?.invoke()
        }
    }


    fun insertAllLoanRepayment(
        loanRepayments: List<LoanRepaymentEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanRepayment(loanRepayments)
            onComplete?.invoke()
        }
    }


    fun getLoanRepaymentByGUID(
        GUID: String,
        onResult: (LoanRepaymentEntity?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getLoanRepaymentByGUID(GUID)
            onResult(data)
        }
    }

    fun updateLoanRepaymentData(
        Total: Double,
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        PaymentType: Int,
        GUID: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanRepaymentData(
                Total,
                PaidDate,
                LoanLat,
                LoanLong,
                LoanPlace,
                PaymentType,
                GUID
            )
            onComplete?.invoke()
        }
    }


    fun updateLoanRepaymentDataUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanRepaymentDataUploaded()
        }
    }

    fun deleteAllLoanRepayment() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllLoanRepayment()

            _allLoanRepayments.value = emptyList()
            _loanRepaymentUploadData.value = emptyList()
            _loanRepaymentUploadCount.value = 0
        }
    }
}
