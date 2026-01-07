package com.psc.elekha.model

import kotlinx.serialization.Serializable

@Serializable
data class GtrRequest(
    var pUsername: String,
    var pPassword: String,
    var sLoanOfficerID: String,
    var iVillageID: Int
)