package com.psc.elekha.ui.screen.navgraph

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.psc.elekha.ui.screen.customer.CustomerDetailScreen

import com.psc.elekha.ui.screen.repayment.RepaymentList

import com.psc.elekha.ui.screen.gtrlist.GtrListDataScreen
import com.psc.elekha.ui.screen.gtrlist.GtrListScreen
import com.psc.elekha.ui.screen.home.MainDrawerScreen
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.RouteName
import com.psc.elekha.ui.screen.login.LoginScreenNew
import com.psc.elekha.ui.screen.login.LoginViewModel
import com.psc.elekha.ui.screen.registrationlist.RegistrationListScreen
import com.psc.elekha.ui.screen.registrationtab.RegistartionTabScreen
import com.psc.elekha.ui.screen.repayment.LocationFilterScreen
import com.psc.elekha.ui.screen.repayment.RepaymentDialog
import com.psc.elekha.ui.screen.splash.SplashScreenNew
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    navController: NavHostController,
    appPreferences: AppPreferences
) {
    NavHost(
        navController = navController,
        startDestination = RouteName.splash
    ) {


        // SPLASH
        composable(RouteName.splash) {
            SplashScreenNew(navController)
        }

        // LOGIN
        composable(RouteName.login) {
            LoginScreenNew(navController)
        }

        // HOME
        composable(RouteName.home) {
            MainDrawerScreen(navController)
        }

        // GTR LIST
        composable(RouteName.gtr_list_screen) {
            GtrListScreen(navController)
        }

        // GTR LIST DATA
        composable(RouteName.gtr_list_data_screen) {
            GtrListDataScreen(navController)
        }

        // REGISTRATION TABS
        composable(RouteName.registration_tabs) {
            RegistartionTabScreen(navController, appPreferences)
        }

        composable(RouteName.customer_detail_screen) {
            CustomerDetailScreen(navController,)
        }



        // If needed later: (removed duplicate / commented clutter)
        /*
        composable(RouteName.case_tabs) {
            CaseTabScreen(navController, appPreferences)
        }

        composable(RouteName.sync) {
            SyncScreen(navController)
        }
        */
        composable(RouteName.splash) {
//            SplashScreen(navController)
            SplashScreenNew(navController)
        }

        composable(RouteName.login) {
//            LoginScreen(navController)
            LoginScreenNew(navController)
        }

        composable(RouteName.home) {
            MainDrawerScreen(navController)
        }

        composable(RouteName.gtr_list_screen) {
            GtrListScreen(navController)
        }

        composable(RouteName.gtr_list_data_screen) {
            GtrListDataScreen(navController)
        }

        composable(RouteName.registration_tabs) {
            RegistartionTabScreen(navController, appPreferences)
        }

        composable(RouteName.registration_list) {
            RegistrationListScreen(navController)
        }

        composable(RouteName.replayment_list) {
            RepaymentList(navController)
        }
        composable(RouteName.loan_filter_screen) {
            LocationFilterScreen(navController)
        }
        composable(RouteName.replayment_detail_list) {
            RepaymentDialog(navController)
        }

    }
}
