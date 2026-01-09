package com.psc.elekha.dto

import kotlinx.serialization.Serializable

@Serializable
data class CustomerMovableAssetsDto(
    val MAGUID: String,
    val GUID: String,
    val VehicleID: Int?,
    val VehicleNo: String?,
    val VehicleImageName: String?
)

