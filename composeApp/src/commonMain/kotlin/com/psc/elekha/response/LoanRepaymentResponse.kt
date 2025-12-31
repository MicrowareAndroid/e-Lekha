package com.psc.elekha.response

import com.psc.elekha.database.entity.LoanClosureEntity
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity
import com.psc.elekha.database.entity.MSTBranchEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanRepaymentResponse(
    @SerialName("LoanRepayment")
    val loanRepayment: List<LoanRepaymentEntity> = emptyList(),

    @SerialName("LoanClouser")
    val loanClouser: List<LoanClosureEntity> = emptyList(),

    @SerialName("Branch")
    val mstBranch: List<MSTBranchEntity> = emptyList(),

    @SerialName("LoanofficerdashBoardData")
    val loanofficerDashBoardData: List<LoanofficerDashBoardDataEntity> = emptyList(),

    )