package com.psc.elekha.mapper

import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.database.entity.CustomerMovableAssetsEntity
import com.psc.elekha.dto.CustomerExistLoanDto
import com.psc.elekha.dto.CustomerFamilyMemberDto
import com.psc.elekha.dto.CustomerMovableAssetsDto
import com.psc.elekha.dto.CustomerUploadDTO

fun CustomerMovableAssetsEntity.toUploadDTO() = CustomerMovableAssetsDto(
    MAGUID = MAGUID,
    GUID = GUID,
    VehicleID = VehicleID,
    VehicleNo = VehicleNo,
    VehicleImageName = VehicleImageName
)