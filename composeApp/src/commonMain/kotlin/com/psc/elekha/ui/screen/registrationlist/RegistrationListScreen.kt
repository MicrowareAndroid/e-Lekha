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
import com.psc.elekha.model.RegistrationModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
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

@Composable
fun RegistrationListScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    var registrationModel by rememberSaveable {
        mutableStateOf(
            listOf(
                RegistrationModel(
                    "Test",
                    "9999999911",
                    "Married"
                ),
                RegistrationModel(
                    "XYZ",
                    "8899889988",
                    "Single"
                ),
                RegistrationModel("ABC", "7711778866", "Divorced")
            )
        )
    }

    /*Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding().background(white)
    ) {*/

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
                    items(registrationModel) { item ->
                        RegistrationCard(
                            registrationModel = item,
                            onEdit = {
                                /*edit click listener here*/
                            },
                            onDelete = {
                                /*delete code goes here*/
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }

                //icon with text
                /*ExtendedFloatingActionButton(
                    onClick = {
                        navController.navigate(RouteName.registration_tabs)
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
                        ),
                    icon = {
                        Icon(
                            painter = painterResource(Res.drawable.addicon),
                            contentDescription = stringResource(Res.string.add),
                            tint = black
                        )
                    },
                    text = {
                        ReusableTextView(
                            text = stringResource(Res.string.add),
                            textColor = black,
                            fontWeight = FontWeight.W500
                        )
                    }
                )*/

                //just icon
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
                        navController.navigate(RouteName.registration_tabs)
                        showDialog = false
                    },
                    onExitsing = {
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