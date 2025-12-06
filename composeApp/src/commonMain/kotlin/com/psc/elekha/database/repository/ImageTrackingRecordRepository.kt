package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.ImageTrackingRecordDao
import com.psc.elekha.database.entity.ImageTrackingRecordEntity

class ImageTrackingRecordRepository(
    private val dao: ImageTrackingRecordDao
) {

    fun insertImageTrackingRecord(record: ImageTrackingRecordEntity) {
        dao.insertImageTrackingRecord(record)
    }

    fun insertAllImageTrackingRecord(records: List<ImageTrackingRecordEntity>) {
        dao.insertAllImageTrackingRecord(records)
    }

    fun getAllImageTrackingRecord(): List<ImageTrackingRecordEntity>? {
        return dao.getAllImageTrackingRecord()
    }

    fun getImageAllData(): List<ImageTrackingRecordEntity>? {
        return dao.getImageAllData()
    }

    fun deleteAllImageTrackingRecord() {
        dao.deleteAllImageTrackingRecord()
    }

    fun getCountImageTrackingRecord(refFieldName: String, guid: String): Int? {
        return dao.getCountImageTrackingRecord(refFieldName, guid)
    }

    fun updateImageTrackingRecord(
        imageName: String,
        isEdited: Int,
        isUpload: Int,
        refFieldName: String
    ) {
        dao.updateImageTrackingRecord(imageName, isEdited, isUpload, refFieldName)
    }

    fun updateImageUpload(guid: String, refFieldName: String) {
        dao.updateImageUpload(guid, refFieldName)
    }

    fun getAllImageTrackingRecordDataCount(): Int {
        return dao.getAllImageTrackingRecordDataCount()
    }
}
