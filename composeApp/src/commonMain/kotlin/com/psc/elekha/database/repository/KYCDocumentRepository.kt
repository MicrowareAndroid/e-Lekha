package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocumentDao
import com.psc.elekha.database.entity.KYCDocumentEntity

class KYCDocumentRepository(
    private val dao: KYCDocumentDao
) {

    suspend fun insertKYCDocument(document: KYCDocumentEntity) {
        dao.insertKYCDocument(document)
    }

    suspend fun insertAllKYCDocument(documents: List<KYCDocumentEntity>) {
        dao.insertAllKYCDocument(documents)
    }

    suspend fun getAllKYCDocument(): List<KYCDocumentEntity> {
        return dao.getAllKYCDocument()
    }

    suspend fun deleteAllKYCDocument() {
        dao.deleteAllKYCDocument()
    }
}
