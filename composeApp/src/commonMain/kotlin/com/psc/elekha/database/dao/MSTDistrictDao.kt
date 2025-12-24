package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTDistrictEntity

@Dao
interface MSTDistrictDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertDistrict(mSTDistrictEntity: MSTDistrictEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllDistrict(mSTDistrictEntity: List<MSTDistrictEntity>)

    @Query("Select * from MSTDistrict")
    suspend  fun getAllDistrict(): List<MSTDistrictEntity>

    @Query("Delete from MSTDistrict")
    suspend  fun deleteAllDistrict()

    @Query("SELECT * FROM mstDistrict")
    suspend fun  getAllDistictByStateid():List<MSTDistrictEntity>

}