package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTPovertyStatusEntity

@Dao
interface MSTPovertyStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPovertyStatus(mSTPovertyStatusEntity: MSTPovertyStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPovertyStatus(mSTPovertyStatusEntity: List<MSTPovertyStatusEntity>?)

    @Query("Select * from MSTPovertyStatus")
    fun getAllPovertyStatus(): List<MSTPovertyStatusEntity>?

    @Query("Delete from MSTPovertyStatus")
    fun deleteAllPovertyStatus()

}