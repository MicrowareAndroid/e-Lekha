package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTBranchEntity
import com.psc.elekha.database.repository.MSTBranchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTBranchViewModel(
    private val repository: MSTBranchRepository
) : ViewModel() {

    private val _branchList = MutableStateFlow<List<MSTBranchEntity>>(emptyList())
    val branchList: StateFlow<List<MSTBranchEntity>> = _branchList

    // Load all branches
    fun loadAllBranches() {
        viewModelScope.launch {
            val result = repository.getAllBranch()
            _branchList.value = result ?: emptyList()
        }
    }

    // Insert single branch
    fun insertBranch(item: MSTBranchEntity) {
        viewModelScope.launch {
            repository.insertBranch(item)
            loadAllBranches() // Refresh list
        }
    }

    // Insert list of branches
    fun insertAllBranch(list: List<MSTBranchEntity>?) {
        viewModelScope.launch {
            repository.insertAllBranch(list)
            loadAllBranches() // Refresh list
        }
    }

    // Delete all branches
    fun deleteAllBranch() {
        viewModelScope.launch {
            repository.deleteAllBranch()
            _branchList.value = emptyList()
        }
    }
}
