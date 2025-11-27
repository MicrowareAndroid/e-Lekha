package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "KYCDocument")
data class KYCDocumentEntity(
    @PrimaryKey @ColumnInfo(name = "KYCDocID") val KYCDocID: Int,
    @ColumnInfo(name = "KYCDocName") val KYCDocName: String?,
    @ColumnInfo(name = "KYCDocDBFieldName") val KYCDocDBFieldName: String?

)
