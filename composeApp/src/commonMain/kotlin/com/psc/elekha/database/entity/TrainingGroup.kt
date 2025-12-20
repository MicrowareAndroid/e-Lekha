package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TrainingGroup")
data class TrainingGroup(

    @PrimaryKey @ColumnInfo(name = "UID") val UID: Int,
    @ColumnInfo(name = "CGT_GroupImage2") val CGT_GroupImage2: String?,
    @ColumnInfo(name = "GRT_GroupImage") val GRT_GroupImage: String?,
    @ColumnInfo(name = "CGT_GroupImage") val CGT_GroupImage: String?,
    @ColumnInfo(name = "longitudeDay2") val longitudeDay2: Double?,
    @ColumnInfo(name = "longitudeDay1") val longitudeDay1: Double?,
    @ColumnInfo(name = "latitudeDay2") val latitudeDay2: Double?,
    @ColumnInfo(name = "latitudeDay1") val latitudeDay1: Double?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Int?,
    @ColumnInfo(name = "TGroupID") val TGroupID: Int?,
    @ColumnInfo(name = "TGroupName") val TGroupName: String?,
    @ColumnInfo(name = "Day1_Date") val Day1_Date: String?,
    @ColumnInfo(name = "Day1_Place") val Day1_Place: String?,
    @ColumnInfo(name = "Day2_Date") val Day2_Date: String?,
    @ColumnInfo(name = "Day2_Place") val Day2_Place: String?,
    @ColumnInfo(name = "VillageID") val VillageID: Int?,
    @ColumnInfo(name = "CurrentStatus") val CurrentStatus: String?,
    @ColumnInfo(name = "UserID") val UserID: String?,
    @ColumnInfo(name = "CreatedBy") val CreatedBy: String?,
    @ColumnInfo(name = "CreatedDate") val CreatedDate: String?,
    @ColumnInfo(name = "CenterID") val CenterID: String?

    )
