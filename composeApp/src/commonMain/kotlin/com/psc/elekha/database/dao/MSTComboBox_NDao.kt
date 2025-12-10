package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.MSTComboBox_NEntity

@Dao
interface MSTComboBox_NDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComboBox(mSTComboBox_NEntity: MSTComboBox_NEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertAllComboBox(mSTComboBox_NEntity: List<MSTComboBox_NEntity>?)

    @Query("Select * from MstComboBox_N Where Flag=:Flag and IsDeleted = 0 ORDER by Value")
    suspend  fun getAllComboBox(Flag: Int): List<MSTComboBox_NEntity>?

    @Query("Select Value from MstComboBox_N Where Flag=:Flag and ID=:ID and IsDeleted = 0")
    suspend fun getComboBoxValue(Flag: Int, ID: Int): String?

    @Query("Delete from MstComboBox_N")
    suspend  fun deleteAllComboBox()

}