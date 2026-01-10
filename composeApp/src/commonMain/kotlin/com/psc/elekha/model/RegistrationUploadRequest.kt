package com.psc.elekha.model


import com.psc.elekha.dto.CustomerExistLoanDto
import com.psc.elekha.dto.CustomerFamilyMemberDto
import com.psc.elekha.dto.CustomerMovableAssetsDto
import com.psc.elekha.dto.CustomerUploadDTO
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationUploadRequest (
    val customers: List<CustomerUploadDTO>,
    val familyMembers: List<CustomerFamilyMemberDto>,
    val existingLoans: List<CustomerExistLoanDto>,
    val movableAssets: List<CustomerMovableAssetsDto>
)