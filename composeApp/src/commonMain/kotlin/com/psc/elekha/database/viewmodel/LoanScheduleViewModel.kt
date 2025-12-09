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

    // ---------------------------------------------------------
    // Load all schedules
    // ---------------------------------------------------------
    fun loadAllLoanSchedules() {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanSchedules.value = repository.getAllLoanSchedule() ?: emptyList()
        }
    }

    // ---------------------------------------------------------
    // Load schedules by GUID
    // ---------------------------------------------------------
    fun loadLoanScheduleByGUID(GUID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanSchedules.value = repository.getLoanScheduleByGUID(GUID) ?: emptyList()
        }
    }

    // ---------------------------------------------------------
    // Insert single schedule
    // ---------------------------------------------------------
    fun insertLoanSchedule(
        loanSchedule: LoanScheduleEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanSchedule(loanSchedule)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Insert multiple schedules
    // ---------------------------------------------------------
    fun insertAllLoanSchedule(
        loanSchedules: List<LoanScheduleEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanSchedule(loanSchedules)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Functions directly mapped from repository
    // ---------------------------------------------------------

    fun getLoanScheduleByGUIDAndPaidDate(
        GUID: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleByGUIDAndPaidDate(GUID) ?: emptyList())
        }
    }

    fun getLoanScheduleByGUIDAndPaidDateWithLimit(
        GUID: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleByGUIDAndPaidDateWithLimit(GUID) ?: emptyList())
        }
    }

    fun getLoanScheduleByGUIDAndPaidDateWithLimit4(
        GUID: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID) ?: emptyList())
        }
    }

    fun getWorkingDateByGUID(
        GUID: String,
        onComplete: (String?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getWorkingDateByGUID(GUID))
        }
    }

    fun getEMIDueDateByGUID(
        GUID: String,
        onComplete: (String?) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getEMIDueDateByGUID(GUID))
        }
    }

    fun getLoanScheduleModulus(
        GUID: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleModulus(GUID) ?: emptyList())
        }
    }

    fun getLoanScheduleCountByGUID(
        GUID: String,
        onComplete: (Int) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleCountByGUID(GUID))
        }
    }

    fun getMaxCustomerLoanID(
        GUID: String,
        onComplete: (Int) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getMaxCustomerLoanID(GUID))
        }
    }

    fun getCloseDate(
        GUID: String,
        CustomerLoanID: Int,
        onComplete: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getCloseDate(GUID, CustomerLoanID))
        }
    }

    fun getLoanScheduleModulusPay(
        GUID: String,
        sCurrentDate: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLoanScheduleModulusPay(GUID, sCurrentDate) ?: emptyList())
        }
    }

    fun getLoanScheduleModulusPayTwoDate(
        GUID: String,
        sLastPaidDate: String,
        sCurrentDate: String,
        onComplete: (List<LoanScheduleEntity>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(
                repository.getLoanScheduleModulusPayTwoDate(
                    GUID,
                    sLastPaidDate,
                    sCurrentDate
                ) ?: emptyList()
            )
        }
    }

    fun getLastPaidDate(
        GUID: String,
        onComplete: (String) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getLastPaidDate(GUID))
        }
    }

    fun getUnpaidEMISum(
        GUID: String,
        onComplete: (Int) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getUnpaidEMISum(GUID))
        }
    }

    fun getMaxCustomerLoanIDBYEMI(
        GUID: String,
        CustomerLoanID: Int,
        onComplete: (Int) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onComplete(repository.getMaxCustomerLoanIDBYEMI(GUID, CustomerLoanID))
        }
    }
}
