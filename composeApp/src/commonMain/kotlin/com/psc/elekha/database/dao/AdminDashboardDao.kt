package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.AdminDashbordEntity

@Dao
interface AdminDashboardDao {
    // Insert single record
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(adminDashbord: AdminDashbordEntity)

    // Insert list (API / Sync use-case)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AdminDashbordEntity>)

    // Get dashboard data
    @Query("SELECT * FROM AdminDashboard")
    suspend fun getAll(): List<AdminDashbordEntity>

    // Delete all (logout / resync)
    @Query("DELETE FROM AdminDashboard")
    suspend fun deleteAll()
}