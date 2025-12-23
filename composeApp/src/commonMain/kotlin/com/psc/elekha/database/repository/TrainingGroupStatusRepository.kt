package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerStatusDao
import com.psc.elekha.database.dao.TrainingGroupDao
import com.psc.elekha.database.dao.TrainingGroupStatusDao
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity
import com.psc.elekha.database.entity.TrainingGroupStatusEntity

class TrainingGroupStatusRepository(
    private val dao: TrainingGroupStatusDao
) {

    suspend fun insertTrainingGroupStatus(status: TrainingGroupStatusEntity) {
        dao.insert(status)
    }

    suspend fun insertAllTrainingGroupStatus(list: List<TrainingGroupStatusEntity>) {
        dao.insertAll(list)
    }

    suspend fun deleteAllTrainingGroupStatus() {
        dao.deleteAll()
    }
}
