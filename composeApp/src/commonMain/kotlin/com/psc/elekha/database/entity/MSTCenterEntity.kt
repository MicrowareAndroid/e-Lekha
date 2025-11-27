package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MstCenter")
data class MSTCenterEntity(
    @PrimaryKey @ColumnInfo(name = "CenterID") val CenterID: Int,
    @ColumnInfo(name = "Center") val Center: String?,
    @ColumnInfo(name = "VillageID") val VillageID: Int?,
    @ColumnInfo(name = "CollectionDay") val CollectionDay: Int?,
    @ColumnInfo(name = "MeetingTime") val MeetingTime: String?,
    @ColumnInfo(name = "UserID") val UserID: String?,
    @ColumnInfo(name = "HouseNo") val HouseNo: String?,
    @ColumnInfo(name = "Road") val Road: String?,
    @ColumnInfo(name = "Locality") val Locality: String?,
    @ColumnInfo(name = "LandMark") val LandMark: String?,
    @ColumnInfo(name = "Pin") val Pin: String?,
    @ColumnInfo(name = "DistanceFromBranch") val DistanceFromBranch: Double?,
    @ColumnInfo(name = "ActiveCustomer") val ActiveCustomer: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
