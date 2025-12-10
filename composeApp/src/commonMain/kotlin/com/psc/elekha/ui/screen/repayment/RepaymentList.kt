package com.psc.elekha.ui.screen.repayment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
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
import com.psc.elekha.ui.theme.btn_color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepaymentList(
    navController: NavHostController,
) {
    var select by remember { mutableStateOf("Repayment List") }
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var showFilterDialog by remember { mutableStateOf(false) }
    val sampleRepaymentList = listOf(
        RepaymentItem("BHK03.123", "MEENA W/O Kailash chand", "1,00,000", "5300", "10,600", "4", true),
        RepaymentItem("BHK03.234", "SUNITA W/O Mahesh", "75,000", "3200", "8,200", "3", true),
        RepaymentItem("BHK03.345", "PRIYA D/O Suresh", "50,000", "2500", "5,000", "2", true),
        RepaymentItem("BHK03.456", "REKHA W/O Ajay", "60,000", "2800", "4,000", "1", false),
        RepaymentItem("BHK03.567", "KAVITA W/O waju", "90,000", "4100", "9,200", "5", false)
    )




        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                ReusableTopBar(
                    title = select,
                    navigationIcon = painterResource(Res.drawable.ic_back),
                    onNavigationClick = { navController.popBackStack() }
                )
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                        .navigationBarsPadding()
                ) {
                    CommonSingleButtonsBottomString(
                        onOkClick = {

                        },
                        "Submit",
                        textSize = 16
                    )
                    }
              }
        ) { innerPadding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
            {
                Image(
                    painter = painterResource(Res.drawable.background),
                    contentDescription = null,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                ) {
                    // Header Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Left Side
                        Column(verticalArrangement = Arrangement.Center) {
                            ReusableTextView(
                                text = "Center Name",
                                fontSize = 11,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                            ReusableTextView(
                                text = "Next Emi Date",
                                fontSize = 11,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                            ReusableTextView(
                                text = "16/04/2025",
                                fontSize = 11,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                        }

                        // Right Side
                        Column(horizontalAlignment = Alignment.End) {
                            ReusableTextView(
                                text = "Username",
                                fontSize = 13,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                            ReusableTextView(
                                text = "Time",
                                fontSize = 13,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                            ReusableTextView(
                                text = "Day and Date",
                                fontSize = 13,
                                fontWeight = FontWeight.Medium,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
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
                        },
                        onFilterClick = { showFilterDialog = true },
                        modifier = Modifier
                            .weight(1f)

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
                text = "Collection Details :",
                fontSize = 18,
                fontWeight = FontWeight.SemiBold,
                textColor = Color.Black,
                fontFamily = FontFamily(Font(Res.font.roboto_medium))
            )

            IconButton(onClick = onFilterClick) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filter",
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

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color.White,
        title = {
            Column {
                ReusableTextView(
                    text = "Filter Loan Details",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20,
                    textColor = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                CommonDivider(
                    color = Color(0xFFE0E0E0),
                    thickness = 1.dp
                )
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Village Dropdown
                FormSpinner(
                    label = "Village:",
                    options = villages,
                    selectedOption = selectedVillage,
                    onOptionSelected = { selectedVillage = it },
                    modifier = Modifier.fillMaxWidth()
                )

                CommonDivider(
                    color = Color(0xFFE0E0E0),
                    thickness = 1.dp
                )

                // Center Dropdown
                FormSpinner(
                    label = "Center :",
                    options = centers,
                    selectedOption = selectedCenter,
                    onOptionSelected = { selectedCenter = it },
                    modifier = Modifier.fillMaxWidth()
                )

                // OR Text
                ReusableTextView(
                    text = "OR",
                    fontSize = 16,
                    fontWeight = FontWeight.Bold,
                    textColor = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlignment = androidx.compose.ui.text.style.TextAlign.Center
                )

                // Customer ID Field
                FormField(
                    label = "Customer ID :",
                    value = customerId,
                    onValueChange = { customerId = it },
                    placeholder = "BHK.",
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Cancel and Filter Buttons Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Cancel Button
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Cancel",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }

                    // Filter Button
                    Button(
                        onClick = {
                            onApplyFilter(
                                selectedVillage.takeIf { it.isNotEmpty() && it != "Select" },
                                selectedCenter.takeIf { it.isNotEmpty() && it != "Select" },
                                customerId.ifEmpty { null }
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = btn_color
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Filter",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }
            }
        },
        confirmButton = {},
        dismissButton = {}
    )
}