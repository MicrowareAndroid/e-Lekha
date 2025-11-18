package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.UserEntity
import com.psc.elekha.database.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewmodel(private val userRepository: UserRepository): ViewModel() {

    private val _users = MutableStateFlow<List<UserEntity>>(emptyList())
    val users: StateFlow<List<UserEntity>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            val result = userRepository.getAllUser()
            _users.value = result
        }
    }

    fun deleteAllsubCategories(){
        viewModelScope.launch {
            userRepository.deleteAllUsers()
        }
    }

}