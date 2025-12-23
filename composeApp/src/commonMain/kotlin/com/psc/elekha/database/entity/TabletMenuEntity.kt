package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "TabletMenu")
data class TabletMenuEntity(
    @PrimaryKey @ColumnInfo(name = "TabletMenuID") val TabletMenuID: Int,
    @ColumnInfo(name = "TabletMenuName") val TabletMenuName: String?

)
