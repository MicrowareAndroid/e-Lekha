package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.TrainingGroupMemberEntity
import com.psc.elekha.database.repository.TrainingGroupMemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class TrainingGroupMemberViewModel(
    private val repository: TrainingGroupMemberRepository
) : ViewModel() {

    fun insertTrainingGroupStatus(
        status: TrainingGroupMemberEntity,
        onComplete: (() -> Unit)? = null
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTrainingGroupStatus(status)
            onComplete?.invoke()
        }
    }


    fun insertAllTrainingGroupStatus(
        list: List<TrainingGroupMemberEntity>,
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
