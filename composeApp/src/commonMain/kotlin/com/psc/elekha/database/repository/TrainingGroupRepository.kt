package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerStatusDao
import com.psc.elekha.database.dao.TrainingGroupDao
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity

class TrainingGroupRepository(
    private val dao: TrainingGroupDao
) {

    suspend fun insertTrainingGroup(status: TrainingGroupEntity) {
        dao.insertTrainingGroup(status)
    }

    suspend fun insertAllTrainingGroup(list: List<TrainingGroupEntity>) {
        dao.insertAllTrainingGroup(list)
    }

    suspend fun deleteAllTrainingGroup() {
        dao.deleteAllTrainingGroup()
    }
}
