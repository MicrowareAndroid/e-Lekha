package com.psc.elekha.utils

import com.psc.elekha.database.entity.MSTComboBox_NEntity

object StaticComboBoxData {

    // Flag = 1 → Marital Status
    val maritalStatusList = listOf(
        MSTComboBox_NEntity(1, "Married", 1,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "Unmarried", 1,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(3, "Widow", 1,lang="eng", IsDeleted = false)
    )

    // Flag = 2 → Education
    val educationList = listOf(
        MSTComboBox_NEntity(1, "10th", 2,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "12th", 2,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(3, "Graduation", 2,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(4, "Post Graduation", 2,lang="eng", IsDeleted = false)
    )

    // Flag = 3 → Religion
    val religionList = listOf(
        MSTComboBox_NEntity(1, "Hindu", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "Muslim", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(3, "Sikh", 3,lang="eng", IsDeleted = false)
    )
    val purposeList = listOf(
        MSTComboBox_NEntity(1, "Business", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "Study Loan", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(3, "Home Loan", 3,lang="eng", IsDeleted = false)
    )

    val relationList = listOf(
        MSTComboBox_NEntity(1, "Brother", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "Husband", 3,lang="eng", IsDeleted = false),

    )

    val stateList = listOf(
        MSTComboBox_NEntity(1, "Delhi", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "Punjab", 3,lang="eng", IsDeleted = false),

        )

    val distictList = listOf(
        MSTComboBox_NEntity(1, "West", 3,lang="eng", IsDeleted = false),
        MSTComboBox_NEntity(2, "South", 3,lang="eng", IsDeleted = false),

        )
}
