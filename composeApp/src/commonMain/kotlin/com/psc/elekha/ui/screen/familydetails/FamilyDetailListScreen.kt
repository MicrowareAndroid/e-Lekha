package com.psc.elekha.ui.screen.familydetails

import androidx.compose.foundation.Image
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
import com.psc.elekha.model.FamilyDetailModel
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
fun FamilyDetailListScreen(
    onNextTab: () -> Unit = {},
    onCancelTab: () -> Unit = {},
    navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }

    var familyDetailModel by rememberSaveable {
        mutableStateOf(
            listOf(
                FamilyDetailModel(
                    "Test",
                    "Brother",
                    "Graduate",
                    "Teacher"
                ),
                FamilyDetailModel(
                    "XYZ",
                    "Sister",
                    "PostGraduate",
                    "Doctor"
                ),
                FamilyDetailModel("ABC", "Father", "12th", "Driver")
            )
        )
    }

    /*Box(
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
            )*/

            Box(
                modifier = Modifier
                    .fillMaxSize()
            )
            {

                /*Image(
                    painter = painterResource(Res.drawable.background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),    // THIS is enough
                    contentScale = ContentScale.Crop
                )*/

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(/*horizontal = 16.dp, */vertical = 8.dp)
                ) {
                    items(familyDetailModel) { item ->
                        FamilyDetailCard(
                            familyDetailModel = item,
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

                //just icon
                FloatingActionButton(
                    onClick = {
                        navController.navigate(RouteName.family_detail_form_screen)
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
        }
    /*}

}*/