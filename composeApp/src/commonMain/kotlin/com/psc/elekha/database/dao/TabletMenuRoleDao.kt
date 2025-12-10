package com.psc.elekha.database.dao

import androidx.room.*
import com.psc.elekha.database.entity.TabletMenuRoleEntity

@Dao
interface TabletMenuRoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTabletMenuRole(tabletMenuRoleEntity: TabletMenuRoleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertAllTabletMenuRole(tabletMenuRoleEntity: List<TabletMenuRoleEntity>?)

    @Query("Select * from TabletMenuRole")
    suspend fun getAllTabletMenuRole(): List<TabletMenuRoleEntity>?

    @Query("Delete from TabletMenuRole")
    suspend  fun deleteAllTabletMenuRole()

}