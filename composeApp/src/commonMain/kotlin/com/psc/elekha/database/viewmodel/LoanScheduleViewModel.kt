package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.LoanScheduleEntity
import com.psc.elekha.database.repository.LoanScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoanScheduleViewModel(
    private val repository: LoanScheduleRepository
) : ViewModel() {

    private val _allLoanSchedules = MutableStateFlow<List<LoanScheduleEntity>>(emptyList())
    val allLoanSchedules: StateFlow<List<LoanScheduleEntity>> = _allLoanSchedules

    // Load all loan schedules
    fun loadAllLoanSchedules() {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanSchedules.value = repository.getAllLoanSchedule() ?: emptyList()
        }
    }

    // Load schedules by GUID
    fun loadLoanScheduleByGUID(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanSchedules.value = repository.getLoanScheduleByGUID(GUID) ?: emptyList()
        }
    }

    fun insertLoanSchedule(loanSchedule: LoanScheduleEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanSchedule(loanSchedule)
            onComplete?.invoke()
        }
    }

    fun insertAllLoanSchedule(loanSchedules: List<LoanScheduleEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanSchedule(loanSchedules)
            onComplete?.invoke()
        }
    }

    // Additional functions for specific queries
    fun getLoanScheduleByGUIDAndPaidDate(GUID: String, onComplete: (List<LoanScheduleEntity>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getLoanScheduleByGUIDAndPaidDate(GUID) ?: emptyList()
            onComplete(data)
        }
    }

    fun getLoanScheduleModulusPay(GUID: String, sCurrentDate: String, onComplete: (List<LoanScheduleEntity>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getLoanScheduleModulusPay(GUID, sCurrentDate) ?: emptyList()
            onComplete(data)
        }
    }

    fun getUnpaidEMISum(GUID: String, onComplete: (Int) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val sum = repository.getUnpaidEMISum(GUID)
            onComplete(sum)
        }
    }

    fun getLastPaidDate(GUID: String, onComplete: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val date = repository.getLastPaidDate(GUID)
            onComplete(date)
        }
    }
}
