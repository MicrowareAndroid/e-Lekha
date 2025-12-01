package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.TabletMenuEntity

@Dao
interface TabletMenuDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTabletMenu(tabletMenuEntity: TabletMenuEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTabletMenu(tabletMenuEntity: List<TabletMenuEntity>?)

    @Query("Select * from TabletMenu")
    fun getAllTabletMenu(): List<TabletMenuEntity>?

    @Query("Delete from TabletMenu")
    fun deleteAllTabletMenu()

}