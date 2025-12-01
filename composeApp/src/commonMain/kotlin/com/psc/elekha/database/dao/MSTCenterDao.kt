package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTCenterEntity

@Dao
interface MSTCenterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCenter(mSTCenterEntity: MSTCenterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCenter(mSTCenterEntity: List<MSTCenterEntity>?)

    @Query("Select * from MstCenter")
    fun getAllCenter(): List<MSTCenterEntity>?

    @Query("Delete from MstCenter")
    fun deleteAllCenter()

}