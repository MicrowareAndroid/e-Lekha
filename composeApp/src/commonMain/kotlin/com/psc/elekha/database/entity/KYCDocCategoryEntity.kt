package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "KYCDocCategory")
data class KYCDocCategoryEntity(
    @PrimaryKey @ColumnInfo(name = "KYCCatID") val KYCCatID: Int,
    @ColumnInfo(name = "KYCCatName") val KYCCatName: String?

)
