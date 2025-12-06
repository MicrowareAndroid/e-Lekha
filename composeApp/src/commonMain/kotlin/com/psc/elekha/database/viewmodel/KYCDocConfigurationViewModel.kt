package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.KYCDocConfigurationEntity
import com.psc.elekha.database.repository.KYCDocConfigurationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KYCDocConfigurationViewModel(
    private val repository: KYCDocConfigurationRepository
) : ViewModel() {

    private val _allConfigurations = MutableStateFlow<List<KYCDocConfigurationEntity>>(emptyList())
    val allConfigurations: StateFlow<List<KYCDocConfigurationEntity>> = _allConfigurations

    // -------------------------------
    // Load all configurations
    // -------------------------------
    fun loadAllConfigurations() {
        viewModelScope.launch(Dispatchers.IO) {
            _allConfigurations.value = repository.getAllKYCDocConfiguration() ?: emptyList()
        }
    }

    // -------------------------------
    // Insert single configuration
    // -------------------------------
    fun insertConfiguration(config: KYCDocConfigurationEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertKYCDocConfiguration(config)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple configurations
    // -------------------------------
    fun insertAllConfigurations(configs: List<KYCDocConfigurationEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllKYCDocConfiguration(configs)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Delete all configurations
    // -------------------------------
    fun deleteAllConfigurations() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKYCDocConfiguration()
            _allConfigurations.value = emptyList()
        }
    }
}
