package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity
import com.psc.elekha.database.repository.CustomerStatusRepository
import com.psc.elekha.database.repository.TrainingGroupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrainingGroupViewModel(
    private val repository: TrainingGroupRepository
) : ViewModel() {

    fun insertTrainingGroup(
        status: TrainingGroupEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTrainingGroup(status)
            onComplete?.invoke()
        }
    }


    fun insertAllTrainingGroup(
        list: List<TrainingGroupEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllTrainingGroup(list)
            onComplete?.invoke()
        }
    }


    fun deleteAllTrainingGroup(onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTrainingGroup()
            onComplete?.invoke()
        }
    }
}
