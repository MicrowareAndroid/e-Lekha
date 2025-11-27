package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTPovertyStatus")
data class MSTPovertyStatusEntity(
    @PrimaryKey @ColumnInfo(name = "PID") val PID: Int,
    @ColumnInfo(name = "MinValue") val MinValue: Int?,
    @ColumnInfo(name = "MaxValue") val MaxValue: Int?,
    @ColumnInfo(name = "Status") val Status: String?

)
