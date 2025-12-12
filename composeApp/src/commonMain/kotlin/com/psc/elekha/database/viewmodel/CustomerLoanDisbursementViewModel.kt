package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerLoanDisbursementEntity
import com.psc.elekha.database.repository.CustomerLoanDisbursementRepository
import com.psc.elekha.model.CustomerLoanDataClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class CustomerLoanDisbursementViewModel(
    private val repository: CustomerLoanDisbursementRepository
) : ViewModel() {

    // ---------------------------------------------------------
    // StateFlow Variables
    // ---------------------------------------------------------

    private val _allLoanDisbursement =
        MutableStateFlow<List<CustomerLoanDisbursementEntity>>(emptyList())
    val allLoanDisbursement: StateFlow<List<CustomerLoanDisbursementEntity>> =
        _allLoanDisbursement

    private val _loanDisbursementData =
        MutableStateFlow<List<CustomerLoanDataClass>>(emptyList())
    val loanDisbursementData: StateFlow<List<CustomerLoanDataClass>> =
        _loanDisbursementData

    private val _loanDisbursementByStatus =
        MutableStateFlow<List<CustomerLoanDataClass>>(emptyList())
    val loanDisbursementByStatus: StateFlow<List<CustomerLoanDataClass>> =
        _loanDisbursementByStatus

    // ---------------------------------------------------------
    // Load All Loan Disbursement
    // ---------------------------------------------------------
    fun loadAllLoanDisbursement() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllLoanDisbursement()
            _allLoanDisbursement.value = data
        }
    }

    // ---------------------------------------------------------
    // Load Loandisbursement data (status 2,3)
    // ---------------------------------------------------------
    fun loadLoanDisbursementData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getLoanDisbursementData()
            _loanDisbursementData.value = result
        }
    }

    // ---------------------------------------------------------
    // Load Loan Disbursement by Status
    // ---------------------------------------------------------
    fun loadLoanDisbursementDataByStatus(statusId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getLoanDisbursementDataByStatus(statusId)
            _loanDisbursementByStatus.value = result
        }
    }

    // ---------------------------------------------------------
    // Insert Single Loan Disbursement
    // ---------------------------------------------------------
    fun insertLoanDisbursement(
        entity: CustomerLoanDisbursementEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanDisbursement(entity)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Insert All Loan Disbursement
    // ---------------------------------------------------------
    fun insertAllLoanDisbursement(
        list: List<CustomerLoanDisbursementEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanDisbursement(list)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Delete All Loan Disbursement
    // ---------------------------------------------------------
    fun deleteAllLoanDisbursement() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllLoanDisbursement()
        }
    }
}
