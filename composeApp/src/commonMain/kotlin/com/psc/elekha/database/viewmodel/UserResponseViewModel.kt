package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.UserResponseEntity
import com.psc.elekha.database.repository.UserResponseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserResponseViewModel(
    private val repository: UserResponseRepository
) : ViewModel() {

    private val _userList = MutableStateFlow<List<UserResponseEntity>>(emptyList())
    val userList: StateFlow<List<UserResponseEntity>> = _userList

    private val _userCount = MutableStateFlow(0)
    val userCount: StateFlow<Int> = _userCount

    private val _userDetails = MutableStateFlow<List<UserResponseEntity>>(emptyList())
    val userDetails: StateFlow<List<UserResponseEntity>> = _userDetails

    // Load all users
    fun loadAllUsers() {
        viewModelScope.launch {
            val result = repository.getAllUsers()
            _userList.value = result
        }
    }

    // Load total users count
    fun loadUsersCount() {
        viewModelScope.launch {
            val count = repository.getAllUsersCount() ?: 0
            _userCount.value = count
        }
    }

    // Load user details by contact
    fun fetchUserDetails(contact: String) {
        viewModelScope.launch {
            val details = repository.getUserDetails(contact)
            _userDetails.value = details
        }
    }

    // Insert single user
    fun insertUser(item: UserResponseEntity) {
        viewModelScope.launch {
            repository.insertUser(item)
            loadAllUsers() // Refresh list
            loadUsersCount() // Refresh count
        }
    }

    // Insert list of users
    fun insertAllUsers(list: List<UserResponseEntity>) {
        viewModelScope.launch {
            repository.insertAllUsers(list)
            loadAllUsers() // Refresh list
            loadUsersCount() // Refresh count
        }
    }

    // Delete all users
    fun deleteAllUsers() {
        viewModelScope.launch {
            repository.deleteAllUsers()
            _userList.value = emptyList()
            _userCount.value = 0
            _userDetails.value = emptyList()
        }
    }
}
