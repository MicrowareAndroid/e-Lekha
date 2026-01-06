package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity
import com.psc.elekha.database.repository.LoanOfficerDashboardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoanOfficerDashboardViewModel(private val repository: LoanOfficerDashboardRepository) :
    ViewModel() {
    private val _loDataList = MutableStateFlow<List<LoanofficerDashBoardDataEntity>>(emptyList())
    val loDataList: StateFlow<List<LoanofficerDashBoardDataEntity>> = _loDataList
    fun getAllLoanOfficerData() {
        viewModelScope.launch {
            val result = repository.getAllLoanOfficerData()
            _loDataList.value = result
        }
    }

    fun insertAllLoanOfficerData(list: List<LoanofficerDashBoardDataEntity>) {
        viewModelScope.launch {
            repository.insertAllLoanOfficerData(list)
            getAllLoanOfficerData()
        }
    }

}