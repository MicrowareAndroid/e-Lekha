package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.ImageDetailDao
import com.psc.elekha.database.entity.ImageDetailEntity

class ImageDetailRepository(
    private val dao: ImageDetailDao
) {

    // Insert single image detail
    suspend fun insertImageDetail(image: ImageDetailEntity) {
        dao.insertImageDetail(image)
    }

    // Insert multiple image details
    suspend fun insertAllImageDetail(images: List<ImageDetailEntity>) {
        dao.insertAllImageDetail(images)
    }

    // Get all image details
    suspend fun getAllImageDetail(): List<ImageDetailEntity> {
        return dao.getAllImageDetail()
    }

    // Get image details by RefFieldName
    suspend fun getImageDetail(refFieldName: Int): List<ImageDetailEntity> {
        return dao.getImageDetail(refFieldName)
    }

    // Get renamed image by RefFieldName
    suspend fun getRenameImage(refFieldName: Int): String? {
        return dao.getRenameImage(refFieldName)
    }

    // Get count of image details by RefFieldName
    suspend fun getCountImageDetail(refFieldName: Int): Int? {
        return dao.getCountImageDetail(refFieldName)
    }

    // Delete all image details
    suspend fun deleteAllImageDetail() {
        dao.deleteAllImageDetail()
    }
}
