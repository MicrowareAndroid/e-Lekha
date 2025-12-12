package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCStatusEntity

@Dao
interface KYCStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKYCStatus(kYCStatusEntity: KYCStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKYCStatus(kYCStatusEntity: List<KYCStatusEntity>)

    @Query("Select * from KYCStatus")
    suspend fun getAllKYCStatus(): List<KYCStatusEntity>

    @Query("Delete from KYCStatus")
    suspend fun deleteAllKYCStatus()

}