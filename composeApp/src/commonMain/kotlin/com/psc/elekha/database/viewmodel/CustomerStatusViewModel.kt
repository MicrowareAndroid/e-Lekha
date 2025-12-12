package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.repository.CustomerStatusRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerStatusViewModel(
    private val repository: CustomerStatusRepository
) : ViewModel() {

    // ---------------------------------------------------------
    // StateFlow Variables
    // ---------------------------------------------------------

    private val _allStatus = MutableStateFlow<List<CustomerStatusEntity>>(emptyList())
    val allStatus: StateFlow<List<CustomerStatusEntity>> = _allStatus

    private val _statusName = MutableStateFlow<String?>(null)
    val statusName: StateFlow<String?> = _statusName

    private val _statusData = MutableStateFlow<List<CustomerStatusEntity>>(emptyList())
    val statusData: StateFlow<List<CustomerStatusEntity>> = _statusData

    // ---------------------------------------------------------
    // Insert Single Customer Status
    // ---------------------------------------------------------
    fun insertCustomerStatus(
        status: CustomerStatusEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCustomerStatus(status)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Insert List of Customer Status
    // ---------------------------------------------------------
    fun insertAllCustomerStatus(
        list: List<CustomerStatusEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllCustomerStatus(list)
            onComplete?.invoke()
        }
    }

    // ---------------------------------------------------------
    // Load All Status Records
    // ---------------------------------------------------------
    fun loadAllStatus() {

        viewModelScope.launch(Dispatchers.IO) {
            _allStatus.value = repository.getAllCustomerStatus()
        }
    }

    // ---------------------------------------------------------
    // Load Single Status Name by ID
    // ---------------------------------------------------------
    fun loadCustomerStatusName(statusId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _statusName.value = repository.getCustomerStatus(statusId)
        }
    }

    // ---------------------------------------------------------
    // Load Status Data (IDs 2,3 Only)
    // ---------------------------------------------------------
    fun loadCustomerStatusData() {
        viewModelScope.launch(Dispatchers.IO) {
            _statusData.value = repository.getCustomerStatusData()
        }
    }

    // ---------------------------------------------------------
    // Delete All Status Records
    // ---------------------------------------------------------
    fun deleteAllStatus(onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerStatus()
            onComplete?.invoke()
        }
    }
}
