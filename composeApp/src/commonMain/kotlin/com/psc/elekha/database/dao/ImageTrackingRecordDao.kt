package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.ImageTrackingRecordEntity

@Dao
interface ImageTrackingRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageTrackingRecord(imageTrackingRecordEntity: ImageTrackingRecordEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImageTrackingRecord(imageTrackingRecordEntity: List<ImageTrackingRecordEntity>?)

    @Query("Select * from ImageTrackingRecord where IsDeleted = 0 and IsEdited = 1 and IsUpload = 0")
    fun getAllImageTrackingRecord(): List<ImageTrackingRecordEntity>?

    @Query("Select * from ImageTrackingRecord where IsDeleted = 0")
    fun getImageAllData(): List<ImageTrackingRecordEntity>?

    @Query("Delete from ImageTrackingRecord")
    fun deleteAllImageTrackingRecord()

    @Query("Select Count(*) from ImageTrackingRecord where RefFieldName=:RefFieldName and GUID=:GUID and IsDeleted=0")
    fun getCountImageTrackingRecord(RefFieldName: String, GUID: String): Int?

    @Query("Update ImageTrackingRecord set ImageName=:ImageName, IsEdited=:IsEdited, IsUpload=:IsUpload where RefFieldName=:RefFieldName")
    fun updateImageTrackingRecord(
        ImageName: String,
        IsEdited: Int,
        IsUpload: Int,
        RefFieldName: String
    )

    @Query("Update ImageTrackingRecord set IsUpload=1, IsEdited=0  where GUID=:GUID and RefFieldName=:RefFieldName and IsDeleted=0 and IsEdited=1")
    fun updateImageUpload(
        GUID: String,
        RefFieldName: String
    )
    @Query("Select Count(*) from ImageTrackingRecord where IsDeleted=0 and IsEdited=1")
    fun getAllImageTrackingRecordDataCount(): Int
}