package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "MSTAssetsValuation")
data class MSTAssetsValuationEntity(
    @PrimaryKey @ColumnInfo(name = "AssetID") val AssetID: Int,
    @ColumnInfo(name = "AssetValueID") val AssetValueID: Int?,
    @ColumnInfo(name = "AssetValueName") val AssetValueName: String?,
    @ColumnInfo(name = "Flag") val Flag: Int?,
    @ColumnInfo(name = "AssetValueMarks") val AssetValueMarks: Double?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?

)
