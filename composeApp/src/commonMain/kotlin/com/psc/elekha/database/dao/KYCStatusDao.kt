package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCStatusEntity

@Dao
interface KYCStatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKYCStatus(kYCStatusEntity: KYCStatusEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllKYCStatus(kYCStatusEntity: List<KYCStatusEntity>?)

    @Query("Select * from KYCStatus")
    fun getAllKYCStatus(): List<KYCStatusEntity>?

    @Query("Delete from KYCStatus")
    fun deleteAllKYCStatus()

}