package com.psc.elekha.utils

import com.psc.elekha.database.entity.MSTComboBox_NEntity

// Extension function
fun List<MSTComboBox_NEntity>.toValueList(): List<String> {
    return this.mapNotNull { it.Value }
}
