package com.psc.elekha.utils

import com.psc.elekha.database.entity.MSTComboBox_NEntity

object StaticComboBoxData {

    val maritalStatusList = listOf(
        MSTComboBox_NEntity(1, "Single", 3, "en", false),
        MSTComboBox_NEntity(2, "Married", 3, "en", false),
        MSTComboBox_NEntity(3, "Divorced", 3, "en", false)
    )
    val educationList = listOf(
        MSTComboBox_NEntity(1, "12th", 3, "en", false),
        MSTComboBox_NEntity(2, "Graduation", 3, "en", false),
        MSTComboBox_NEntity(3, "Post Graduation", 3, "en", false)
    )
    val religionList = listOf(
        MSTComboBox_NEntity(1, "Hindu", 3, "en", false),
        MSTComboBox_NEntity(2, "Muslim", 3, "en", false),
         )
    val purposeList = listOf(
        MSTComboBox_NEntity(1, "Business", 3, "en", false),
        MSTComboBox_NEntity(2,  "Study Loan", 3, "en", false),
        MSTComboBox_NEntity(2,  "Home Loan", 3, "en", false),
        )
    val relationList = listOf(
        MSTComboBox_NEntity(1, "Brother", 3, "en", false),
        MSTComboBox_NEntity(2,   "Husband", 3, "en", false),
       )
    val districtList = listOf(
        MSTComboBox_NEntity(1, "West", 3, "en", false),
        MSTComboBox_NEntity(2,   "South" , 3, "en", false),
    )
    val stateList = listOf(
        MSTComboBox_NEntity(1, "Delhi", 3, "en", false),
        MSTComboBox_NEntity(2,   "Punjab" , 3, "en", false),
    )

}

