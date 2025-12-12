package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.UserBranchEntity
import com.psc.elekha.database.repository.UserBranchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserBranchViewModel(
    private val repository: UserBranchRepository
) : ViewModel() {

    private val _userBranchList = MutableStateFlow<List<UserBranchEntity>>(emptyList())
    val userBranchList: StateFlow<List<UserBranchEntity>> = _userBranchList

    private val _branchID = MutableStateFlow<Int?>(null)
    val branchID: StateFlow<Int?> = _branchID

    // Load all user branches
    fun loadAllUserBranches() {
        viewModelScope.launch {
            val result = repository.getAllUserBranch()
            _userBranchList.value = result
        }
    }

    // Insert single user branch
    fun insertUserBranch(item: UserBranchEntity) {
        viewModelScope.launch {
            repository.insertUserBranch(item)
            loadAllUserBranches() // Refresh list
        }
    }

    // Insert list of user branches
    fun insertAllUserBranch(list: List<UserBranchEntity>) {
        viewModelScope.launch {
            repository.insertAllUserBranch(list)
            loadAllUserBranches() // Refresh list
        }
    }

    // Get BranchID for a specific UserID
    fun fetchBranchIDByUser(userID: String) {
        viewModelScope.launch {
            _branchID.value = repository.getBranchIDByUser(userID)
        }
    }

    // Delete all user branches
    fun deleteAllUserBranch() {
        viewModelScope.launch {
            repository.deleteAllUserBranch()
            _userBranchList.value = emptyList()
            _branchID.value = null
        }
    }
}
