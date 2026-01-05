package com.psc.elekha.response

import com.psc.elekha.database.entity.LoanClosureEntity
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity
import com.psc.elekha.database.entity.MSTBranchEntity
import com.psc.elekha.database.entity.TrainingGroupEntity
import com.psc.elekha.database.entity.TrainingGroupMemberEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GtrResponse(
    @SerialName("TrainingGroup")
    val trainingGroupEntity: List<TrainingGroupEntity> = emptyList(),

    @SerialName("TrainingGroupMember")
    val trainingGroupMemberEntity: List<TrainingGroupMemberEntity> = emptyList(),

    )