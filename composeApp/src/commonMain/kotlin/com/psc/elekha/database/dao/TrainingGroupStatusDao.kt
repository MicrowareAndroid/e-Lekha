package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.TrainingGroupStatusEntity
@Dao
interface TrainingGroupStatusDao {
    // Insert single record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trainingGroupStatus: TrainingGroupStatusEntity)

    // Insert list (API / Sync use-case)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TrainingGroupStatusEntity>)

    // Get all records
    @Query("SELECT * FROM TrainingGroupStatus")
    suspend fun getAll(): List<TrainingGroupStatusEntity>

    // Get only active (IsDeleted = 0)
    @Query("SELECT * FROM TrainingGroupStatus WHERE IsDeleted = 0")
    suspend fun getActive(): List<TrainingGroupStatusEntity>

    // Get by ID
    @Query("SELECT * FROM TrainingGroupStatus WHERE TGroupStatusID = :id LIMIT 1")
    suspend fun getById(id: Int): TrainingGroupStatusEntity?

    // Delete all (useful during logout / resync)
    @Query("DELETE FROM TrainingGroupStatus")
    suspend fun deleteAll()
}