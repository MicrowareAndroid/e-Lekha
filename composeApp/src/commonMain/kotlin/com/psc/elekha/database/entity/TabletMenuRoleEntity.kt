package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TabletMenuRole")
data class TabletMenuRoleEntity(
    @PrimaryKey @ColumnInfo(name = "TableMenuID") val TableMenuID: Int,
    @ColumnInfo(name = "RoleID") val RoleID: String?

)
