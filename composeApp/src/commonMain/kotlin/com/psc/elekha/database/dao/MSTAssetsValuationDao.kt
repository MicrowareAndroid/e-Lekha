package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTAssetsValuationEntity

@Dao
interface MSTAssetsValuationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insertAssetsValuation(mSTAssetsValuationEntity: MSTAssetsValuationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllAssetsValuation(mSTAssetsValuationEntity: List<MSTAssetsValuationEntity>)

    @Query("Select * from MSTAssetsValuation")
    suspend  fun getAllAssetsValuation(): List<MSTAssetsValuationEntity>

    @Query("Delete from MSTAssetsValuation")
    suspend fun deleteAllAssetsValuation()

}