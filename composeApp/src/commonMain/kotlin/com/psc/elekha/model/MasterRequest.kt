package com.psc.elekha.model

import kotlinx.serialization.Serializable

@Serializable
data class MasterRequest(
    var pUsername: String,
    var pPassword: String
)