package com.microlekha.psc.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity

@Dao
interface MSTMonthlyIncomeMarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonthlyIncomeMarks(mSTMonthlyIncomeMarksEntity: MSTMonthlyIncomeMarksEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMonthlyIncomeMarks(mSTMonthlyIncomeMarksEntity: List<MSTMonthlyIncomeMarksEntity>?)

    @Query("Select * from MstMonthlyIncomeMarks")
    suspend  fun getAllMonthlyIncomeMarks(): List<MSTMonthlyIncomeMarksEntity>?

    @Query("Delete from MstMonthlyIncomeMarks")
    suspend fun deleteAllMonthlyIncomeMarks()

}