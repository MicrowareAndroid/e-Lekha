package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocCategoryDao
import com.psc.elekha.database.entity.KYCDocCategoryEntity

class KYCDocCategoryRepository(
    private val dao: KYCDocCategoryDao
) {

    fun insertKYCDocCategory(category: KYCDocCategoryEntity) {
        dao.insertKYCDocCategory(category)
    }

    fun insertAllKYCDocCategory(categories: List<KYCDocCategoryEntity>) {
        dao.insertAllKYCDocCategory(categories)
    }

    fun getAllKYCDocCategory(): List<KYCDocCategoryEntity>? {
        return dao.getAllKYCDocCategory()
    }

    fun deleteAllKYCDocCategory() {
        dao.deleteAllKYCDocCategory()
    }
}
