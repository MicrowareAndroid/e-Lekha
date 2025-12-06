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

    private val _allStatus = MutableStateFlow<List<CustomerStatusEntity>>(emptyList())
    val allStatus: StateFlow<List<CustomerStatusEntity>> = _allStatus

    private val _statusName = MutableStateFlow<String?>(null)
    val statusName: StateFlow<String?> = _statusName

    private val _statusData = MutableStateFlow<List<CustomerStatusEntity>>(emptyList())
    val statusData: StateFlow<List<CustomerStatusEntity>> = _statusData

    // ---------------------------------------------------------
    // Load All Status Records
    // ---------------------------------------------------------
    fun loadAllStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            _allStatus.value = repository.getAllCustomerStatus() ?: emptyList()
        }
    }

    // ---------------------------------------------------------
    // Load Single Status Name
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
            _statusData.value = repository.getCustomerStatusData() ?: emptyList()
        }
    }

    // ---------------------------------------------------------
    // Delete All Status
    // ---------------------------------------------------------
    fun deleteAllStatus(onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomerStatus()
            onComplete?.invoke()
        }
    }
}
