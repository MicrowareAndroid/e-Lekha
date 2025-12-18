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
    private val _maritalStatus = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val maritalStatus: StateFlow<List<MSTComboBox_NEntity>> = _maritalStatus

    private val _mstQualificationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val mstQualificationValue: StateFlow<List<MSTComboBox_NEntity>> = _mstQualificationValue

    private val _religionValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val religionValue: StateFlow<List<MSTComboBox_NEntity>> = _religionValue

    private val _relationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val relationValue: StateFlow<List<MSTComboBox_NEntity>> = _relationValue

    private val _locationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val locationValue: StateFlow<List<MSTComboBox_NEntity>> = _locationValue

    private val _genderValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val genderValue: StateFlow<List<MSTComboBox_NEntity>> = _genderValue

    private val _occupationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val occupationValue: StateFlow<List<MSTComboBox_NEntity>> = _occupationValue

    private val _vehicleasset = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val vehicleasset: StateFlow<List<MSTComboBox_NEntity>> = _vehicleasset

    private val _bankName = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val bankName: StateFlow<List<MSTComboBox_NEntity>> = _bankName

    private val _bankNameLocation = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val bankNameLocation: StateFlow<List<MSTComboBox_NEntity>> = _bankNameLocation



    fun loadLookUpValues(lookupTypeFk:Int) {
        viewModelScope.launch {
            val result = repository.getAllComboBox(lookupTypeFk,)
            when(lookupTypeFk){
                1-> _maritalStatus.value = result
                2-> _mstQualificationValue.value = result
                3-> _religionValue.value = result
                4-> _relationValue.value = result
                5-> _locationValue.value = result
                6-> _genderValue.value = result
                9-> _occupationValue.value = result
                10-> _vehicleasset.value = result
                11-> _bankName.value = result
                12-> _bankNameLocation.value = result

            }
        }
    }


    // Load all combo items (by Flag)
    fun loadAllComboBox(flag: Int) {
        viewModelScope.launch {
            val result = repository.getAllComboBox(flag)
            _comboList.value = result
        }
    }


    // Insert single combo
    fun insertComboBox(item: MSTComboBox_NEntity) {
        viewModelScope.launch {
            repository.insertComboBox(item)
        }
    }

    // Insert list of combo items
    fun insertAllComboBox(list: List<MSTComboBox_NEntity>) {
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
