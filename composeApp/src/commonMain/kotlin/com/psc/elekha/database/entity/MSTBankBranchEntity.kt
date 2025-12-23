package com.psc.elekha.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = "MSTBankBranch")
data class MSTBankBranchEntity(
    @PrimaryKey @ColumnInfo(name = "BranchID") val BranchID: Int,
    @ColumnInfo(name = "BankID") val BankID: Int?,
    @ColumnInfo(name = "BranchName") val BranchName: String?,
    @ColumnInfo(name = "IFSCCode") val IFSCCode: String?

)
