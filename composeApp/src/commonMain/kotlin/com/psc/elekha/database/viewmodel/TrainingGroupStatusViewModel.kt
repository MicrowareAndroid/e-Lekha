package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity
import com.psc.elekha.database.entity.TrainingGroupStatusEntity
import com.psc.elekha.database.repository.CustomerStatusRepository
import com.psc.elekha.database.repository.TrainingGroupRepository
import com.psc.elekha.database.repository.TrainingGroupStatusRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrainingGroupStatusViewModel(
    private val repository: TrainingGroupStatusRepository
) : ViewModel() {

    fun insertTrainingGroupStatus(
        status: TrainingGroupStatusEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTrainingGroupStatus(status)
            onComplete?.invoke()
        }
    }


    fun insertAllTrainingGroupStatus(
        list: List<TrainingGroupStatusEntity>,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAllTrainingGroupStatus(list)
            onComplete?.invoke()
        }
    }


    fun deleteAllTrainingGroupStatus(onComplete: (() -> Unit)? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTrainingGroupStatus()
            onComplete?.invoke()
        }
    }
}
