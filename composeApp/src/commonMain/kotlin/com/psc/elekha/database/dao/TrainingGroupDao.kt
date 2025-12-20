package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.CustomerStatusEntity
import com.psc.elekha.database.entity.TrainingGroupEntity

@Dao
interface TrainingGroupDao {

    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTrainingGroup(trainingGroupEntity: List<TrainingGroupEntity>)
   
    @Query("Delete from TrainingGroup")
    suspend  fun deleteAllTrainingGroup()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingGroup(trainingGroup: TrainingGroupEntity)


}
    

