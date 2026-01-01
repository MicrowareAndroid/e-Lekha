package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.TrainingGroupMemberEntity
@Dao
interface TrainingGroupMemberDao {
    // Insert single record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trainingGroupStatus: TrainingGroupMemberEntity)

    // Insert list (API / Sync use-case)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TrainingGroupMemberEntity>)

    // Get all records
    @Query("SELECT * FROM TrainingGroupMember")
    suspend fun getAll(): List<TrainingGroupMemberEntity>

    // Get only active (IsDeleted = 0)
    @Query("SELECT * FROM TrainingGroupMember WHERE IsDeleted = 0")
    suspend fun getActive(): List<TrainingGroupMemberEntity>

    // Get by ID
    @Query("SELECT * FROM TrainingGroupMember WHERE TGroupMemberID = :id LIMIT 1")
    suspend fun getById(id: Int): TrainingGroupMemberEntity?

    // Delete all (useful during logout / resync)
    @Query("DELETE FROM TrainingGroupMember")
    suspend fun deleteAll()
}