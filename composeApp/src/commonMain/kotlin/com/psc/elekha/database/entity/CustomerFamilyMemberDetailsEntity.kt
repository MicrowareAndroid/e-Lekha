package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerFamilyMemberDetails")
data class CustomerFamilyMemberDetailsEntity(
    @PrimaryKey @ColumnInfo(name = "GUID") val GUID: String,
    @ColumnInfo(name = "MemberGuid") val MemberGuid: String?,
    @ColumnInfo(name = "MemberID") val MemberID: Int?,
    @ColumnInfo(name = "MFirstName") val MFirstName: String?,
    @ColumnInfo(name = "MMiddleName") val MMiddleName: String?,
    @ColumnInfo(name = "MLastName") val MLastName: String?,
    @ColumnInfo(name = "RelationID") val RelationID: Int?,
    @ColumnInfo(name = "Age") val Age: Int?,
    @ColumnInfo(name = "IsSchooling") val IsSchooling: Int?,
    @ColumnInfo(name = "EducationID") val EducationID: Int?,
    @ColumnInfo(name = "IsEarning") val IsEarning: Int?,
    @ColumnInfo(name = "OccupationID") val OccupationID: Int?,
    @ColumnInfo(name = "MonthlyIncomeID") val MonthlyIncomeID: Int?,
    @ColumnInfo(name = "Gender") val Gender: String?,
    @ColumnInfo(name = "IsOld") val IsOld: Int?,
    @ColumnInfo(name = "MonthlyIncome") val MonthlyIncome: Int?,
    @ColumnInfo(name = "IsUpload") val IsUpload: Int?,
    @ColumnInfo(name = "Remarks") val Remarks: String?

)
