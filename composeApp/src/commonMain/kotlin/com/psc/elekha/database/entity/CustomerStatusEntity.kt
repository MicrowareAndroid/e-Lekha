package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerStatus")
data class CustomerStatusEntity(
    @PrimaryKey @ColumnInfo(name = "CustomerStatusID") val CustomerStatusID: Int,
    @ColumnInfo(name = "CustomerStatus") val CustomerStatus: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
