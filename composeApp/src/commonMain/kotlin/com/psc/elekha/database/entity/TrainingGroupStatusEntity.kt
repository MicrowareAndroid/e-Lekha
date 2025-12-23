package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "TrainingGroupStatus")
data class TrainingGroupStatusEntity(
    @PrimaryKey
    @ColumnInfo(name = "TGroupStatusID") val TGroupStatusID: Int,
    @ColumnInfo(name = "TGroupStatus") val TGroupStatus: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?
)
