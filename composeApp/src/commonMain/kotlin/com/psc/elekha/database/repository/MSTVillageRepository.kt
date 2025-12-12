package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTVillageDao
import com.psc.elekha.database.entity.MSTVillageEntity

class MSTVillageRepository(
    private val villageDao: MSTVillageDao
) {

    // Insert single village
    suspend fun insertVillage(item: MSTVillageEntity) {
        villageDao.insertVillage(item)
    }

    // Insert list of villages
    suspend fun insertAllVillage(list: List<MSTVillageEntity>) {
        villageDao.insertAllVillage(list)
    }

    // Get all villages
    suspend fun getAllVillage(): List<MSTVillageEntity> {
        return villageDao.getAllVillage()
    }

    // Get all villages by BranchID
    suspend fun getAllVillageByBranchID(branchID: Int): List<MSTVillageEntity> {
        return villageDao.getAllVillageByBranchID(branchID)
    }

    // Get all villages by PinCode (with union query)
    suspend fun getAllVillageByPincode(pinCode: String): List<MSTVillageEntity> {
        return villageDao.getAllVillageByPincode(pinCode)
    }

    // Get all villages by PinCode (exact match)
    suspend fun getAllVillageByCode(pinCode: String): List<MSTVillageEntity> {
        return villageDao.getAllVillageByCode(pinCode)
    }

    // Get Pincode by VillageID
    suspend fun getPincode(villageID: Int): String? {
        return villageDao.getPincode(villageID)
    }

    // Get count of villages by PinCode
    suspend fun getCountVillageByCode(pinCode: String): Int {
        return villageDao.getCountVillageByCode(pinCode)
    }

    // Delete all villages
    suspend fun deleteAllVillage() {
        villageDao.deleteAllVillage()
    }
}
