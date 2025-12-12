package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.ImageTrackingRecordEntity

@Dao
interface ImageTrackingRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageTrackingRecord(imageTrackingRecordEntity: ImageTrackingRecordEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageTrackingRecord(imageTrackingRecordEntity: List<ImageTrackingRecordEntity>)

    @Query("Select * from ImageTrackingRecord where IsDeleted = 0 and IsEdited = 1 and IsUpload = 0")
    suspend fun getAllImageTrackingRecord(): List<ImageTrackingRecordEntity>

    @Query("Select * from ImageTrackingRecord where IsDeleted = 0")
    suspend fun getImageAllData(): List<ImageTrackingRecordEntity>

    @Query("Delete from ImageTrackingRecord")
    suspend fun deleteAllImageTrackingRecord()

    @Query("Select Count(*) from ImageTrackingRecord where RefFieldName=:RefFieldName and GUID=:GUID and IsDeleted=0")
    suspend  fun getCountImageTrackingRecord(RefFieldName: String, GUID: String): Int?

    @Query("Update ImageTrackingRecord set ImageName=:ImageName, IsEdited=:IsEdited, IsUpload=:IsUpload where RefFieldName=:RefFieldName")
    suspend fun updateImageTrackingRecord(
        ImageName: String,
        IsEdited: Int,
        IsUpload: Int,
        RefFieldName: String
    )

    @Query("Update ImageTrackingRecord set IsUpload=1, IsEdited=0  where GUID=:GUID and RefFieldName=:RefFieldName and IsDeleted=0 and IsEdited=1")
    suspend fun updateImageUpload(
        GUID: String,
        RefFieldName: String
    )
    @Query("Select Count(*) from ImageTrackingRecord where IsDeleted=0 and IsEdited=1")
    suspend fun getAllImageTrackingRecordDataCount(): Int
}