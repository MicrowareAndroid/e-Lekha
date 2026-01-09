package com.psc.elekha.dto

import kotlinx.serialization.Serializable

@Serializable
data class CustomerFamilyMemberDto(
    val GUID: String,
    val MemberGuid: String?,
    val MemberID: Int?,
    val MFirstName: String?,
    val MMiddleName: String?,
    val MLastName: String?,
    val RelationID: Int?,
    val Age: Int?,
    val IsSchooling: Int?,
    val EducationID: Int?,
    val IsEarning: Int?,
    val OccupationID: Int?,
    val MonthlyIncomeID: Int?,
    val Gender: String?,
    val IsOld: Int?,
    val MonthlyIncome: Int?,
    val Remarks: String?
)
