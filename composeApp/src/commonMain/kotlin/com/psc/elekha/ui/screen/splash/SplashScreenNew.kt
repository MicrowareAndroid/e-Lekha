package com.psc.elekha.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.psc.elekha.database.viewmodel.UsersViewModel
import com.psc.elekha.utils.RouteName
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreenNew(navController: NavController) {
    val viewModel = koinViewModel<UsersViewModel>()
    val userList by viewModel.userList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAllUsers()
        delay(5000)
        if (userList.isNotEmpty()) {
            navController.navigate(RouteName.home) {
                popUpTo(RouteName.splash) { inclusive = true }
            }
        } else {
            navController.navigate(RouteName.login) {
                popUpTo(RouteName.splash) { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
        )
    }
}