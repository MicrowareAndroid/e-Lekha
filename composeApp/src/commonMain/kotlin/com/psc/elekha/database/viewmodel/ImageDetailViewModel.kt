package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.ImageDetailEntity
import com.psc.elekha.database.repository.ImageDetailRepository
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageDetailViewModel(
    private val repository: ImageDetailRepository,
    val appPreferences: AppPreferences
) : ViewModel() {

    private val _allImages = MutableStateFlow<List<ImageDetailEntity>>(emptyList())
    val allImages: StateFlow<List<ImageDetailEntity>> = _allImages

    private val _imageDetails = MutableStateFlow<List<ImageDetailEntity>>(emptyList())
    val imageDetails: StateFlow<List<ImageDetailEntity>> = _imageDetails

    private val _renameImage = MutableStateFlow<String?>(null)
    val renameImage: StateFlow<String?> = _renameImage

    private val _countImage = MutableStateFlow<Int?>(null)
    val countImage: StateFlow<Int?> = _countImage

    // --------------------------------------------------------
    // INSERT SINGLE IMAGE DETAIL
    // --------------------------------------------------------
    fun insertImageDetail(
        image: ImageDetailEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertImageDetail(image)
            onComplete?.invoke()
        }
    }

    // --------------------------------------------------------
    // INSERT ALL IMAGE DETAILS
    // --------------------------------------------------------
    fun insertAllImageDetail(
        images: List<ImageDetailEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllImageDetail(images)
            onComplete?.invoke()
        }
    }

    // --------------------------------------------------------
    // LOAD ALL IMAGES
    // --------------------------------------------------------
    fun loadAllImages() {
        viewModelScope.launch(Dispatchers.IO) {
            _allImages.value = repository.getAllImageDetail()
        }
    }

    // --------------------------------------------------------
    // LOAD IMAGES BY REF FIELD NAME
    // --------------------------------------------------------
    fun loadImageDetails(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _imageDetails.value = repository.getImageDetail(refFieldName)
        }
    }

    suspend fun loadImageDetailsOnce(refFieldName: Int): List<ImageDetailEntity>? {
        return repository.getImageDetail(refFieldName)
    }

    // --------------------------------------------------------
    // LOAD RENAMED IMAGE
    // --------------------------------------------------------
    fun loadRenameImage(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _renameImage.value = repository.getRenameImage(refFieldName)
        }
    }

    suspend fun getRenameImageOnce(refFieldName: Int): String? {
        return repository.getRenameImage(refFieldName)
    }


    fun loadCountImage(refFieldName: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _countImage.value = repository.getCountImageDetail(refFieldName)
        }
    }


    fun deleteAllImages() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllImageDetail()
            _allImages.value = emptyList()
        }
    }

    fun saveImageFieldNameSharePreference(imageName: String) {
        appPreferences.putString(AppSP.sImageFieldName, imageName)
    }
}
