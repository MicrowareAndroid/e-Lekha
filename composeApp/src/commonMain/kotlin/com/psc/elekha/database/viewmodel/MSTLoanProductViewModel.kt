package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTLoanProductEntity
import com.psc.elekha.database.repository.MSTLoanProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTLoanProductViewModel(
    private val repository: MSTLoanProductRepository
) : ViewModel() {

    private val _loanProductList = MutableStateFlow<List<MSTLoanProductEntity>>(emptyList())
    val loanProductList: StateFlow<List<MSTLoanProductEntity>> = _loanProductList

    private val _newLoanProductList =
        MutableStateFlow<List<MSTLoanProductEntity>>(emptyList())
    val newLoanProductList: StateFlow<List<MSTLoanProductEntity>> = _newLoanProductList

    private val _loanAmount =
        MutableStateFlow<Double?>(null)
    val loanAmount: StateFlow<Double?> = _loanAmount

    // Load loan products by LoanProductID
    fun loadAllLoanProducts(loanProductID: Int) {
        viewModelScope.launch {
            val result = repository.getAllLoanProduct(loanProductID)
            _loanProductList.value = result ?: emptyList()
        }
    }

    // Load all active loan amounts
    fun loadLoanAmount() {
        viewModelScope.launch {
            val result = repository.getLoanAmount()
            _loanProductList.value = result ?: emptyList()
        }
    }

    // Load new loan amounts (LoanProductID in 25,31)
    fun loadNewLoanAmount() {
        viewModelScope.launch {
            val result = repository.getNewLoanAmount()
            _newLoanProductList.value = result ?: emptyList()
        }
    }

    // Get loan product value by LoanProductID
    fun fetchLoanProductByLoanID(loanProductID: Int) {
        viewModelScope.launch {
            val result = repository.getLoanProductByLoanID(loanProductID)
            _loanAmount.value = result
        }
    }

    // Insert single loan product
    fun insertLoanProduct(item: MSTLoanProductEntity) {
        viewModelScope.launch {
            repository.insertLoanProduct(item)
            loadAllLoanProducts(item.LoanProductID)
        }
    }

    // Insert list of loan products
    fun insertAllLoanProduct(list: List<MSTLoanProductEntity>?) {
        viewModelScope.launch {
            repository.insertAllLoanProduct(list)
            list?.firstOrNull()?.let {
                loadAllLoanProducts(it.LoanProductID)
            }
        }
    }

    // Delete all loan products
    fun deleteAllLoanProduct() {
        viewModelScope.launch {
            repository.deleteAllLoanProduct()
            _loanProductList.value = emptyList()
            _newLoanProductList.value = emptyList()
            _loanAmount.value = null
        }
    }
}
