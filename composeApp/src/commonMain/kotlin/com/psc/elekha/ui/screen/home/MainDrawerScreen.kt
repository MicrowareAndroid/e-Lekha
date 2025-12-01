package com.psc.elekha.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import e_lekha.composeapp.generated.resources.background_drawer
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController

import e_lekha.composeapp.generated.resources.Res


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDrawerScreen(navController: NavHostController) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = Color(0x80000000),
        drawerContent = {

            ModalDrawerSheet(
                drawerContainerColor = Color.White,
                modifier = Modifier.fillMaxHeight().width(310.dp)

            ) {
                DrawerContent()
            }
        }
    ) {


        Box(modifier = Modifier.fillMaxSize()) {

            HomeScreen(
                navController = navController,
                onMenuClick = { scope.launch { drawerState.open() } }
            )
        }
    }
}
