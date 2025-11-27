package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.TabletMenuRoleEntity

@Dao
interface TabletMenuRoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTabletMenuRole(tabletMenuRoleEntity: TabletMenuRoleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTabletMenuRole(tabletMenuRoleEntity: List<TabletMenuRoleEntity>?)

    @Query("Select * from TabletMenuRole")
    fun getAllTabletMenuRole(): List<TabletMenuRoleEntity>?

    @Query("Delete from TabletMenuRole")
    fun deleteAllTabletMenuRole()

}