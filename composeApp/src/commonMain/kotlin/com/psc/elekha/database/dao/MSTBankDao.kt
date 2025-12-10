package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTBankEntity

@Dao
interface MSTBankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend   fun insertBank(mSTBankEntity: MSTBankEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBank(mSTBankEntity: List<MSTBankEntity>?)

    @Query("Select * from MSTBank where IsDeleted = 0 order by Bank")
    suspend fun getAllBank(): List<MSTBankEntity>?

    @Query("Delete from MSTBank")
    suspend  fun deleteAllBank()

}