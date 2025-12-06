package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.LoanClosureDao
import com.psc.elekha.database.entity.LoanClosureEntity

class LoanClosureRepository(
    private val dao: LoanClosureDao
) {

    // Insert single loan closure
    fun insertLoanClosure(loanClosure: LoanClosureEntity) {
        dao.insertLoanClouser(loanClosure)
    }

    // Insert multiple loan closures
    fun insertAllLoanClosure(loanClosures: List<LoanClosureEntity>) {
        dao.insertAllLoanClouser(loanClosures)
    }

    // Get all loan closures
    fun getAllLoanClosure(): List<LoanClosureEntity>? {
        return dao.getAllLoanClouser()
    }

    // Get loan closures to upload
    fun getLoanClosureUploadData(): List<LoanClosureEntity>? {
        return dao.getLoanClouserUploadData()
    }

    // Get count of loan closures to upload
    fun getLoanClosureUploadDataCount(): Int {
        return dao.getLoanClouserUploadDataCount()
    }

    // Update loan closure data
    fun updateLoanClosureData(
        PaidDate: String,
        LoanLat: Double,
        LoanLong: Double,
        LoanPlace: String,
        GUID: String
    ) {
        dao.updateLoanClouserData(PaidDate, LoanLat, LoanLong, LoanPlace, GUID)
    }

    // Mark uploaded
    fun updateLoanClosureDataUploaded() {
        dao.updateLoanClouserDataUploaded()
    }

    // Delete all loan closures
    fun deleteAllLoanClosure() {
        dao.deleteAllLoanClouser()
    }
}
