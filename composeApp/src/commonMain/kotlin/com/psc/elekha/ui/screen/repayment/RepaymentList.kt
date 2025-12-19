package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import androidx.compose.ui.unit.sp

import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.LightMint
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.LightTeal
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.toolbar_color
import org.jetbrains.compose.resources.stringResource

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import com.psc.elekha.ui.screen.home.HomeScreen
import com.psc.elekha.ui.theme.homedatareportsColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepaymentList(
    navController: NavHostController,
) {
    var select by remember { mutableStateOf("Repayment List") }
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var showFilterDialog by remember { mutableStateOf(false) }
    var selectedDialogItem by remember { mutableStateOf<RepaymentItem?>(null) }

    val sampleRepaymentList = listOf(
        RepaymentItem(
            "BHK03.123",
            "MEENA W/O Kailash chand",
            "1,00,000",
            "5300",
            "10,600",
            "4",
            true,
            "17",
            "12/05/2020",
            "6500",
            "5500",
            "4700",
            "7834456567"
        ),
        RepaymentItem(
            "BHK03.234",
            "SUNITA W/O Mahesh",
            "75,000",
            "3200",
            "8,200",
            "3",
            true,
            "15",
            "14/05/2019",
            "4000",
            "4500",
            "3500",
            "9588543364"
        ),
        RepaymentItem(
            "BHK03.345",
            "PRIYA D/O Suresh",
            "50,000",
            "2500",
            "5,000",
            "2",
            true,
            "14",
            "15/06/2020",
            "5000",
            "3000",
            "2300",
            "6733559874"
        ),
        RepaymentItem(
            "BHK03.456",
            "REKHA W/O Ajay",
            "60,000",
            "2800",
            "4,000",
            "1",
            false,
            "18",
            "17/12/2020",
            "6000",
            "3400",
            "2400",
            "7465002358"
        ),
        RepaymentItem(
            "BHK03.567",
            "KAVITA W/O waju",
            "90,000",
            "4100",
            "9,200",
            "5",
            false,
            "20",
            "20/12/2019",
            "6000",
            "3300",
            "2400",
            "7958443364"
        )
    )




    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            ReusableTopBar(
                title = select,
                navigationIcon = painterResource(Res.drawable.ic_back),
                onNavigationClick = { navController.popBackStack() }
            )
        },
        /* bottomBar = {
              CommonSingleButtonsBottomString(
                  onOkClick = {},
                  text = stringResource(Res.string.gtr_save),
                  textSize = 16,
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp)
                      .navigationBarsPadding()
              )
          }*/

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
                        .padding(horizontal = 12.dp)
                ) {

                    ReusableCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                        backgroundColor = homedatareportsColor,
                        cornerRadius = 12
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
                                        text = stringResource(Res.string.select_customer_center).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Gurgaon", textColor = Color.Black)
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.select_customer_next).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10/4/2025", textColor = Color.Black)
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
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "Vikash", textColor = Color.Black)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_time).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "10:45 AM", textColor = Color.Black)
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    ReusableTextView(
                                        text = stringResource(Res.string.home_date).plus(":"),
                                        textColor = toolbar_color
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    ReusableTextView(text = "04/12/2025", textColor = Color.Black)
                                }
                            }
                        }
                    }


                    CollectionDetailsCard(
                        items = sampleRepaymentList,
                        selectedItems = selectedItems,
                        onItemSelected = { index ->
                            selectedItems = if (selectedItems.contains(index)) {
                                selectedItems - index
                            } else {
                                selectedItems + index
                            }


                            selectedDialogItem = sampleRepaymentList[index]
                        },
                        onFilterClick = { showFilterDialog = true },
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 45.dp)
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
                        textSize = 16,


                        )
                }


            }
        }
        if (showFilterDialog) {
            FilterLoanDetailsDialog(
                onDismiss = { showFilterDialog = false },
                onApplyFilter = { village, center, customerId ->
                    // Handle filter application here
                    // Filter your repaymentItems based on these values
                    showFilterDialog = false
                }
            )
        }


    }
    selectedDialogItem?.let { item ->
        Dialog(
            onDismissRequest = { selectedDialogItem = null }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                RepaymentDialog(
                    item = item,
                    isSelected = true,
                    onSelected = {
                        selectedDialogItem = null
                    },
                    onCameraClick = {
                        // camera logic yahan
                    },
                    onBack = {
                        selectedDialogItem = null
                    }
                )

            }
        }
    }


}


