package com.psc.elekha.ui.screen.repayment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.psc.elekha.utils.ReusableTopBar
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.background
import e_lekha.composeapp.generated.resources.ic_back
import e_lekha.composeapp.generated.resources.roboto_medium
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import com.psc.elekha.ui.screen.repayment.model.sampleRepaymentList
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.btn_color
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepaymentList(
    navController: NavHostController,
) {
    var select by remember { mutableStateOf("Repayment List") }
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    val repaymentItems = sampleRepaymentList

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.background),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        // Content
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
                BottomCollectionBar(
                    selectedCount = selectedItems.size,
                    totalItems = repaymentItems.size,
                    onSubmit = { /* Submit functionality */ }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(12.dp)
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
                    items = repaymentItems,
                    selectedItems = selectedItems,
                    onItemSelected = { index ->
                        selectedItems = if (selectedItems.contains(index)) {
                            selectedItems - index
                        } else {
                            selectedItems + index
                        }
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
    onItemSelected: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        ReusableTextView(
            text = "Collection Details :",
            fontSize = 18,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(12.dp),
            textColor = Color.Black,
            fontFamily = FontFamily(Font(Res.font.roboto_medium))
        )

        // Table Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF8F8F8))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.width(32.dp))

            Box(modifier = Modifier.width(85.dp)) {
                ReusableTextView(
                    text = "Customer",
                    fontWeight = FontWeight.Medium,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            Box(modifier = Modifier.width(90.dp)) {
                ReusableTextView(
                    text = "Loan Details",
                    fontWeight = FontWeight.Medium,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            Box(modifier = Modifier.width(75.dp)) {
                ReusableTextView(
                    text = "Total Due",
                    fontWeight = FontWeight.Medium,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                ReusableTextView(
                    text = "Payment",
                    fontWeight = FontWeight.Medium,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }
        }

        HorizontalDivider(color = Color(0xFFE0E0E0), thickness = 1.dp)
   Spacer(
       Modifier.height(10.dp)
   )
        // List Items
        LazyColumn(modifier = Modifier.weight(1f)) {
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
fun BottomCollectionBar(
    selectedCount: Int,
    totalItems: Int,
    onSubmit: () -> Unit
) {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                ReusableTextView(
                    text = "Collections $selectedCount/5",
                    fontSize = 11,
                    textColor = Color.Gray,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
                ReusableTextView(
                    text = "Total Collection: $selectedCount",
                    fontWeight = FontWeight.Bold,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            Button(
                onClick = onSubmit,
                colors = ButtonDefaults.buttonColors(
                    containerColor = btn_color,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(110.dp)
                    .height(45.dp)
            ) {
                ReusableTextView(
                    text = "SUBMIT",
                    fontSize = 13,
                    fontWeight = FontWeight.Bold,
                    textColor = Color.White,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }
        }
    }
}