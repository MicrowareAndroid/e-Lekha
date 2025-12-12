package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.KYCDocCategoryEntity

@Dao
interface KYCDocCategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKYCDocCategory(kYCDocCategoryEntity: KYCDocCategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKYCDocCategory(kYCDocCategoryEntity: List<KYCDocCategoryEntity>)

    @Query("Select * from KYCDocCategory")
    suspend fun getAllKYCDocCategory(): List<KYCDocCategoryEntity>

    @Query("Delete from KYCDocCategory")
    suspend fun deleteAllKYCDocCategory()

}