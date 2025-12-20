package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.BranchManagerDashbordEntity
@Dao
interface BranchManagerDashbordDao {
    // Insert single dashboard record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(branchManagerDashbord: BranchManagerDashbordEntity)

    // Insert list (API sync case)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<BranchManagerDashbordEntity>)

    // Get all records
    @Query("SELECT * FROM BranchManagerDashboard")
    suspend fun getAll(): List<BranchManagerDashbordEntity>

    // Get single dashboard (if you expect only one row)
    @Query("SELECT * FROM BranchManagerDashboard LIMIT 1")
    suspend fun getDashboard(): BranchManagerDashbordEntity?

    // Delete all (logout / resync)
    @Query("DELETE FROM BranchManagerDashboard")
    suspend fun deleteAll()
}