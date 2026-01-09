package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.entity.UserContactDetailEntity
import com.psc.elekha.database.repository.ImageDetailRepository
import com.psc.elekha.database.repository.UserContactDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserContactDetailViewModel(
    private val repository: UserContactDetailRepository
) : ViewModel() {

    fun insertUserContactDetail(
        user: UserContactDetailEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUserContactDetail(user)
            onComplete?.invoke()
        }
    }

    suspend fun insertAllUserContactDetail(
        users: List<UserContactDetailEntity>
    ) {
            repository.insertAllUserContactDetail(users)
    }



    fun deleteAllUserContactDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUserContactDetail()

        }
    }
}
