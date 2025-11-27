package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTStateEntity

@Dao
interface MSTStateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertState(mSTStateEntity: MSTStateEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllState(mSTStateEntity: List<MSTStateEntity>?)

    @Query("Select * from MSTState")
    fun getAllState(): List<MSTStateEntity>?

    @Query("Delete from MSTState")
    fun deleteAllState()

}