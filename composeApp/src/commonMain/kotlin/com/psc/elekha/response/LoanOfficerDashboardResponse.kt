package com.psc.elekha.response

import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanOfficerDashboardResponse (
    @SerialName("LoanofficerDashBoardData")
    val loanofficerDashBoardData: List<LoanofficerDashBoardDataEntity> = emptyList()
)