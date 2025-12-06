package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.KYCDocumentDao
import com.psc.elekha.database.entity.KYCDocumentEntity

class KYCDocumentRepository(
    private val dao: KYCDocumentDao
) {

    fun insertKYCDocument(document: KYCDocumentEntity) {
        dao.insertKYCDocument(document)
    }

    fun insertAllKYCDocument(documents: List<KYCDocumentEntity>) {
        dao.insertAllKYCDocument(documents)
    }

    fun getAllKYCDocument(): List<KYCDocumentEntity>? {
        return dao.getAllKYCDocument()
    }

    fun deleteAllKYCDocument() {
        dao.deleteAllKYCDocument()
    }
}
