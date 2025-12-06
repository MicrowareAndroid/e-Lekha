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

    private val _transactionByMerchant = MutableStateFlow<CustomerTransactionDataEntity?>(null)
    val transactionByMerchant: StateFlow<CustomerTransactionDataEntity?> = _transactionByMerchant

    // --------------------------------
    // Load All Transactions
    // --------------------------------
    fun loadAllTransactions(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllCustomerTransactionData(GUID) ?: emptyList()
            _allTransactions.value = data
        }
    }

    // --------------------------------
    // Load Transactions for Upload
    // --------------------------------
    fun loadAllTransactionsUpload() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllCustomerTransactionDataUpload() ?: emptyList()
            _uploadTransactions.value = data
        }
    }

    // --------------------------------
    // Load Transaction Count by GUID
    // --------------------------------
    fun loadTransactionCount(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _transactionCount.value = repository.getAllCustomerTransactionDataCount(GUID)
        }
    }

    // --------------------------------
    // Load Total Upload Count
    // --------------------------------
    fun loadUploadTransactionCount() {

        viewModelScope.launch(Dispatchers.IO) {
            _transactionCount.value = repository.getAllCustomerTransactionDataCount()
        }
    }

    // --------------------------------
    // Load Transaction by MerchantTransactionID
    // --------------------------------
    fun loadTransactionByMerchant(MerchantTransactionID: String, GUID: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _transactionByMerchant.value = repository.getDatabyMerchantTransID(MerchantTransactionID, GUID)
        }
    }

    // --------------------------------
    // Update Uploaded Transactions
    // --------------------------------
    fun updateUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUploaded()
        }
    }

    // --------------------------------
    // Insert Single Transaction
    // --------------------------------
    fun insertTransaction(transaction: CustomerTransactionDataEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerTransactionData(transaction)
        }
    }

    // --------------------------------
    // Insert Multiple Transactions
    // --------------------------------
    fun insertAllTransactions(transactions: List<CustomerTransactionDataEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerTransactionData(transactions)
        }
    }

    // --------------------------------
    // Delete All Transactions
    // --------------------------------
    fun deleteAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerTransactionData()
        }
    }
}
