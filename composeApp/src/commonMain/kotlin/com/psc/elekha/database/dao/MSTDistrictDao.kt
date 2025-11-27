package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTDistrictEntity

@Dao
interface MSTDistrictDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDistrict(mSTDistrictEntity: MSTDistrictEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDistrict(mSTDistrictEntity: List<MSTDistrictEntity>?)

    @Query("Select * from MSTDistrict")
    fun getAllDistrict(): List<MSTDistrictEntity>?

    @Query("Delete from MSTDistrict")
    fun deleteAllDistrict()

}