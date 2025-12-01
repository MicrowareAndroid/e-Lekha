package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCDocConfigurationEntity

@Dao
interface KYCDocConfigurationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKYCDocConfiguration(kYCDocConfigurationEntity: KYCDocConfigurationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllKYCDocConfiguration(kYCDocConfigurationEntity: List<KYCDocConfigurationEntity>?)

    @Query("Select * from KYCDocConfiguration")
    fun getAllKYCDocConfiguration(): List<KYCDocConfigurationEntity>?

    @Query("Delete from KYCDocConfiguration")
    fun deleteAllKYCDocConfiguration()

}