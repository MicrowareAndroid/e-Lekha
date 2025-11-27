package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MSTBranch")
data class MSTBranchEntity(
    @PrimaryKey @ColumnInfo(name = "BranchID") val BranchID: Int,
    @ColumnInfo(name = "WorkingDate") val WorkingDate: String?,
    @ColumnInfo(name = "DistrictID") val DistrictID: Int?,
    @ColumnInfo(name = "Branch") val Branch: String?,
    @ColumnInfo(name = "BranchPhoneNumber") val BranchPhoneNumber: String?,
    @ColumnInfo(name = "BranchCode") val BranchCode: String?,
    @ColumnInfo(name = "IsDeleted") val IsDeleted: Boolean?

)
