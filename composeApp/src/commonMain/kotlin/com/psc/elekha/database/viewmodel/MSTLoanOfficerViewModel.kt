package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTLoanOfficerEntity
import com.psc.elekha.database.repository.MSTLoanOfficerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTLoanOfficerViewModel(
    private val repository: MSTLoanOfficerRepository
) : ViewModel() {

    private val _loanOfficerList = MutableStateFlow<List<MSTLoanOfficerEntity>>(emptyList())
    val loanOfficerList: StateFlow<List<MSTLoanOfficerEntity>> = _loanOfficerList

    // Load all loan officers
    fun loadAllLoanOfficers() {
        viewModelScope.launch {
            val result = repository.getAllLoanOfficer()
            _loanOfficerList.value = result
        }
    }

    // Insert single loan officer
    fun insertLoanOfficer(item: MSTLoanOfficerEntity) {
        viewModelScope.launch {
            repository.insertLoanOfficer(item)
            loadAllLoanOfficers() // Refresh list
        }
    }

    // Insert list of loan officers
    fun insertAllLoanOfficer(list: List<MSTLoanOfficerEntity>) {
        viewModelScope.launch {
            repository.insertAllLoanOfficer(list)
            loadAllLoanOfficers() // Refresh list
        }
    }

    // Delete all loan officers
    fun deleteAllLoanOfficer() {
        viewModelScope.launch {
            repository.deleteAllLoanOfficer()
            _loanOfficerList.value = emptyList()
        }
    }
}
