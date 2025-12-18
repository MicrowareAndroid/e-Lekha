package com.psc.elekha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.psc.elekha.MyApp.Companion.appPreferences
import com.psc.elekha.application.ELekhaApplication
import com.psc.elekha.expectfile.PermissionManager
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.setActivityProvider

class MainActivity : ComponentActivity() {
    private lateinit var permissionManager: PermissionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val appPreferences = AppPreferences(applicationContext)
        permissionManager = PermissionManager(this)

        setActivityProvider { this }

        setContent {
            ELekhaApplication(appPreferences, permissionManager)
        }
    }


}

/*
@Preview
@Composable
fun AppAndroidPreview() {
    ELekhaApplication(appPreferences)
}*/