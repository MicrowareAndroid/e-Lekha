package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTStateEntity

@Dao
interface MSTStateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertState(mSTStateEntity: MSTStateEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllState(mSTStateEntity: List<MSTStateEntity>?)

    @Query("Select * from MSTState")
    suspend fun getAllState(): List<MSTStateEntity>?

    @Query("Delete from MSTState")
    suspend fun deleteAllState()

}