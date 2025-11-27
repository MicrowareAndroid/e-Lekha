package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTAssetsValuationEntity

@Dao
interface MSTAssetsValuationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAssetsValuation(mSTAssetsValuationEntity: MSTAssetsValuationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAssetsValuation(mSTAssetsValuationEntity: List<MSTAssetsValuationEntity>?)

    @Query("Select * from MSTAssetsValuation")
    fun getAllAssetsValuation(): List<MSTAssetsValuationEntity>?

    @Query("Delete from MSTAssetsValuation")
    fun deleteAllAssetsValuation()

}