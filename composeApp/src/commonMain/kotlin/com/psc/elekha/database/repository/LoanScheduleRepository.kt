package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanScheduleDao
import com.psc.elekha.database.entity.LoanScheduleEntity

class LoanScheduleRepository(
    private val dao: LoanScheduleDao
) {

    fun insertLoanSchedule(loanSchedule: LoanScheduleEntity) {
        dao.insertLoanSchedule(loanSchedule)
    }

    fun insertAllLoanSchedule(loanSchedules: List<LoanScheduleEntity>) {
        dao.insertAllLoanSchedule(loanSchedules)
    }

    fun getAllLoanSchedule(): List<LoanScheduleEntity>? = dao.getAllLoanSchedule()

    fun getLoanScheduleByGUID(GUID: String): List<LoanScheduleEntity>? = dao.getLoanScheduleByGUID(GUID)

    fun getLoanScheduleByGUIDAndPaidDate(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDate(GUID)

    fun getLoanScheduleByGUIDAndPaidDateWithLimit(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDateWithLimit(GUID)

    fun getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleByGUIDAndPaidDateWithLimit4(GUID)

    fun getWorkingDateByGUID(GUID: String): String? = dao.getWorkingDateByGUID(GUID)

    fun getEMIDueDateByGUID(GUID: String): String? = dao.getEMIDueDateByGUID(GUID)

    fun getLoanScheduleModulus(GUID: String): List<LoanScheduleEntity>? = dao.getLoanScheduleModulus(GUID)

    fun getLoanScheduleCountByGUID(GUID: String): Int = dao.getLoanScheduleCountByGUID(GUID)

    fun getMaxCustomerLoanID(GUID: String): Int = dao.getMaxCustomerLoanID(GUID)

    fun getCloseDate(GUID: String, CustomerLoanID: Int): String = dao.getCloseDate(GUID, CustomerLoanID)

    fun getLoanScheduleModulusPay(GUID: String, sCurrentDate: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleModulusPay(GUID, sCurrentDate)

    fun getLoanScheduleModulusPayTwoDate(GUID: String, sLastPaidDate: String, sCurrentDate: String): List<LoanScheduleEntity>? =
        dao.getLoanScheduleModulusPayTwoDate(GUID, sLastPaidDate, sCurrentDate)

    fun getLastPaidDate(GUID: String): String = dao.getLastPaidDate(GUID)

    fun getUnpaidEMISum(GUID: String): Int = dao.getUnpaidEMISum(GUID)

    fun getMaxCustomerLoanIDBYEMI(GUID: String, CustomerLoanID: Int): Int =
        dao.getMaxCustomerLoanIDBYEMI(GUID, CustomerLoanID)

}
