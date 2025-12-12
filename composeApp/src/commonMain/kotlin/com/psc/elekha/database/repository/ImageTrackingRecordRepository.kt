package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.ImageTrackingRecordDao
import com.psc.elekha.database.entity.ImageTrackingRecordEntity

class ImageTrackingRecordRepository(
    private val dao: ImageTrackingRecordDao
) {

    suspend fun insertImageTrackingRecord(record: ImageTrackingRecordEntity) {
        dao.insertImageTrackingRecord(record)
    }

    suspend fun insertAllImageTrackingRecord(records: List<ImageTrackingRecordEntity>) {
        dao.insertAllImageTrackingRecord(records)
    }

    suspend  fun getAllImageTrackingRecord(): List<ImageTrackingRecordEntity> {
        return dao.getAllImageTrackingRecord()
    }

    suspend fun getImageAllData(): List<ImageTrackingRecordEntity> {
        return dao.getImageAllData()
    }

    suspend fun deleteAllImageTrackingRecord() {
        dao.deleteAllImageTrackingRecord()
    }

    suspend fun getCountImageTrackingRecord(refFieldName: String, guid: String): Int? {
        return dao.getCountImageTrackingRecord(refFieldName, guid)
    }

    suspend  fun updateImageTrackingRecord(
        imageName: String,
        isEdited: Int,
        isUpload: Int,
        refFieldName: String
    ) {
        dao.updateImageTrackingRecord(imageName, isEdited, isUpload, refFieldName)
    }

    suspend fun updateImageUpload(guid: String, refFieldName: String) {
        dao.updateImageUpload(guid, refFieldName)
    }

    suspend fun getAllImageTrackingRecordDataCount(): Int {
        return dao.getAllImageTrackingRecordDataCount()
    }
}
