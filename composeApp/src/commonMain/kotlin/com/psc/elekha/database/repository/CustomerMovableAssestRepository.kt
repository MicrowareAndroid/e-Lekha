package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.CustomerMovableAssetsDao
import com.psc.elekha.database.dao.MSTVillageDao
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity
import com.psc.elekha.database.entity.MSTDistrictEntity
import com.psc.elekha.database.entity.MSTVillageEntity

class CustomerMovableAssestRepository(
    private val dao: CustomerMovableAssetsDao
) {


    suspend fun insert(item: CustomerMovableAssetsEntity) {
        dao.insert(item)
    }


    suspend fun insertAll(list: List<CustomerMovableAssetsEntity>) {
        dao.insertAll(list)
    }

    suspend fun getAll(): List<CustomerMovableAssetsEntity> {
        return dao.getAll()
    }


    suspend fun deleteAll() {
        dao.deleteAll()
    }

}
