package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTDistrictEntity
import com.psc.elekha.database.entity.MSTVillageEntity

@Dao
interface MSTVillageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVillage(mSTVillageEntity: MSTVillageEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVillage(mSTVillageEntity: List<MSTVillageEntity>)

    @Query("Select * from MSTVillage")
    suspend fun getAllVillage(): List<MSTVillageEntity>

    @Query("Select * from MSTVillage where BranchID=:BranchID and IsDeleted = 0")
    suspend fun getAllVillageByBranchID(BranchID: Int): List<MSTVillageEntity>

    @Query("Select * from MSTVillage where PinCode=:PinCode and IsDeleted = 0 Union select 482 as VillageID,0 as BranchID,'New Village' as Village,'999999' as Pincode,0 as IsDeleted,NULL as VillageCode,NULL as DistrictCode from MSTVillage where IsDeleted = 0 order by Village")
    suspend fun getAllVillageByPincode(PinCode: String): List<MSTVillageEntity>

    @Query("Select * from MSTVillage where PinCode=:PinCode and IsDeleted = 0")
    suspend fun getAllVillageByCode(PinCode: String): List<MSTVillageEntity>

    @Query("Select PinCode from MSTVillage where VillageID=:VillageID and IsDeleted = 0")
    suspend  fun getPincode(VillageID: Int): String?

    @Query("Select Count(*) from MSTVillage where PinCode=:PinCode and IsDeleted = 0")
    suspend fun getCountVillageByCode(PinCode: String): Int

    @Query("Delete from MSTVillage")
    suspend fun deleteAllVillage()

    @Query("SELECT * FROM MSTVillage")
    suspend fun  getAllVillageBybranchId():List<MSTVillageEntity>

}