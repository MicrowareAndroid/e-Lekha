package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocCategoryDao
import com.psc.elekha.database.entity.KYCDocCategoryEntity

class KYCDocCategoryRepository(
    private val dao: KYCDocCategoryDao
) {

    suspend fun insertKYCDocCategory(category: KYCDocCategoryEntity) {
        dao.insertKYCDocCategory(category)
    }

    suspend fun insertAllKYCDocCategory(categories: List<KYCDocCategoryEntity>) {
        dao.insertAllKYCDocCategory(categories)
    }

    suspend fun getAllKYCDocCategory(): List<KYCDocCategoryEntity>? {
        return dao.getAllKYCDocCategory()
    }

    suspend fun deleteAllKYCDocCategory() {
        dao.deleteAllKYCDocCategory()
    }
}
