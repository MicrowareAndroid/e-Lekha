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
import com.psc.elekha.MyApp.Companion.appPreferences
import com.psc.elekha.application.ELekhaApplication
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.setActivityProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val appPreferences = AppPreferences(applicationContext)


        setActivityProvider { this }

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
            ELekhaApplication(appPreferences)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
//    App()
    LoginScreen()
    ELekhaApplication(appPreferences)
}