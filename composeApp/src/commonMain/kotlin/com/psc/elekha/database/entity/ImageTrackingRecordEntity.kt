package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ImageTrackingRecord", primaryKeys = ["GUID", "RefFieldName"])
data class ImageTrackingRecordEntity(
    @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "RefFieldName") val RefFieldName: String,
    @ColumnInfo(name = "ImageName") val ImageName: String?,
    @ColumnInfo(name = "ImageFieldName") val ImageFieldName: String?,
    @ColumnInfo(name = "RenameImage") val RenameImage: String?,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?,
    @ColumnInfo(name = "IsUpload") val IsUpload: Int?

)
