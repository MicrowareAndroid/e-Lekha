package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.MSTComboBox_NDao
import com.psc.elekha.database.entity.MSTComboBox_NEntity

class MSTComboBox_NRepository(
    private val comboDao: MSTComboBox_NDao
) {

    // Insert single combo item
    suspend fun insertComboBox(item: MSTComboBox_NEntity) {
        comboDao.insertComboBox(item)
    }

    // Insert list of combo items
    suspend fun insertAllComboBox(list: List<MSTComboBox_NEntity>) {
        comboDao.insertAllComboBox(list)
    }

    // Get all combo items by Flag
    suspend fun getAllComboBox(flag: Int): List<MSTComboBox_NEntity> {
        return comboDao.getAllComboBox(flag)
    }

    // Get only value using Flag and ID
    suspend fun getComboBoxValue(flag: Int, id: Int): String? {
        return comboDao.getComboBoxValue(flag, id)
    }

    // Delete all combo items
    suspend fun deleteAllComboBox() {
        comboDao.deleteAllComboBox()
    }
}
