package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTMFILoanProductEntity
import com.psc.elekha.database.repository.MSTMFILoanProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTMFILoanProductViewModel(
    private val repository: MSTMFILoanProductRepository
) : ViewModel() {

    private val _mfiLoanProductList = MutableStateFlow<List<MSTMFILoanProductEntity>>(emptyList())
    val mfiLoanProductList: StateFlow<List<MSTMFILoanProductEntity>> = _mfiLoanProductList

    private val _loanProductAmount = MutableStateFlow<Int?>(null)
    val loanProductAmount: StateFlow<Int?> = _loanProductAmount

    // Load all MFI loan products
    fun loadAllMFILoanProducts() {
        viewModelScope.launch {
            val result = repository.getAllMFILoanProduct()
            _mfiLoanProductList.value = result ?: emptyList()
        }
    }

    // Load MFI loan products by MFIID
    fun loadMFILoanProductsByMFIID(MFIID: Int) {
        viewModelScope.launch {
            val result = repository.getMFILoanProductByMFIID(MFIID)
            _mfiLoanProductList.value = result ?: emptyList()
        }
    }

    // Get LoanProductAmount by MFILoanProductID
    fun fetchLoanProductAmount(MFILoanProductID: Int) {
        viewModelScope.launch {
            val result = repository.getLoanProductAmount(MFILoanProductID)
            _loanProductAmount.value = result
        }
    }

    // Insert single MFI loan product
    fun insertMFILoanProduct(item: MSTMFILoanProductEntity) {
        viewModelScope.launch {
            repository.insertMFILoanProduct(item)
            loadAllMFILoanProducts() // Refresh list
        }
    }

    // Insert list of MFI loan products
    fun insertAllMFILoanProduct(list: List<MSTMFILoanProductEntity>?) {
        viewModelScope.launch {
            repository.insertAllMFILoanProduct(list)
            loadAllMFILoanProducts() // Refresh list
        }
    }

    // Delete all MFI loan products
    fun deleteAllMFILoanProduct() {
        viewModelScope.launch {
            repository.deleteAllMFILoanProduct()
            _mfiLoanProductList.value = emptyList()
            _loanProductAmount.value = null
        }
    }
}
