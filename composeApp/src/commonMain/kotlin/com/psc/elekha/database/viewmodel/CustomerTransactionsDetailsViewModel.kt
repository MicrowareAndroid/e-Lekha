package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerTransactionsDetailsEntity
import com.psc.elekha.database.repository.CustomerTransactionsDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerTransactionsDetailsViewModel(
    private val repository: CustomerTransactionsDetailsRepository
) : ViewModel() {

    private val _allTransactions = MutableStateFlow<List<CustomerTransactionsDetailsEntity>>(emptyList())
    val allTransactions: StateFlow<List<CustomerTransactionsDetailsEntity>> = _allTransactions

    private val _transactionCount = MutableStateFlow(0)
    val transactionCount: StateFlow<Int> = _transactionCount

    // --------------------------------
    // Load All Transactions
    // --------------------------------
    fun loadAllTransactions(GUID: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllCustomerTransaction(GUID) ?: emptyList()
            _allTransactions.value = data
        }
    }

    // --------------------------------
    // Load Transaction Count
    // --------------------------------
    fun loadTransactionCount(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _transactionCount.value = repository.getTransactionCount(GUID)
        }
    }

    // --------------------------------
    // Insert Single Transaction
    // --------------------------------
    fun insertTransaction(transaction: CustomerTransactionsDetailsEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerTransaction(transaction)
        }
    }

    // --------------------------------
    // Insert Multiple Transactions
    // --------------------------------
    fun insertAllTransactions(transactions: List<CustomerTransactionsDetailsEntity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerTransaction(transactions)
        }
    }

    // --------------------------------
    // Delete All Transactions
    // --------------------------------
    fun deleteAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerTransaction()
        }
    }
}
