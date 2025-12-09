package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerTransactionDataEntity
import com.psc.elekha.database.repository.CustomerTransactionDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerTransactionDataViewModel(
    private val repository: CustomerTransactionDataRepository
) : ViewModel() {

    private val _allTransactions = MutableStateFlow<List<CustomerTransactionDataEntity>>(emptyList())
    val allTransactions: StateFlow<List<CustomerTransactionDataEntity>> = _allTransactions

    private val _uploadTransactions = MutableStateFlow<List<CustomerTransactionDataEntity>>(emptyList())
    val uploadTransactions: StateFlow<List<CustomerTransactionDataEntity>> = _uploadTransactions

    private val _transactionCount = MutableStateFlow(0)
    val transactionCount: StateFlow<Int> = _transactionCount

    private val _uploadCount = MutableStateFlow(0)
    val uploadCount: StateFlow<Int> = _uploadCount

    private val _transactionByMerchant = MutableStateFlow<CustomerTransactionDataEntity?>(null)
    val transactionByMerchant: StateFlow<CustomerTransactionDataEntity?> = _transactionByMerchant

    // --------------------------------
    fun loadAllTransactions(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _allTransactions.value = repository.getAllCustomerTransactionData(GUID) ?: emptyList()
        }
    }

    // --------------------------------
    fun loadAllTransactionsUpload() {
        viewModelScope.launch(Dispatchers.IO) {
            _uploadTransactions.value = repository.getAllCustomerTransactionDataUpload() ?: emptyList()
        }
    }

    // --------------------------------
    fun loadTransactionCount(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _transactionCount.value = repository.getAllCustomerTransactionDataCount(GUID)
        }
    }

    // --------------------------------
    fun loadUploadTransactionCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _uploadCount.value = repository.getAllCustomerTransactionDataCount()
        }
    }

    // --------------------------------
    fun loadTransactionByMerchant(MerchantTransactionID: String, GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _transactionByMerchant.value = repository.getDatabyMerchantTransID(MerchantTransactionID, GUID)
        }
    }

    // --------------------------------
    fun updateUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploaded()
        }
    }

    // --------------------------------
    fun insertTransaction(transaction: CustomerTransactionDataEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerTransactionData(transaction)
        }
    }

    // --------------------------------
    fun insertAllTransactions(transactions: List<CustomerTransactionDataEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerTransactionData(transactions)
        }
    }

    // --------------------------------
    fun deleteAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerTransactionData()
        }
    }
}
