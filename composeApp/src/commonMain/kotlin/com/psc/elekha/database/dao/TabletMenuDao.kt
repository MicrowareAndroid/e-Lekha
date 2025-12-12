package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.TabletMenuEntity

@Dao
interface TabletMenuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertTabletMenu(tabletMenuEntity: TabletMenuEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertAllTabletMenu(tabletMenuEntity: List<TabletMenuEntity>)

    @Query("Select * from TabletMenu")
    suspend fun getAllTabletMenu(): List<TabletMenuEntity>

    @Query("Delete from TabletMenu")
    suspend fun deleteAllTabletMenu()

}