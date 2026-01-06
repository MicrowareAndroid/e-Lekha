package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.psc.elekha.database.entity.AdminDashbordEntity
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
}