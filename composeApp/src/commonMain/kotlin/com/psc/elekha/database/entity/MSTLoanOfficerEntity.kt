package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "MSTLoanOfficer")
data class MSTLoanOfficerEntity(
    @PrimaryKey @ColumnInfo(name = "LoanOfficerID") val LoanOfficerID: String,
    @ColumnInfo(name = "LoanOfficerName") val LoanOfficerName: String?

)
