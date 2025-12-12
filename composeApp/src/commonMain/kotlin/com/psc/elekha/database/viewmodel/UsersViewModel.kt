package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.UsersEntity
import com.psc.elekha.database.repository.UsersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel() {

    private val _userList = MutableStateFlow<List<UsersEntity>>(emptyList())
    val userList: StateFlow<List<UsersEntity>> = _userList

    private val _userCount = MutableStateFlow(0)
    val userCount: StateFlow<Int> = _userCount

    private val _userDetails = MutableStateFlow<List<UsersEntity>>(emptyList())
    val userDetails: StateFlow<List<UsersEntity>> = _userDetails

    // Load all users
    fun loadAllUsers() {
        viewModelScope.launch {
            val result = repository.getAllUsers()
            _userList.value = result ?: emptyList()
        }
    }

    // Load total users count
    fun loadUsersCount() {
        viewModelScope.launch {
            val count = repository.getAllUsersCount() ?: 0
            _userCount.value = count
        }
    }

    // Load user details by username and password
    fun fetchUserDetails(userName: String, password: String) {
        viewModelScope.launch {
            val details = repository.getUserDetails(userName, password)
            _userDetails.value = details
        }
    }

    // Insert single user
    fun insertUser(item: UsersEntity) {
        viewModelScope.launch {
            repository.insertUser(item)
            loadAllUsers() // Refresh list
            loadUsersCount() // Refresh count
        }
    }

    // Insert list of users
    fun insertAllUsers(list: List<UsersEntity>) {
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
