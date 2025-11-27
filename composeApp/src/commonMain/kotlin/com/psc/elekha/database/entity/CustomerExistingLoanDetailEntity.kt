package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomerExistingLoanDetail")
data class CustomerExistingLoanDetailEntity(
    @PrimaryKey @ColumnInfo(name = "MFIGUID") val MFIGUID: String,
    @ColumnInfo(name = "GUID") val GUID: String?,
    @ColumnInfo(name = "ExistingLoanID") val ExistingLoanID: Int?,
    @ColumnInfo(name = "LoanAmount") val LoanAmount: Int?,
    @ColumnInfo(name = "LoanPurposeID") val LoanPurposeID: Int?,
    @ColumnInfo(name = "MFIID") val MFIID: Int?,
    @ColumnInfo(name = "OutStandingAmount") val OutStandingAmount: Int?,
    @ColumnInfo(name = "IsUpload") val IsUpload: Int?,
    @ColumnInfo(name = "MemberName") val MemberName: String?,
    @ColumnInfo(name = "EMI") val EMI: Int?,
    @ColumnInfo(name = "IsEdited") val IsEdited: Int?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
