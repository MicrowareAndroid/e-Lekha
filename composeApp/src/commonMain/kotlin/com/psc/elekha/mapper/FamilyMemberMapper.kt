package com.psc.elekha.mapper

import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.dto.CustomerFamilyMemberDto
import com.psc.elekha.dto.CustomerUploadDTO

fun CustomerFamilyMemberDetailsEntity.toUploadDTO() = CustomerFamilyMemberDto(
    GUID = GUID,
    MemberGuid = MemberGuid,
    MemberID = MemberID,
    MFirstName = MFirstName,
    MMiddleName = MMiddleName,
    MLastName = MLastName,
    RelationID = RelationID,
    Age = Age,
    IsSchooling = IsSchooling,
    EducationID = EducationID,
    IsEarning = IsEarning,
    OccupationID = OccupationID,
    MonthlyIncomeID = MonthlyIncomeID,
    Gender = Gender,
    IsOld = IsOld,
    MonthlyIncome = MonthlyIncome,
    Remarks = Remarks
)