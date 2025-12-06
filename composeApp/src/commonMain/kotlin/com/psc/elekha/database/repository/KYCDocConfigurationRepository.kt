package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocConfigurationDao
import com.psc.elekha.database.entity.KYCDocConfigurationEntity

class KYCDocConfigurationRepository(
    private val dao: KYCDocConfigurationDao
) {

    fun insertKYCDocConfiguration(config: KYCDocConfigurationEntity) {
        dao.insertKYCDocConfiguration(config)
    }

    fun insertAllKYCDocConfiguration(configs: List<KYCDocConfigurationEntity>) {
        dao.insertAllKYCDocConfiguration(configs)
    }

    fun getAllKYCDocConfiguration(): List<KYCDocConfigurationEntity>? {
        return dao.getAllKYCDocConfiguration()
    }

    fun deleteAllKYCDocConfiguration() {
        dao.deleteAllKYCDocConfiguration()
    }
}
