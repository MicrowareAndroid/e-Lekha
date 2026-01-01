package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.TrainingGroupMemberDao
import com.psc.elekha.database.entity.TrainingGroupMemberEntity

class TrainingGroupMemberRepository(
    private val dao: TrainingGroupMemberDao
) {

    suspend fun insertTrainingGroupStatus(status: TrainingGroupMemberEntity) {
        dao.insert(status)
    }

    suspend fun insertAllTrainingGroupStatus(list: List<TrainingGroupMemberEntity>) {
        dao.insertAll(list)
    }

    suspend fun deleteAllTrainingGroupStatus() {
        dao.deleteAll()
    }
}
