package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.ImageTrackingRecordEntity
import com.psc.elekha.database.repository.ImageTrackingRecordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageTrackingRecordViewModel(
    private val repository: ImageTrackingRecordRepository
) : ViewModel() {

    private val _allRecords = MutableStateFlow<List<ImageTrackingRecordEntity>>(emptyList())
    val allRecords: StateFlow<List<ImageTrackingRecordEntity>> = _allRecords

    private val _allData = MutableStateFlow<List<ImageTrackingRecordEntity>>(emptyList())
    val allData: StateFlow<List<ImageTrackingRecordEntity>> = _allData

    private val _countRecord = MutableStateFlow<Int?>(null)
    val countRecord: StateFlow<Int?> = _countRecord

    private val _allUploadCount = MutableStateFlow<Int?>(null)
    val allUploadCount: StateFlow<Int?> = _allUploadCount

    // -------------------------------
    // Load all edited & not uploaded records
    // -------------------------------
    fun loadAllRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            _allRecords.value = repository.getAllImageTrackingRecord()
        }
    }

    // -------------------------------
    // Load all records
    // -------------------------------
    fun loadAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            _allData.value = repository.getImageAllData()
        }
    }

    // -------------------------------
    // Load count by RefFieldName and GUID
    // -------------------------------
    fun loadCountRecord(refFieldName: String, guid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _countRecord.value = repository.getCountImageTrackingRecord(refFieldName, guid)
        }
    }

    // -------------------------------
    // Load all edited record count
    // -------------------------------
    fun loadAllUploadCount() {
        viewModelScope.launch(Dispatchers.IO) {
            _allUploadCount.value = repository.getAllImageTrackingRecordDataCount()
        }
    }

    // -------------------------------
    // Insert single record
    // -------------------------------
    fun insertRecord(record: ImageTrackingRecordEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertImageTrackingRecord(record)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple records
    // -------------------------------
    fun insertAllRecords(records: List<ImageTrackingRecordEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllImageTrackingRecord(records)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Update image tracking record
    // -------------------------------
    fun updateRecord(
        imageName: String,
        isEdited: Int,
        isUpload: Int,
        refFieldName: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateImageTrackingRecord(imageName, isEdited, isUpload, refFieldName)
        }
    }

    // -------------------------------
    // Mark image as uploaded
    // -------------------------------
    fun updateImageUpload(guid: String, refFieldName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateImageUpload(guid, refFieldName)
        }
    }

    // -------------------------------
    // Delete all records
    // -------------------------------
    fun deleteAllRecords() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllImageTrackingRecord()
            _allRecords.value = emptyList()
            _allData.value = emptyList()
        }
    }
}
