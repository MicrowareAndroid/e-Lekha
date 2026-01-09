package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "ImageDetail")
data class ImageDetailEntity(
    @PrimaryKey @ColumnInfo(name = "RefFieldName") val RefFieldName: Int,
    @ColumnInfo(name = "ImageFieldName") val ImageFieldName: String?,
    @ColumnInfo(name = "RenameImage") val RenameImage: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?

)

