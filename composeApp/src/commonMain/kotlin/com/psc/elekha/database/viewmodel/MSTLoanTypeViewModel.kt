package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTLoanTypeEntity
import com.psc.elekha.database.repository.MSTLoanTypeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTLoanTypeViewModel(
    private val repository: MSTLoanTypeRepository
) : ViewModel() {

    private val _loanTypeList = MutableStateFlow<List<MSTLoanTypeEntity>>(emptyList())
    val loanTypeList: StateFlow<List<MSTLoanTypeEntity>> = _loanTypeList

    // Load all loan types
    fun loadAllLoanTypes() {
        viewModelScope.launch {
            val result = repository.getAllLoanType()
            _loanTypeList.value = result ?: emptyList()
        }
    }

    // Insert single loan type
    fun insertLoanType(item: MSTLoanTypeEntity) {
        viewModelScope.launch {
            repository.insertLoanType(item)
            loadAllLoanTypes() // Refresh list
        }
    }

    // Insert list of loan types
    fun insertAllLoanType(list: List<MSTLoanTypeEntity>?) {
        viewModelScope.launch {
            repository.insertAllLoanType(list)
            loadAllLoanTypes() // Refresh list
        }
    }

    // Delete all loan types
    fun deleteAllLoanType() {
        viewModelScope.launch {
            repository.deleteAllLoanType()
            _loanTypeList.value = emptyList()
        }
    }
}
