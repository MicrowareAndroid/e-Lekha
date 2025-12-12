package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.TabletMenuEntity
import com.psc.elekha.database.repository.TabletMenuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TabletMenuViewModel(
    private val repository: TabletMenuRepository
) : ViewModel() {

    private val _tabletMenuList = MutableStateFlow<List<TabletMenuEntity>>(emptyList())
    val tabletMenuList: StateFlow<List<TabletMenuEntity>> = _tabletMenuList

    // Load all tablet menu items
    fun loadAllTabletMenu() {
        viewModelScope.launch {
            val result = repository.getAllTabletMenu()
            _tabletMenuList.value = result
        }
    }

    // Insert single tablet menu item
    fun insertTabletMenu(item: TabletMenuEntity) {
        viewModelScope.launch {
            repository.insertTabletMenu(item)
            loadAllTabletMenu() // Refresh list
        }
    }

    // Insert list of tablet menu items
    fun insertAllTabletMenu(list: List<TabletMenuEntity>) {
        viewModelScope.launch {
            repository.insertAllTabletMenu(list)
            loadAllTabletMenu() // Refresh list
        }
    }

    // Delete all tablet menu items
    fun deleteAllTabletMenu() {
        viewModelScope.launch {
            repository.deleteAllTabletMenu()
            _tabletMenuList.value = emptyList()
        }
    }
}
