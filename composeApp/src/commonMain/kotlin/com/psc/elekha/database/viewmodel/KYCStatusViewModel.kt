package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.KYCStatusEntity
import com.psc.elekha.database.repository.KYCStatusRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KYCStatusViewModel(
    private val repository: KYCStatusRepository
) : ViewModel() {

    private val _allStatus = MutableStateFlow<List<KYCStatusEntity>>(emptyList())
    val allStatus: StateFlow<List<KYCStatusEntity>> = _allStatus

    // -------------------------------
    // Load all KYC status
    // -------------------------------
    fun loadAllStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            _allStatus.value = repository.getAllKYCStatus() ?: emptyList()
        }
    }

    // -------------------------------
    // Insert single status
    // -------------------------------
    fun insertStatus(status: KYCStatusEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertKYCStatus(status)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple statuses
    // -------------------------------
    fun insertAllStatus(statusList: List<KYCStatusEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllKYCStatus(statusList)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Delete all statuses
    // -------------------------------
    fun deleteAllStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKYCStatus()
            _allStatus.value = emptyList()
        }
    }
}
