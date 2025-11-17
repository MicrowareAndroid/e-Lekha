package com.psc.elekha.ui.splashScreen

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
import com.psc.elekha.ui.theme.PrimaryColor
import com.psc.elekha.viewModels.SplashViewModel
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.logo
import e_lekha.composeapp.generated.resources.logo_psc
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(onFinished: () -> Unit, viewModel: SplashViewModel = SplashViewModel()) {
    val finished by viewModel.finished.collectAsState()

    LaunchedEffect(finished) {
        if (finished) onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
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