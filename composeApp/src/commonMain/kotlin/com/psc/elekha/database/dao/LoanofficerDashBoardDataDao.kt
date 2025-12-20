package com.psc.elekha.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.psc.elekha.database.entity.LoanofficerDashBoardDataEntity

@Dao
interface LoanofficerDashBoardDataDao {

    //  Insert / Update (Single)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDashboardData(data: LoanofficerDashBoardDataEntity)

    //  Insert / Update (List)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDashboardDataList(list: List<LoanofficerDashBoardDataEntity>)

    //  Get dashboard by LoanOfficerID
    @Query("""
        SELECT * FROM LoanofficerDashBoardData 
        WHERE LoanofficerID = :loanOfficerId
    """)
    suspend fun getDashboardByLoanOfficerId(
        loanOfficerId: String
    ): LoanofficerDashBoardDataEntity?

    // Get all dashboard records
    @Query("SELECT * FROM LoanofficerDashBoardData")
    suspend fun getAllDashboardData(): List<LoanofficerDashBoardDataEntity>

    // Update dashboard data
    @Update
    suspend fun updateDashboardData(data: LoanofficerDashBoardDataEntity)

    // Delete single record
    @Delete
    suspend fun deleteDashboardData(data: LoanofficerDashBoardDataEntity)

    //  Delete by LoanOfficerID
    @Query("""
        DELETE FROM LoanofficerDashBoardData 
        WHERE LoanofficerID = :loanOfficerId
    """)
    suspend fun deleteDashboardByLoanOfficerId(loanOfficerId: String)

    //  Clear table
    @Query("DELETE FROM LoanofficerDashBoardData")
    suspend fun clearDashboardTable()
}