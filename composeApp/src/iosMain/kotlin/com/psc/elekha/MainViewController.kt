package com.psc.elekha

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.ComposeUIViewController
import com.psc.elekha.ui.login.LoginScreen
import com.psc.elekha.ui.splashScreen.SplashScreen

fun MainViewController() = ComposeUIViewController {
//    App()
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        SplashScreen(
            onFinished = { showSplash = false }
        )
    } else {
        LoginScreen()
    }
}