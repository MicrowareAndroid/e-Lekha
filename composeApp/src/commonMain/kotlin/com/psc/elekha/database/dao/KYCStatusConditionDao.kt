package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCStatusConditionEntity

@Dao
interface KYCStatusConditionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKYCStatusCondition(kYCStatusConditionEntity: KYCStatusConditionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllKYCStatusCondition(kYCStatusConditionEntity: List<KYCStatusConditionEntity>?)

    @Query("Select * from KYCStatusCondition")
    fun getAllKYCStatusCondition(): List<KYCStatusConditionEntity>?

    @Query("Delete from KYCStatusCondition")
    fun deleteAllKYCStatusCondition()

}