@Composable
fun CollectionDetailsCard(
    items: List<RepaymentItem>,
    selectedItems: Set<Int>,
    onItemSelected: (Int) -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Header with Filter Icon
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
                fontFamily = FontFamily(Font(Res.font.roboto_medium))
            )

            IconButton(onClick = onFilterClick) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        }

        Spacer(Modifier.height(10.dp))
        HorizontalDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)
        Spacer(Modifier.height(10.dp))

        // List Items
        LazyColumn {
            items(items.size) { index ->
                RepaymentItemCard(
                    item = items[index],
                    isSelected = selectedItems.contains(index),
                    onSelected = { onItemSelected(index) }
                )

                if (index < items.size - 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

    }
}

@Composable
fun FilterLoanDetailsDialog(
    onDismiss: () -> Unit,
    onApplyFilter: (village: String?, center: String?, customerId: String?) -> Unit
) {
    var selectedVillage by remember { mutableStateOf("") }
    var selectedCenter by remember { mutableStateOf("") }
    var customerId by remember { mutableStateOf("") }

    // Sample data - replace with actual data
    val villages = listOf("Village 1", "Village 2", "Village 3", "Village 4")
    val centers = listOf("Center A", "Center B", "Center C", "Center D")
    var customerIds by remember { mutableStateOf("") }
    val select = stringResource(Res.string.spinner_select)

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color.White,

        title = {
            Column {
                ReusableTextView(
                    text = stringResource(Res.string.select_customer_filter_details).plus(":"),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20,
                    textColor = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                CommonDivider(color = LightSkyBlue, thickness = 1.dp)
            }
        },

        text = {
            Column(
                modifier = Modifier
                    .width(320.dp)     // <-- THIS MAKES DIALOG SMALL
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                FormSpinner(
                    label = stringResource(Res.string.village),
                    options = villages,
                    selectedOption = selectedVillage,
                    onOptionSelected = { selectedVillage = it },
                )

                CommonDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)

                FormSpinner(
                    label = stringResource(Res.string.select_center),
                    options = centers,
                    selectedOption = selectedCenter,
                    onOptionSelected = { selectedCenter = it }
                )

                ReusableTextView(
                    text = stringResource(Res.string.select_customer_center_or),
                    fontSize = 16,
                    fontWeight = FontWeight.Bold,
                    textColor = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlignment = androidx.compose.ui.text.style.TextAlign.Center
                )

                FormFieldCompact(
                    label = stringResource(Res.string.select_customer_id),
                    value = customerIds,
                    onValueChange = { customerIds = it },
                    placeholder = stringResource(Res.string.type_here)
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onDismiss,
                        shape=RoundedCornerShape(0.dp),
                        modifier = Modifier.weight(1f).height(45.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 6.dp,
                            focusedElevation = 4.dp
                        )
                    ) { Text(stringResource(Res.string.cancel)) }

                    Button(
                        onClick = {
                            onApplyFilter(
                                selectedVillage.takeIf { it.isNotEmpty() && it != select },
                                selectedCenter.takeIf { it.isNotEmpty() && it != select },
                                customerId.ifEmpty { null }
                            )
                        },
                        modifier = Modifier.weight(1f).height(45.dp),
                        shape=RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = btn_color),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 4.dp,
                            pressedElevation = 6.dp,
                            focusedElevation = 4.dp
                        )
                    ) { Text(stringResource(Res.string.select_customer_filter)) }
                }
            }
        },

        confirmButton = {},
        dismissButton = {}
    )

}
@Preview
@Composable
fun RepaymentList() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController(),
            onMenuClick = {}
        )
    }
}