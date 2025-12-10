package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanScheduleDao
import com.psc.elekha.database.entity.LoanScheduleEntity

class LoanScheduleRepository(
    private val dao: LoanScheduleDao
) {

    suspend fun insertLoanSchedule(loanSchedule: LoanScheduleEntity) {
        dao.insertLoanSchedule(loanSchedule)
    }

    suspend fun insertAllLoanSchedule(loanSchedules: List<LoanScheduleEntity>) {
        dao.insertAllLoanSchedule(loanSchedules)
    }

    suspend fun getAllLoanSchedule(): List<LoanScheduleEntity>? = dao.getAllLoanSchedule()

    suspend fun getLoanScheduleByGUID(GUID: String): List<LoanScheduleEntity>? = dao.getLoanScheduleByGUID(GUID)

    suspend fun getLoanScheduleByGUIDAndPaidDate(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDate(GUID)

    suspend fun getLoanScheduleByGUIDAndPaidDateWithLimit(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDateWithLimit(GUID)

    suspend fun getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID)

    suspend  fun getWorkingDateByGUID(GUID: String): String? = dao.getWorkingDateByGUID(GUID)

    suspend fun getEMIDueDateByGUID(GUID: String): String? = dao.getEMIDueDateByGUID(GUID)

    suspend fun getLoanScheduleModulus(GUID: String): List<LoanScheduleEntity>? = dao.getLoanScheduleModulus(GUID)

    suspend fun getLoanScheduleCountByGUID(GUID: String): Int = dao.getLoanScheduleCountByGUID(GUID)

    suspend fun getMaxCustomerLoanID(GUID: String): Int = dao.getMaxCustomerLoanID(GUID)

    suspend fun getCloseDate(GUID: String, CustomerLoanID: Int): String = dao.getCloseDate(GUID, CustomerLoanID)

    suspend fun getLoanScheduleModulusPay(GUID: String, sCurrentDate: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleModulusPay(GUID, sCurrentDate)

    suspend fun getLoanScheduleModulusPayTwoDate(GUID: String, sLastPaidDate: String, sCurrentDate: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleModulusPayTwoDate(GUID, sLastPaidDate, sCurrentDate)

    suspend fun getLastPaidDate(GUID: String): String = dao.getLastPaidDate(GUID)

    suspend fun getUnpaidEMISum(GUID: String): Int = dao.getUnpaidEMISum(GUID)

    suspend fun getMaxCustomerLoanIDBYEMI(GUID: String, CustomerLoanID: Int): Int =
        dao.getMaxCustomerLoanIDBYEMI(GUID, CustomerLoanID)

}
