package com.psc.elekha.database.repository

import com.microlekha.psc.dao.MSTMonthlyIncomeMarksDao
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity

class MSTMonthlyIncomeMarksRepository(
    private val monthlyIncomeMarksDao: MSTMonthlyIncomeMarksDao
) {

    // Insert single monthly income marks record
    suspend fun insertMonthlyIncomeMarks(item: MSTMonthlyIncomeMarksEntity) {
        monthlyIncomeMarksDao.insertMonthlyIncomeMarks(item)
    }

    // Insert list of monthly income marks records
    suspend fun insertAllMonthlyIncomeMarks(list: List<MSTMonthlyIncomeMarksEntity>) {
        monthlyIncomeMarksDao.insertAllMonthlyIncomeMarks(list)
    }

    // Get all monthly income marks records
    suspend fun getAllMonthlyIncomeMarks(): List<MSTMonthlyIncomeMarksEntity> {
        return monthlyIncomeMarksDao.getAllMonthlyIncomeMarks()
    }

    // Delete all monthly income marks records
    suspend fun deleteAllMonthlyIncomeMarks() {
        monthlyIncomeMarksDao.deleteAllMonthlyIncomeMarks()
    }
}
