package com.psc.elekha.application

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.expectfile.PermissionManager
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.ui.screen.navgraph.AppNavGraph
import com.psc.elekha.ui.theme.GBVTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ELekhaApplication(appPreferences: AppPreferences,permissions: PermissionManager) {

    GBVTheme(false) {

        val navController = rememberNavController()
        Surface(color = MaterialTheme.colorScheme.background){
            AppNavGraph(
                navController,
                appPreferences
            )
        }
    }
}