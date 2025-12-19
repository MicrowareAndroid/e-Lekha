package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity

@Dao
interface TrainingGroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingGroup(trainingGroupEntity: TrainingGroupEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTrainingGroup(trainingGroupEntity: List<TrainingGroupEntity>)

    @Query("Select * from TrainingGroup")
    suspend  fun getAllTrainingGroup(): List<TrainingGroupEntity>

    @Query("Delete from TrainingGroup")
    suspend  fun deleteAllTrainingGroup()

}