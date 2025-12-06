package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.KYCDocCategoryEntity
import com.psc.elekha.database.repository.KYCDocCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KYCDocCategoryViewModel(
    private val repository: KYCDocCategoryRepository
) : ViewModel() {

    private val _allCategories = MutableStateFlow<List<KYCDocCategoryEntity>>(emptyList())
    val allCategories: StateFlow<List<KYCDocCategoryEntity>> = _allCategories

    // -------------------------------
    // Load all categories
    // -------------------------------
    fun loadAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            _allCategories.value = repository.getAllKYCDocCategory() ?: emptyList()
        }
    }

    // -------------------------------
    // Insert single category
    // -------------------------------
    fun insertCategory(category: KYCDocCategoryEntity, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertKYCDocCategory(category)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Insert multiple categories
    // -------------------------------
    fun insertAllCategories(categories: List<KYCDocCategoryEntity>, onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllKYCDocCategory(categories)
            onComplete?.invoke()
        }
    }

    // -------------------------------
    // Delete all categories
    // -------------------------------
    fun deleteAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllKYCDocCategory()
            _allCategories.value = emptyList()
        }
    }
}
