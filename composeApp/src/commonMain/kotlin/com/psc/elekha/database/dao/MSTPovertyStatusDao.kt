package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTPovertyStatusEntity

@Dao
interface MSTPovertyStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPovertyStatus(mSTPovertyStatusEntity: MSTPovertyStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPovertyStatus(mSTPovertyStatusEntity: List<MSTPovertyStatusEntity>?)

    @Query("Select * from MSTPovertyStatus")
    suspend fun getAllPovertyStatus(): List<MSTPovertyStatusEntity>?

    @Query("Delete from MSTPovertyStatus")
    suspend fun deleteAllPovertyStatus()

}