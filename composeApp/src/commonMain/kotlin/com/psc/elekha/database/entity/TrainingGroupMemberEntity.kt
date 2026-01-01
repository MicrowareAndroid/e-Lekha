package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "TrainingGroupMember")
data class TrainingGroupMemberEntity(
    @PrimaryKey
    @ColumnInfo(name = "TGroupMemberID") val TGroupMemberID: Int,
    @ColumnInfo(name = "TGroupID") val TGroupID: Int?,
    @ColumnInfo(name = "GUID") val GUID: String?,
    @ColumnInfo(name = "AttendanceDay1") val AttendanceDay1: String?,
    @ColumnInfo(name = "AttendanceDay2") val AttendanceDay2: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?
)
