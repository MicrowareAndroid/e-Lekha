package com.psc.elekha.ui.screen.registrationlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.psc.elekha.database.viewmodel.CustomerViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.model.RegistrationModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.AppSP
import com.psc.elekha.utils.CustomAlertDialogRegistrationExisting
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.RouteName
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add
import e_lekha.composeapp.generated.resources.background
import e_lekha.composeapp.generated.resources.ic_add
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.list
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RegistrationListScreen(navController: NavController) {

    val viewModel = koinViewModel<CustomerViewModel>()
    var mstComboViewModel=koinViewModel<MSTComboBox_NViewModel>()
    var uploadViewmodel=koinViewModel<RegistrationUploadViewModel>()
    var showDialog by remember { mutableStateOf(false) }
    val customerList by viewModel.customers.collectAsState()
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(Unit) {
        viewModel.loadCustomers()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ReusableTopBar(
                title = stringResource(Res.string.list),
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = {
                    navController.popBackStack()
                }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(customerList) { item ->
                        RegistrationCard(
                            customer = item,
                            onEdit = {
                                appPreferences.putString(AppSP.customerGuid, item.GUID)
                                navController.navigate(RouteName.registration_tabs)
                            },
                            onDelete = {

                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

                FloatingActionButton(
                    onClick = {
                        showDialog = true
                    },
                    containerColor = btn_color,
                    shape = CircleShape,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(18.dp)
                        .border(
                            width = 1.dp,
                            color = btn_color,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_add),
                        contentDescription = stringResource(Res.string.add),
                        tint = black
                    )
                }
            }
            if (showDialog) {
                CustomAlertDialogRegistrationExisting(
                    onRegistration = {
                        appPreferences.putString(AppSP.customerGuid, "")
                        appPreferences.putString(AppSP.FamilyMemberGuid, "")
                        appPreferences.putString(AppSP.MovableAssetsGuid, "")
                        navController.navigate(RouteName.registration_tabs)
                        showDialog = false
                    },
                    onExitsing = {
                        uploadViewmodel.uploadRegistrationData()
                        navController.navigate(RouteName.registration_tabs)
                        showDialog = false
                    },
                    onBack = {
                        showDialog = false
                    }
                )
            }
        }
    }

}