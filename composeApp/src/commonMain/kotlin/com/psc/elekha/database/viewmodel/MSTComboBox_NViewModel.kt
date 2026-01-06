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

    private val _relationStatus = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val relationStatus: StateFlow<List<MSTComboBox_NEntity>> = _relationStatus

    private val _mstQualificationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val mstQualificationValue: StateFlow<List<MSTComboBox_NEntity>> = _mstQualificationValue

    private val _religionValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val religionValue: StateFlow<List<MSTComboBox_NEntity>> = _religionValue

    private val _casteValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val casteValue: StateFlow<List<MSTComboBox_NEntity>> = _casteValue

    private val _bussinessValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val bussinessValue: StateFlow<List<MSTComboBox_NEntity>> = _bussinessValue

    private val _relationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val relationValue: StateFlow<List<MSTComboBox_NEntity>> = _relationValue

    private val _locationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val locationValue: StateFlow<List<MSTComboBox_NEntity>> = _locationValue

    private val _genderValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val genderValue: StateFlow<List<MSTComboBox_NEntity>> = _genderValue

    private val _occupationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val occupationValue: StateFlow<List<MSTComboBox_NEntity>> = _occupationValue

    private val _salaryRangeValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val salaryRangeValue: StateFlow<List<MSTComboBox_NEntity>> = _salaryRangeValue

    private val _rangeValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val rangeValue: StateFlow<List<MSTComboBox_NEntity>> = _rangeValue

    private val _organizationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val organizationValue: StateFlow<List<MSTComboBox_NEntity>> = _organizationValue

    private val _daysValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val daysValue: StateFlow<List<MSTComboBox_NEntity>> = _daysValue

    private val _serviceValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val serviceValue: StateFlow<List<MSTComboBox_NEntity>> = _serviceValue

    private val _mortalityValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val mortalityValue: StateFlow<List<MSTComboBox_NEntity>> = _mortalityValue

    private val _monthValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val monthValue: StateFlow<List<MSTComboBox_NEntity>> = _monthValue

    private val _yearValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val yearValue: StateFlow<List<MSTComboBox_NEntity>> = _yearValue

    private val _paymentValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val paymentValue: StateFlow<List<MSTComboBox_NEntity>> = _paymentValue

    private val _pamentValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val pamentValue: StateFlow<List<MSTComboBox_NEntity>> = _pamentValue

    private val _approveStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val approveStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _approveStatusValue

    private val _nachStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val nachStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _nachStatusValue

    private val _cashStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val cashStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _cashStatusValue

    private val _gtrStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val gtrStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _gtrStatusValue

    private val _fornightlyValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val fornightlyValue: StateFlow<List<MSTComboBox_NEntity>> = _fornightlyValue

    private val _registrationValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val registrationValue: StateFlow<List<MSTComboBox_NEntity>> = _registrationValue

    private val _yesValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val yesValue: StateFlow<List<MSTComboBox_NEntity>> = _yesValue

    private val _processStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val processStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _processStatusValue

    private val _loanStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val loanStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _loanStatusValue

    private val _loanActiveStatusValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val loanActiveStatusValue: StateFlow<List<MSTComboBox_NEntity>> = _loanActiveStatusValue


    private val _vehicleasset = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val vehicleasset: StateFlow<List<MSTComboBox_NEntity>> = _vehicleasset

    private val _bankName = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val bankName: StateFlow<List<MSTComboBox_NEntity>> = _bankName

    private val _bankNameLocation = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val bankNameLocation: StateFlow<List<MSTComboBox_NEntity>> = _bankNameLocation

    private val _assetVehicle = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val assetVehicle: StateFlow<List<MSTComboBox_NEntity>> = _assetVehicle

    private val _purposeValue = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val purposeValue: StateFlow<List<MSTComboBox_NEntity>> = _purposeValue

    private val _loanRecommendation = MutableStateFlow<List<MSTComboBox_NEntity>>(emptyList())
    val loanRecommendation: StateFlow<List<MSTComboBox_NEntity>> = _loanRecommendation


    fun loadLookUpValues(lookupTypeFk: Int) {
        viewModelScope.launch {
            val result = repository.getAllComboBox(lookupTypeFk)
            when (lookupTypeFk) {
                1 -> _relationStatus.value = result
                2 -> _religionValue.value = result
                3 -> _casteValue.value = result
                4 -> _mstQualificationValue.value = result
                6 -> _relationValue.value = result
                5 -> _occupationValue.value = result
                7 -> _purposeValue.value = result
                8 -> _salaryRangeValue.value = result
                10 -> _rangeValue.value = result
                11 -> _organizationValue.value = result
                12 -> _daysValue.value = result
                13 -> _serviceValue.value = result
                14 -> _mortalityValue.value = result
                15 -> _monthValue.value = result
                16 -> _yearValue.value = result
                17 -> _paymentValue.value = result
                18 -> _approveStatusValue.value = result
                19 -> _nachStatusValue.value = result
                20 -> _cashStatusValue.value = result
                21 -> _gtrStatusValue.value = result
                22 -> _fornightlyValue.value = result
                25 -> _registrationValue.value = result
                26 -> _yesValue.value = result
                27 -> _maritalStatus.value = result
                28 -> _processStatusValue.value = result
                29 -> _loanStatusValue.value = result
                30 -> _loanActiveStatusValue.value = result
                31 -> _genderValue.value = result
                32 -> _assetVehicle.value = result
                33 -> _loanRecommendation.value = result

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
