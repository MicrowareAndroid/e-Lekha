package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTState")
data class MSTStateEntity(
    @PrimaryKey @ColumnInfo(name = "StateID") val StateID: Int,
    @ColumnInfo(name = "State") val State: String?

)
