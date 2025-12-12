package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.RegistrationStatusEntity
import com.psc.elekha.database.repository.RegistrationStatusRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistrationStatusViewModel(
    private val repository: RegistrationStatusRepository
) : ViewModel() {

    private val _registrationStatusList =
        MutableStateFlow<List<RegistrationStatusEntity>>(emptyList())
    val registrationStatusList: StateFlow<List<RegistrationStatusEntity>> = _registrationStatusList

    // Load all registration statuses
    fun loadAllRegistrationStatuses() {
        viewModelScope.launch {
            val result = repository.getAllRegistrationStatus()
            _registrationStatusList.value = result
        }
    }

    // Insert single registration status
    fun insertRegistrationStatus(item: RegistrationStatusEntity) {
        viewModelScope.launch {
            repository.insertRegistrationStatus(item)
            loadAllRegistrationStatuses() // Refresh list
        }
    }

    // Insert list of registration statuses
    fun insertAllRegistrationStatus(list: List<RegistrationStatusEntity>) {
        viewModelScope.launch {
            repository.insertAllRegistrationStatus(list)
            loadAllRegistrationStatuses() // Refresh list
        }
    }

    // Get registration status by ID
    val statusByID = MutableStateFlow<String?>(null)
    fun fetchRegistrationStatusByID(registrationStatusID: Int) {
        viewModelScope.launch {
            statusByID.value = repository.getRegistrationStatusByID(registrationStatusID)
        }
    }

    // Delete all registration statuses
    fun deleteAllRegistrationStatuses() {
        viewModelScope.launch {
            repository.deleteAllRegistrationStatus()
            _registrationStatusList.value = emptyList()
            statusByID.value = null
        }
    }
}
