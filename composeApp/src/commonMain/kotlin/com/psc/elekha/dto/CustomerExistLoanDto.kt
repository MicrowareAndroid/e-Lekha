package com.psc.elekha.dto

import kotlinx.serialization.Serializable

@Serializable
data class CustomerExistLoanDto(
    val MFIGUID: String,
    val GUID: String,
    val ExistingLoanID: Int?,
    val LoanAmount: Int?,
    val LoanPurposeID: Int?,
    val MFIID: Int?,
    val OutStandingAmount: Int?,
    val MemberName: String?,
    val EMI: Int?,
    val MFIBankAccountName: String?,
    val Remarks: String?
)
