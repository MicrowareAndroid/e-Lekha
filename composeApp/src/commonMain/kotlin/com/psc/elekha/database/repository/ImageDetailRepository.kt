package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.ImageDetailDao
import com.psc.elekha.database.entity.ImageDetailEntity

class ImageDetailRepository(
    private val dao: ImageDetailDao
) {

    // Insert single image detail
    fun insertImageDetail(image: ImageDetailEntity) {
        dao.insertImageDetail(image)
    }

    // Insert multiple image details
    fun insertAllImageDetail(images: List<ImageDetailEntity>) {
        dao.insertAllImageDetail(images)
    }

    // Get all image details
    fun getAllImageDetail(): List<ImageDetailEntity>? {
        return dao.getAllImageDetail()
    }

    // Get image details by RefFieldName
    fun getImageDetail(refFieldName: Int): List<ImageDetailEntity>? {
        return dao.getImageDetail(refFieldName)
    }

    // Get renamed image by RefFieldName
    fun getRenameImage(refFieldName: Int): String? {
        return dao.getRenameImage(refFieldName)
    }

    // Get count of image details by RefFieldName
    fun getCountImageDetail(refFieldName: Int): Int? {
        return dao.getCountImageDetail(refFieldName)
    }

    // Delete all image details
    fun deleteAllImageDetail() {
        dao.deleteAllImageDetail()
    }
}
