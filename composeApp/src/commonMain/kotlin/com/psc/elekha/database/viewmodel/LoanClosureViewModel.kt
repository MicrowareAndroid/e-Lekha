package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.LoanClosureEntity
import com.psc.elekha.database.repository.LoanClosureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoanClosureViewModel(
    private val repository: LoanClosureRepository
) : ViewModel() {

    private val _allLoanClosures = MutableStateFlow<List<LoanClosureEntity>>(emptyList())
    val allLoanClosures: StateFlow<List<LoanClosureEntity>> = _allLoanClosures

    private val _loanClosureUploadData = MutableStateFlow<List<LoanClosureEntity>>(emptyList())
    val loanClosureUploadData: StateFlow<List<LoanClosureEntity>> = _loanClosureUploadData

    private val _loanClosureUploadCount = MutableStateFlow(0)
    val loanClosureUploadCount: StateFlow<Int> = _loanClosureUploadCount

    // -------------------------------
    // Load all loan closures
    // -------------------------------
    fun loadAllLoanClosure() {
        viewModelScope.launch(Dispatchers.IO) {
            _allLoanClosures.value = repository.getAllLoanClosure() ?: emptyList()
        }
    }

    // -------------------------------
    // Load loan closures to upload
    // -------------------------------
    fun loadLoanClosureUploadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loanClosureUploadData.value = repository.getLoanClosureUploadData() ?: emptyList()
            _loanClosureUploadCount.value = repository.getLoanClosureUploadDataCount()
        }
    }

    // -------------------------------
    // Insert single loan closure
    // -------------------------------
    fun insertLoanClosure(loanClosure: LoanClosureEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertLoanClosure(loanClosure)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple loan closures
    // -------------------------------
    fun insertAllLoanClosure(loanClosures: List<LoanClosureEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllLoanClosure(loanClosures)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Update loan closure data
    // -------------------------------
    fun updateLoanClosureData(
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        GUID: String,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanClosureData(PaidDate, LoanLat, LoanLong, LoanPlace, GUID)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Mark uploaded
    // -------------------------------
    fun updateLoanClosureDataUploaded() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLoanClosureDataUploaded()
        }
    }

    // -------------------------------
    // Delete all loan closures
    // -------------------------------
    fun deleteAllLoanClosure() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllLoanClosure()
            _allLoanClosures.value = emptyList()
            _loanClosureUploadData.value = emptyList()
            _loanClosureUploadCount.value = 0
        }
    }
}
