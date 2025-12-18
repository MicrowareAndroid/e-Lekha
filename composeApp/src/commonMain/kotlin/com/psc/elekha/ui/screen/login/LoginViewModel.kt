package com.psc.elekha.ui.screen.login

import androidx.lifecycle.ViewModel
import com.psc.elekha.database.entity.MSTComboBox_NEntity
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel


class LoginViewModel(

    private val mSTComboBoxNViewModel: MSTComboBox_NViewModel,
) : ViewModel() {


    fun updateData() {
        val maritalStatusList = listOf(
            MSTComboBox_NEntity(1, "Single", 1, "en", false),
            MSTComboBox_NEntity(2, "Married", 1, "en", false),
            MSTComboBox_NEntity(3, "Divorced", 1, "en", false),
            MSTComboBox_NEntity(1, "12th", 2, "en", false),
            MSTComboBox_NEntity(2, "Graduation", 2, "en", false),
            MSTComboBox_NEntity(3, "Post Graduation", 2, "en", false),
            MSTComboBox_NEntity(1, "Hindu", 3, "en", false),
            MSTComboBox_NEntity(2, "Muslim", 3, "en", false),
            MSTComboBox_NEntity(1, "Business", 4, "en", false),
            MSTComboBox_NEntity(2,  "Study Loan", 4, "en", false),
            MSTComboBox_NEntity(2,  "Home Loan", 4, "en", false),
            MSTComboBox_NEntity(1, "Brother", 5, "en", false),
            MSTComboBox_NEntity(2,   "Husband", 5, "en", false),
            MSTComboBox_NEntity(1, "West", 6, "en", false),
            MSTComboBox_NEntity(2,   "South" , 6, "en", false),
            MSTComboBox_NEntity(1, "Delhi", 7, "en", false),
            MSTComboBox_NEntity(2,   "Punjab" , 7, "en", false),
            MSTComboBox_NEntity(1, "Male", 8, "en", false),
            MSTComboBox_NEntity(2, "Female", 8, "en", false),
            MSTComboBox_NEntity(3, "Other", 8, "en", false),
            MSTComboBox_NEntity(1, "Doctor", 9, "en", false),
            MSTComboBox_NEntity(2, "Teacher", 9, "en", false),
            MSTComboBox_NEntity(3, "Driver", 9, "en", false),
            MSTComboBox_NEntity(4, "Engineer", 9, "en", false),
            MSTComboBox_NEntity(5, "Business", 9, "en", false),
            MSTComboBox_NEntity(6, "Other", 9, "en", false),
            MSTComboBox_NEntity(1, "Card", 10, "en", false),
            MSTComboBox_NEntity(2, "Bank", 10, "en", false),
            MSTComboBox_NEntity(1, "Truck", 10, "en", false),
            MSTComboBox_NEntity(1, "SBI", 11, "en", false),
            MSTComboBox_NEntity(2, "HDFC", 11, "en", false),
            MSTComboBox_NEntity(3, "AXIS", 11, "en", false),
            MSTComboBox_NEntity(1, "SBI Delhi", 12, "en", false),
            MSTComboBox_NEntity(2, "SBI Gurgaon", 12, "en", false),
            MSTComboBox_NEntity(3, "HDFC Delhi", 12, "en", false),
            MSTComboBox_NEntity(4, "HDFC Gurgaon", 12, "en", false),
            MSTComboBox_NEntity(5, "AXIS Delhi", 12, "en", false),
            MSTComboBox_NEntity(6, "AXIS Gurgaon", 12, "en", false),
        )

        mSTComboBoxNViewModel.insertAllComboBox(maritalStatusList)
    }




}
