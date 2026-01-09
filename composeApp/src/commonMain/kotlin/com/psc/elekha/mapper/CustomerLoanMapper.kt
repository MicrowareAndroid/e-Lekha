package com.psc.elekha.mapper

import com.psc.elekha.database.entity.CustomerEntity
import com.psc.elekha.database.entity.CustomerExistingLoanDetailEntity
import com.psc.elekha.database.entity.CustomerFamilyMemberDetailsEntity
import com.psc.elekha.dto.CustomerExistLoanDto
import com.psc.elekha.dto.CustomerFamilyMemberDto
import com.psc.elekha.dto.CustomerUploadDTO

fun CustomerExistingLoanDetailEntity.toUploadDTO() = CustomerExistLoanDto(
    MFIGUID = MFIGUID,
    GUID = GUID,
    ExistingLoanID = ExistingLoanID,
    LoanAmount = LoanAmount,
    LoanPurposeID = LoanPurposeID,
    MFIID = MFIID,
    OutStandingAmount = OutStandingAmount,
    MemberName = MemberName,
    EMI = EMI,
    MFIBankAccountName = MFIBankAccountName,
    Remarks = Remarks
)