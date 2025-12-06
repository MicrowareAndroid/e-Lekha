package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.repository.MSTComboBox_NRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MSTComboBox_NViewModel(
    private val repository: MSTComboBox_NRepository
) : ViewModel() {

    private val _comboList = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val comboList: StateFlow<List<MSTComboBox_NEntity>> = _comboList

    private val _comboValue =
        MutableStateFlow<String>("")
    val comboValue: StateFlow<String> = _comboValue

    // Load all combo items (by Flag)
    fun loadAllComboBox(flag: Int) {
        viewModelScope.launch {
            val result = repository.getAllComboBox(flag)
            _comboList.value = result ?: emptyList()
        }
    }

    // Insert single combo
    fun insertComboBox(item: MSTComboBox_NEntity) {
        viewModelScope.launch {
            repository.insertComboBox(item)
        }
    }

    // Insert list of combo items
    fun insertAllComboBox(list: List<MSTComboBox_NEntity>?) {
        viewModelScope.launch {
            repository.insertAllComboBox(list)
        }
    }

    // Get ComboBox Value (Flag + ID)
    fun loadComboBoxValue(flag: Int, id: Int) {
        viewModelScope.launch {
            val value = repository.getComboBoxValue(flag, id)
            _comboValue.value = value ?: ""
        }
    }

    // Delete all combo items
    fun deleteAllComboBox() {
        viewModelScope.launch {
            repository.deleteAllComboBox()
            _comboList.value = emptyList()
        }
    }
}
