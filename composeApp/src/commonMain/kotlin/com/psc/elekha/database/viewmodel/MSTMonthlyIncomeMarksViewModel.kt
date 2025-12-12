package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity
import com.psc.elekha.database.repository.MSTMonthlyIncomeMarksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTMonthlyIncomeMarksViewModel(
    private val repository: MSTMonthlyIncomeMarksRepository
) : ViewModel() {

    private val _monthlyIncomeMarksList =
        MutableStateFlow<List<MSTMonthlyIncomeMarksEntity>>(emptyList())
    val monthlyIncomeMarksList: StateFlow<List<MSTMonthlyIncomeMarksEntity>> = _monthlyIncomeMarksList

    // Load all monthly income marks
    fun loadAllMonthlyIncomeMarks() {
        viewModelScope.launch {
            val result = repository.getAllMonthlyIncomeMarks()
            _monthlyIncomeMarksList.value = result
        }
    }

    // Insert single record
    fun insertMonthlyIncomeMarks(item: MSTMonthlyIncomeMarksEntity) {
        viewModelScope.launch {
            repository.insertMonthlyIncomeMarks(item)
            loadAllMonthlyIncomeMarks() // Refresh list
        }
    }

    // Insert list of records
    fun insertAllMonthlyIncomeMarks(list: List<MSTMonthlyIncomeMarksEntity>) {
        viewModelScope.launch {
            repository.insertAllMonthlyIncomeMarks(list)
            loadAllMonthlyIncomeMarks() // Refresh list
        }
    }

    // Delete all records
    fun deleteAllMonthlyIncomeMarks() {
        viewModelScope.launch {
            repository.deleteAllMonthlyIncomeMarks()
            _monthlyIncomeMarksList.value = emptyList()
        }
    }
}
