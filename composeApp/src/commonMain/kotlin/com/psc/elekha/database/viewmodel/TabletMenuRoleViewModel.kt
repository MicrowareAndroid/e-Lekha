package com.psc.elekha.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.database.entity.TabletMenuRoleEntity
import com.psc.elekha.database.repository.TabletMenuRoleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TabletMenuRoleViewModel(
    private val repository: TabletMenuRoleRepository
) : ViewModel() {

    private val _tabletMenuRoleList = MutableStateFlow<List<TabletMenuRoleEntity>>(emptyList())
    val tabletMenuRoleList: StateFlow<List<TabletMenuRoleEntity>> = _tabletMenuRoleList

    // Load all tablet menu roles
    fun loadAllTabletMenuRole() {
        viewModelScope.launch {
            val result = repository.getAllTabletMenuRole()
            _tabletMenuRoleList.value = result ?: emptyList()
        }
    }

    // Insert single tablet menu role
    fun insertTabletMenuRole(item: TabletMenuRoleEntity) {
        viewModelScope.launch {
            repository.insertTabletMenuRole(item)
            loadAllTabletMenuRole() // Refresh list
        }
    }

    // Insert list of tablet menu roles
    fun insertAllTabletMenuRole(list: List<TabletMenuRoleEntity>?) {
        viewModelScope.launch {
            repository.insertAllTabletMenuRole(list)
            loadAllTabletMenuRole() // Refresh list
        }
    }

    // Delete all tablet menu roles
    fun deleteAllTabletMenuRole() {
        viewModelScope.launch {
            repository.deleteAllTabletMenuRole()
            _tabletMenuRoleList.value = emptyList()
        }
    }
}
