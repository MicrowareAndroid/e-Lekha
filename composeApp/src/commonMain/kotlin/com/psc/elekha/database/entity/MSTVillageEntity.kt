package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "MSTVillage")
data class MSTVillageEntity(
    @PrimaryKey @ColumnInfo(name = "VillageID") val VillageID: Int,
    @ColumnInfo(name = "BranchID") val BranchID: Int?,
    @ColumnInfo(name = "Village") val Village: String?,
    @ColumnInfo(name = "PinCode") val PinCode: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?,
    @ColumnInfo(name = "VillageCode") val VillageCode: String?,
    @ColumnInfo(name = "DistrictCode") val DistrictCode: Int?

)
