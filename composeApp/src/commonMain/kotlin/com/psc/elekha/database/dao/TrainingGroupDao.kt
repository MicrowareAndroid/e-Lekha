package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.TrainingGroup

@Dao
interface TrainingGroupDao {


    //  Insert single record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingGroup(trainingGroup: TrainingGroup)

    //  Insert multiple records
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingGroupList(list: List<TrainingGroup>)

    // Get all (Not Deleted)
    @Query("""
        SELECT * FROM TrainingGroup
        WHERE IsDeleted = 0 OR IsDeleted IS NULL
    """)
    suspend fun getAllTrainingGroups(): List<TrainingGroup>

    // Get by UID
    @Query("SELECT * FROM TrainingGroup WHERE UID = :uid")
    suspend fun getTrainingGroupByUID(uid: Int): TrainingGroup?

    //  Get by TGroupID
    @Query("""
        SELECT * FROM TrainingGroup
        WHERE TGroupID = :tGroupId
        AND (IsDeleted = 0 OR IsDeleted IS NULL)
    """)
    suspend fun getTrainingGroupByTGroupId(tGroupId: Int): List<TrainingGroup>

    //  Get by VillageID
    @Query("""
        SELECT * FROM TrainingGroup
        WHERE VillageID = :villageId
        AND (IsDeleted = 0 OR IsDeleted IS NULL)
    """)
    suspend fun getTrainingGroupsByVillage(villageId: Int): List<TrainingGroup>

    //  Update record
    @Update
    suspend fun updateTrainingGroup(trainingGroup: TrainingGroup)

    //  Soft delete (IsDeleted = 1)
    @Query("UPDATE TrainingGroup SET IsDeleted = 1 WHERE UID = :uid")
    suspend fun softDeleteTrainingGroup(uid: Int)

    //Hard delete (Optional)
    @Delete
    suspend fun deleteTrainingGroup(trainingGroup: TrainingGroup)

    // Clear table
    @Query("DELETE FROM TrainingGroup")
    suspend fun clearTrainingGroupTable()
}
