package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.KYCStatusConditionEntity
import com.psc.elekha.database.repository.KYCStatusConditionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KYCStatusConditionViewModel(
    private val repository: KYCStatusConditionRepository
) : ViewModel() {

    private val _allConditions = MutableStateFlow<List<KYCStatusConditionEntity>>(emptyList())
    val allConditions: StateFlow<List<KYCStatusConditionEntity>> = _allConditions

    // -------------------------------
    // Load all conditions
    // -------------------------------
    fun loadAllConditions() {

        viewModelScope.launch(Dispatchers.IO) {
            _allConditions.value = repository.getAllKYCStatusCondition()
        }
    }

    // -------------------------------
    // Insert single condition
    // -------------------------------
    fun insertCondition(condition: KYCStatusConditionEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertKYCStatusCondition(condition)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple conditions
    // -------------------------------
    fun insertAllConditions(conditions: List<KYCStatusConditionEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllKYCStatusCondition(conditions)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Delete all conditions
    // -------------------------------
    fun deleteAllConditions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKYCStatusCondition()
            _allConditions.value = emptyList()
        }
    }
}
