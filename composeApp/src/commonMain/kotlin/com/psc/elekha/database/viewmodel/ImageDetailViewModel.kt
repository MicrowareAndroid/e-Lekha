package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.repository.ImageDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageDetailViewModel(
    private val repository: ImageDetailRepository
) : ViewModel() {

    private val _allImages = MutableStateFlow<List<ImageDetailEntity>>(emptyList())
    val allImages: StateFlow<List<ImageDetailEntity>> = _allImages

    private val _imageDetails = MutableStateFlow<List<ImageDetailEntity>>(emptyList())
    val imageDetails: StateFlow<List<ImageDetailEntity>> = _imageDetails

    private val _renameImage = MutableStateFlow<String?>(null)
    val renameImage: StateFlow<String?> = _renameImage

    private val _countImage = MutableStateFlow<Int?>(null)
    val countImage: StateFlow<Int?> = _countImage

    // -------------------------------
    // Load all images
    // -------------------------------
    fun loadAllImages() {
        viewModelScope.launch(Dispatchers.IO) {
            _allImages.value = repository.getAllImageDetail() ?: emptyList()
        }
    }

    // -------------------------------
    // Load image details by RefFieldName
    // -------------------------------
    fun loadImageDetails(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _imageDetails.value = repository.getImageDetail(refFieldName) ?: emptyList()
        }
    }

    // -------------------------------
    // Load renamed image by RefFieldName
    // -------------------------------
    fun loadRenameImage(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _renameImage.value = repository.getRenameImage(refFieldName)
        }
    }

    // -------------------------------
    // Load image count by RefFieldName
    // -------------------------------
    fun loadCountImage(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _countImage.value = repository.getCountImageDetail(refFieldName)
        }
    }

    // -------------------------------
    // Delete all images
    // -------------------------------
    fun deleteAllImages() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllImageDetail()
            // Refresh list after deletion
            _allImages.value = emptyList()
        }
    }
}
