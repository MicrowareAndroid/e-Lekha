package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTPovertyStatusEntity
import com.psc.elekha.database.repository.MSTPovertyStatusRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTPovertyStatusViewModel(
    private val repository: MSTPovertyStatusRepository
) : ViewModel() {

    private val _povertyStatusList =
        MutableStateFlow<List<MSTPovertyStatusEntity>>(emptyList())
    val povertyStatusList: StateFlow<List<MSTPovertyStatusEntity>> = _povertyStatusList

    // Load all poverty status records
    fun loadAllPovertyStatus() {
        viewModelScope.launch {
            val result = repository.getAllPovertyStatus()
            _povertyStatusList.value = result ?: emptyList()
        }
    }

    // Insert single record
    fun insertPovertyStatus(item: MSTPovertyStatusEntity) {
        viewModelScope.launch {
            repository.insertPovertyStatus(item)
            loadAllPovertyStatus() // Refresh list
        }
    }

    // Insert list of records
    fun insertAllPovertyStatus(list: List<MSTPovertyStatusEntity>?) {
        viewModelScope.launch {
            repository.insertAllPovertyStatus(list)
            loadAllPovertyStatus() // Refresh list
        }
    }

    // Delete all records
    fun deleteAllPovertyStatus() {
        viewModelScope.launch {
            repository.deleteAllPovertyStatus()
            _povertyStatusList.value = emptyList()
        }
    }
}
