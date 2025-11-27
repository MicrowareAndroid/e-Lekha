package com.microlekha.psc.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTMonthlyIncomeMarksEntity

@Dao
interface MSTMonthlyIncomeMarksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMonthlyIncomeMarks(mSTMonthlyIncomeMarksEntity: MSTMonthlyIncomeMarksEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMonthlyIncomeMarks(mSTMonthlyIncomeMarksEntity: List<MSTMonthlyIncomeMarksEntity>?)

    @Query("Select * from MstMonthlyIncomeMarks")
    fun getAllMonthlyIncomeMarks(): List<MSTMonthlyIncomeMarksEntity>?

    @Query("Delete from MstMonthlyIncomeMarks")
    fun deleteAllMonthlyIncomeMarks()

}