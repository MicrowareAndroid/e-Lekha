package com.psc.elekha.utils

import com.psc.elekha.database.entity.MSTComboBox_NEntity

fun List<MSTComboBox_NEntity>.toValueList(): List<String> {
    return this.map { it.Value ?: "" }
}
