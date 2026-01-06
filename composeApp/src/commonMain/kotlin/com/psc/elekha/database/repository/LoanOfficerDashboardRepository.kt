package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanofficerDashBoardDataDao
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity


class LoanOfficerDashboardRepository(private val dao: LoanofficerDashBoardDataDao) {

    suspend fun insertAllLoanOfficerData(list: List<LoanofficerDashBoardDataEntity>) {
        dao.insertDashboardDataList(list)
    }
    suspend fun getAllLoanOfficerData(): List<LoanofficerDashBoardDataEntity> {
        return dao.getAllDashboardData()
    }
}