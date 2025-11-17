package com.psc.elekha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.psc.elekha.ui.login.LoginScreen
import com.psc.elekha.ui.splashScreen.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
//            App()
            var showSplash by remember { mutableStateOf(true) }

            if (showSplash) {
                SplashScreen(
                    onFinished = { showSplash = false }
                )
            } else {
                LoginScreen()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    App()
    LoginScreen()
}