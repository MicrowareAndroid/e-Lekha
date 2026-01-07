package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.AdminDashbordEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity

@Dao
interface CustomerMovableAssetsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CustomerMovableAssetsEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<CustomerMovableAssetsEntity>)


    @Query("SELECT * FROM CustomerMovableAssets")
    suspend fun getAll(): List<CustomerMovableAssetsEntity>


    @Query("DELETE FROM CustomerMovableAssets")
    suspend fun deleteAll()

    @Query(" SELECT * FROM CustomerMovableAssets WHERE GUID =:guId")
    suspend fun getAssetsByGuid(guId: String): List<CustomerMovableAssetsEntity>


    @Query("SELECT * FROM CustomerMovableAssets WHERE MAGUID =:guId")
    suspend fun getAssestsDetailByGuid(guId: String): List<CustomerMovableAssetsEntity>

    @Delete
    suspend fun deleteMovableAssets(
        item: CustomerMovableAssetsEntity
    )
}