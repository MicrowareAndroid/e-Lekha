package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "MstComboBox_N", primaryKeys = ["ID", "Flag"])
data class MSTComboBox_NEntity(
    @ColumnInfo(name = "ID") val ID: Int,
    @ColumnInfo(name = "Value") val Value: String?,
    @ColumnInfo(name = "Flag") val Flag: Int,
    @ColumnInfo(name = "lang") val lang: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)