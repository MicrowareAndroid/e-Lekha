package com.psc.elekha.ui.screen.gtrlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.apicall.APiState
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btnYellow
import com.psc.elekha.ui.theme.homedatareportsColor
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.utils.*
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.back
import e_lekha.composeapp.generated.resources.download_loan
import e_lekha.composeapp.generated.resources.gtr_select
import e_lekha.composeapp.generated.resources.home_date
import e_lekha.composeapp.generated.resources.home_time
import e_lekha.composeapp.generated.resources.home_user
import e_lekha.composeapp.generated.resources.inter_medium
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun GtrListScreen(
    navController: NavHostController,
) {

    val viewModel = koinViewModel<GtrViewModel>()
    val downloadState = viewModel.downloadState.collectAsState().value
    var showProgress by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val branchList = listOf("All", "Center", "Village")
    var selectedBranch by remember { mutableStateOf("All") }
    var selectedScreen by remember { mutableStateOf("GTR List") }

    val duduCardList = listOf(
        GroupCardData(
            "D3140",
            8,
            "DUDU",
            "Rehman khan alwars",
            "12-19-2003",
            "04/12/25",
            "111(17)",
            "Monday",
            "09/12/25"
        ),
        GroupCardData(
            "D5140",
            10,
            "PPPU",
            "Ravi",
            "04/12/25",
            "13/05/25",
            "122(18)",
            "Wednesday",
            "04/12/24"
        ),
        GroupCardData(
            "D4169",
            7,
            "JJJU",
            "Ravi",
            "04/12/25",
            "07/08/16",
            "116(15)",
            "Thursday",
            "05/07/19"
        ),
        GroupCardData(
            "D5444",
            9,
            "JJJP",
            "Kailash",
            "04/12/25",
            "04/12/24",
            "119(14)",
            "Friday",
            "06/08/13"
        )
    )

    LaunchedEffect(Unit, downloadState) {
        when (downloadState) {
            is APiState.loading -> {
                showProgress = true
                dialogMessage = "Please wait..."
            }

            is APiState.success -> {
                showProgress = false

            }

            is APiState.error -> {
                showProgress = false
                showDialog = true
                dialogMessage = downloadState.message
            }

            is APiState.finish -> {
                showProgress = false
            }

            else -> {}
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ReusableTopBar(
                title = selectedScreen,
                navigationIcon = painterResource(Res.drawable.back),
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                onNavigationClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 0.dp, vertical = 0.dp)
            )
            {

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                )

                {

                    ReusableCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = text_fiiled_color,
                        cornerRadius = 0
                    )
                    {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {

                            // LEFT
                            Column(verticalArrangement = Arrangement.Center)
                            {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_user).plus(
                                            ":"
                                        ),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(
                                        text = "Vikash",
                                        textColor = black,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_time).plus(":"),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(
                                        text = "10:45 AM",
                                        textColor = black,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                            }

                            // RIGHT
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_date).plus(":"),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(
                                        text = "04/12/2025",
                                        textColor = black,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = Dimens.tendp)
                    )
                    {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {

                            ReusableTextView(
                                text = stringResource(Res.string.gtr_select),
                                textColor = Color.Black
                            )

                            FillDynamicSpinner(
                                label = "",
                                options = branchList.mapIndexed { index, name ->
                                    BranchItem(index + 1, name)
                                },
                                selectedOption = branchList.indexOf(selectedBranch) + 1,
                                onOptionSelected = { id ->
//                                    selectedBranch = branchList[id - 1]
                                    selectedBranch = if (id == 0) {
                                        ""
                                    } else {
                                        branchList.getOrNull(id - 1) ?: ""
                                    }
                                },
                                getOptionId = { it.id },
                                getOptionLabel = { it.name },
                                modifier = Modifier.width(160.dp)
                            )
                        }
                        Spacer(Modifier.height(Dimens.tendp))

                        Divider(color = LightSkyBlue, thickness = 1.dp)

                        Spacer(Modifier.height(Dimens.tendp))

                        Button(
                            onClick = {
                                viewModel.getGTRData("Bmggr", "9414258269", "623ED612-3764-40E2-88C7-5C1381EC5346", 340)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.sixteendp)
                                .width(200.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(3.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 6.dp,
                                focusedElevation = 4.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btnYellow,
                                contentColor = Color.White
                            )
                        ) {
                            ReusableTextView(
                                text = stringResource(Res.string.download_loan),
                                textColor = black,
                                fontSize = 20
                            )
                        }

                        Spacer(Modifier.height(Dimens.tendp))
                    }

                    Spacer(Modifier.height(2.dp))
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = Dimens.fivedp)
                    ) {

                        if (selectedBranch == "All") {
                            duduCardList.forEach { item ->
                                GroupCardUI(
                                    item = item,
                                    onCardClick = {
                                        navController.navigate(RouteName.gtr_list_data_screen)
                                    }
                                )
                            }
                            Spacer(Modifier.height(Dimens.tendp))
                        }
                    }
                }
            }
        }
    }

    if (showDialog) {
        CustomAlertDialog(
            showDialog,
            message = dialogMessage,
            onConfirm = { showDialog = false })
    }

    if (showProgress) {
        ProgressDialog(showProgress, dialogMessage)
    }
}

