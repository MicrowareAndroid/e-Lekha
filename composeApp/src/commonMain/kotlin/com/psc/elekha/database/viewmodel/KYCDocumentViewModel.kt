package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.KYCDocumentEntity
import com.psc.elekha.database.repository.KYCDocumentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KYCDocumentViewModel(
    private val repository: KYCDocumentRepository
) : ViewModel() {

    private val _allDocuments = MutableStateFlow<List<KYCDocumentEntity>>(emptyList())
    val allDocuments: StateFlow<List<KYCDocumentEntity>> = _allDocuments

    // -------------------------------
    // Load all documents
    // -------------------------------
    fun loadAllDocuments() {
        viewModelScope.launch(Dispatchers.IO) {
            _allDocuments.value = repository.getAllKYCDocument() ?: emptyList()
        }
    }

    // -------------------------------
    // Insert single document
    // -------------------------------
    fun insertDocument(document: KYCDocumentEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertKYCDocument(document)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple documents
    // -------------------------------
    fun insertAllDocuments(documents: List<KYCDocumentEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllKYCDocument(documents)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Delete all documents
    // -------------------------------
    fun deleteAllDocuments() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKYCDocument()
            _allDocuments.value = emptyList()
        }
    }
}
