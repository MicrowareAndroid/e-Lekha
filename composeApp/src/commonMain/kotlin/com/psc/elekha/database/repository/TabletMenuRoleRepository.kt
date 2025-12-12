package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.TabletMenuRoleDao
import com.psc.elekha.database.entity.TabletMenuRoleEntity

class TabletMenuRoleRepository(
    private val tabletMenuRoleDao: TabletMenuRoleDao
) {

    // Insert single tablet menu role
    suspend fun insertTabletMenuRole(item: TabletMenuRoleEntity) {
        tabletMenuRoleDao.insertTabletMenuRole(item)
    }

    // Insert list of tablet menu roles
    suspend fun insertAllTabletMenuRole(list: List<TabletMenuRoleEntity>) {
        tabletMenuRoleDao.insertAllTabletMenuRole(list)
    }

    // Get all tablet menu roles
    suspend fun getAllTabletMenuRole(): List<TabletMenuRoleEntity> {
        return tabletMenuRoleDao.getAllTabletMenuRole()
    }

    // Delete all tablet menu roles
    suspend fun deleteAllTabletMenuRole() {
        tabletMenuRoleDao.deleteAllTabletMenuRole()
    }
}
