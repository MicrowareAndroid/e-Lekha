package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTDistrictDao
import com.psc.elekha.database.entity.MSTDistrictEntity

class MSTDistrictRepository(
    private val districtDao: MSTDistrictDao
) {

    // Insert single district
    suspend fun insertDistrict(item: MSTDistrictEntity) {
        districtDao.insertDistrict(item)
    }

    // Insert list of districts
    suspend fun insertAllDistrict(list: List<MSTDistrictEntity>?) {
        districtDao.insertAllDistrict(list)
    }

    // Get all districts
    suspend fun getAllDistrict(): List<MSTDistrictEntity>? {
        return districtDao.getAllDistrict()
    }

    // Delete all districts
    suspend fun deleteAllDistrict() {
        districtDao.deleteAllDistrict()
    }
}
