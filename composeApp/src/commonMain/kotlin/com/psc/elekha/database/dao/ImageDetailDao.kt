package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.ImageDetailEntity

@Dao
interface ImageDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageDetail(imageDetailEntity: ImageDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageDetail(imageDetailEntity: List<ImageDetailEntity>)

    @Query("Select * from ImageDetail")
    suspend fun getAllImageDetail(): List<ImageDetailEntity>

    @Query("Select * from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    suspend fun getImageDetail(RefFieldName: Int): List<ImageDetailEntity>

    @Query("Select RenameImage from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    suspend  fun getRenameImage(RefFieldName: Int): String?

    @Query("Select Count(*) from ImageDetail where RefFieldName=:RefFieldName and IsDeleted=0")
    suspend fun getCountImageDetail(RefFieldName: Int): Int?

    @Query("Delete from ImageDetail")
    suspend fun deleteAllImageDetail()

}