package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "MSTDistrict")
data class MSTDistrictEntity(
    @PrimaryKey @ColumnInfo(name = "DistrictID") val DistrictID: Int,
    @ColumnInfo(name = "StateID") val StateID: Int?,
    @ColumnInfo(name = "District") val District: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
