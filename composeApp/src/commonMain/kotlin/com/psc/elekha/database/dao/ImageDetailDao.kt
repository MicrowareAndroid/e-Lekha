package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.ImageDetailEntity

@Dao
interface ImageDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageDetail(imageDetailEntity: ImageDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImageDetail(imageDetailEntity: List<ImageDetailEntity>?)

    @Query("Select * from ImageDetail")
    fun getAllImageDetail(): List<ImageDetailEntity>?

    @Query("Select * from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    fun getImageDetail(RefFieldName: Int): List<ImageDetailEntity>?

    @Query("Select RenameImage from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    fun getRenameImage(RefFieldName: Int): String?

    @Query("Select Count(*) from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    fun getCountImageDetail(RefFieldName: Int): Int?

    @Query("Delete from ImageDetail")
    fun deleteAllImageDetail()

}