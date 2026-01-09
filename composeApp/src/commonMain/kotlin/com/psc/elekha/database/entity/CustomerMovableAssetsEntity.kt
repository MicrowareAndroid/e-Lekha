package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable



@Entity(tableName = "CustomerMovableAssets")
data class CustomerMovableAssetsEntity(
    @PrimaryKey @ColumnInfo(name = "MAGUID") val MAGUID: String,
    @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "VehicleID") val VehicleID: Int?,
    @ColumnInfo(name = "VehicleNo") val VehicleNo: String?,
    @ColumnInfo(name = "VehicleImageName") val VehicleImageName: String?,
    @ColumnInfo(name = "IsUpload") val IsUpload: Int?,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?

)
