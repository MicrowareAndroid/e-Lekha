package com.psc.elekha.database.repository

import com.psc.elekha.database.dao.TabletMenuDao
import com.psc.elekha.database.entity.TabletMenuEntity

class TabletMenuRepository(
    private val tabletMenuDao: TabletMenuDao
) {

    // Insert single tablet menu item
    suspend fun insertTabletMenu(item: TabletMenuEntity) {
        tabletMenuDao.insertTabletMenu(item)
    }

    // Insert list of tablet menu items
    suspend fun insertAllTabletMenu(list: List<TabletMenuEntity>) {
        tabletMenuDao.insertAllTabletMenu(list)
    }

    // Get all tablet menu items
    suspend fun getAllTabletMenu(): List<TabletMenuEntity> {
        return tabletMenuDao.getAllTabletMenu()
    }

    // Delete all tablet menu items
    suspend fun deleteAllTabletMenu() {
        tabletMenuDao.deleteAllTabletMenu()
    }
}
