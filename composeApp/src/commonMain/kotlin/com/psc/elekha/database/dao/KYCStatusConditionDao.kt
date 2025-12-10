package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCStatusConditionEntity

@Dao
interface KYCStatusConditionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKYCStatusCondition(kYCStatusConditionEntity: KYCStatusConditionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKYCStatusCondition(kYCStatusConditionEntity: List<KYCStatusConditionEntity>?)

    @Query("Select * from KYCStatusCondition")
    suspend fun getAllKYCStatusCondition(): List<KYCStatusConditionEntity>?

    @Query("Delete from KYCStatusCondition")
    suspend fun deleteAllKYCStatusCondition()

}