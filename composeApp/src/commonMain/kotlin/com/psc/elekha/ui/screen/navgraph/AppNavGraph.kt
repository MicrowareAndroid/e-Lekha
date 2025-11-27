package com.psc.elekha.ui.screen.navgraph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.RouteName
import com.psc.elekha.ui.screen.login.LoginScreen
import com.psc.elekha.ui.screen.login.LoginScreenNew
import com.psc.elekha.ui.screen.splash.SplashScreen
import com.psc.elekha.ui.screen.splash.SplashScreenNew

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(navController: NavHostController, appPreferences: AppPreferences) {

    NavHost(
        navController = navController,
        startDestination = RouteName.splash
    ) {
        composable(RouteName.splash){
//            SplashScreen(navController)
            SplashScreenNew(navController)
        }

        composable(RouteName.login){
//            LoginScreen(navController)
            LoginScreenNew(navController)
        }

        /*composable(RouteName.home){
            MainDrawerScreen( navController,appPreferences)
        }

        composable(RouteName.make_list_complaint) {
            ComplaintListScreen(navController)
        }

        composable(RouteName.follow_status_complaint) {
            FollowupScreen(navController)
        }

        composable(RouteName.case_tabs) {
            CaseTabScreen(navController,appPreferences)
        }

        composable(RouteName.sync) {
            SyncScreen(navController)
        }*/






    }
}

