package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.psc.elekha.utils.*
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import com.psc.elekha.ui.theme.btn_color
import org.jetbrains.compose.resources.stringResource
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.database.entity.LoanRepaymentEntity
import com.psc.elekha.database.viewmodel.LoanRepaymentViewModel
import com.psc.elekha.expectfile.AppBackHandler
import com.psc.elekha.ui.theme.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepaymentList(
    navController: NavHostController,
) {

    AppBackHandler{
        navController.navigate(RouteName.loan_filter_screen) {
            popUpTo(RouteName.replayment_list) { inclusive = true }
            launchSingleTop = true
        }
    }

    val viewModel = koinViewModel<LoanRepaymentViewModel>()
    var select by remember { mutableStateOf("Repayment List") }
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var selectedDialogItem by remember { mutableStateOf<LoanRepaymentEntity?>(null) }
    val repaymentList by viewModel.allLoanRepayments.collectAsState()
    val appPreferences: AppPreferences = koinInject()

    LaunchedEffect(Unit) {
        viewModel.loadAllLoanRepayment()

    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            ReusableTopBar(
                title = select,
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = {
                    navController.navigate(RouteName.loan_filter_screen) {
                        popUpTo(RouteName.replayment_list) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        },

    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

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
                                        text = stringResource(Res.string.select_customer_center).plus(
                                            ":"
                                        ),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Gurgaon", textColor = black, fontWeight = FontWeight.Bold)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.select_customer_next).plus(
                                            ":"
                                        ),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10/4/2025", textColor = black, fontWeight = FontWeight.Bold)
                                }
                            }

                            // RIGHT
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_user),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Vikash", textColor = black, fontWeight = FontWeight.Bold)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_time).plus(":"),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10:45 AM", textColor = black, fontWeight = FontWeight.Bold)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_date).plus(":"),
                                        textColor = appleblue, fontWeight = FontWeight.Bold
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "04/12/2025", textColor = black, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }


                    CollectionDetailsCard(
                        items = repaymentList,
                        selectedItems = selectedItems,
                        onItemSelected = { index ->
                            selectedItems = if (selectedItems.contains(index)) {
                                selectedItems - index
                            } else {
                                selectedItems + index
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 45.dp),
                        onCardClicked = { index ->
                            selectedDialogItem = repaymentList[index]
                        }
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 5.dp)
                        .align(Alignment.BottomCenter)

                ) {
                    CommonSingleButtonsBottomString(
                        onOkClick = {},
                        text = stringResource(Res.string.gtr_save),
                        textSize = 16)
                }


            }
        }
    }
    selectedDialogItem?.let { item ->
        appPreferences.putString(AppSP.LoanRepaymentGUID,item.GUID)
        navController.navigate(RouteName.replayment_detail_list) {
            popUpTo(RouteName.replayment_list) { inclusive = true }
            launchSingleTop = true
        }
    }

}


@Composable
fun CollectionDetailsCard(
    items: List<LoanRepaymentEntity>,
    selectedItems: Set<Int>,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onCardClicked: (Int) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ReusableTextView(
                text = stringResource(Res.string.select_customer_collection).plus(":"),
                fontSize = 18,
                fontWeight = FontWeight.SemiBold,
                textColor = Color.Black,
                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
            )
        }

        Spacer(Modifier.height(10.dp))
        HorizontalDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)
        Spacer(Modifier.height(10.dp))

        LazyColumn {
            items(items.size) { index ->
                RepaymentItemCard(
                    item = items[index],
                    isSelected = selectedItems.contains(index),
                    onSelected = { onItemSelected(index) },
                    onClicked = { onCardClicked(index) }
                )

                if (index < items.size - 1) {
                    Spacer(modifier = Modifier.height(Dimens.tendp))
                }
            }
        }
    }
}

@Preview
@Composable
fun RepaymentList() {
    MaterialTheme {
        RepaymentList(navController = rememberNavController())
    }
}