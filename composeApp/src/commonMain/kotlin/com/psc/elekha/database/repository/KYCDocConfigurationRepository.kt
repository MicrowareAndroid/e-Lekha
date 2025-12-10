package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocConfigurationDao
import com.psc.elekha.database.entity.KYCDocConfigurationEntity

class KYCDocConfigurationRepository(
    private val dao: KYCDocConfigurationDao
) {

    suspend fun insertKYCDocConfiguration(config: KYCDocConfigurationEntity) {
        dao.insertKYCDocConfiguration(config)
    }

    suspend fun insertAllKYCDocConfiguration(configs: List<KYCDocConfigurationEntity>) {
        dao.insertAllKYCDocConfiguration(configs)
    }

    suspend fun getAllKYCDocConfiguration(): List<KYCDocConfigurationEntity>? {
        return dao.getAllKYCDocConfiguration()
    }

    suspend fun deleteAllKYCDocConfiguration() {
        dao.deleteAllKYCDocConfiguration()
    }
}
