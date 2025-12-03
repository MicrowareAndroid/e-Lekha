package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.roboto_medium
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.psc.elekha.ui.theme.editext_bg_color

@Composable
fun RepaymentItemCard(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }
    var selectedPaymentMode by remember { mutableStateOf("Select") }
    val paymentOptions = listOf("Cash", "Online", "UPI")

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = editext_bg_color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 7.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Checkbox
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onSelected() },
                modifier = Modifier.size(20.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF4CAF50),
                    uncheckedColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Customer Info
            Column(
                modifier = Modifier.width(85.dp),
                verticalArrangement = Arrangement.Center
            ) {
                ReusableTextView(
                    text = item.customerId,
                    fontSize = 15,
                    fontWeight = FontWeight.Bold,
                    textColor = Color(0xFF1976D2),
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
                ReusableTextView(
                    text = item.customerName,
                    fontSize = 12,
                    textColor = Color(0xFFFF7043),
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            // Loan Details
            Column(
                modifier = Modifier.width(90.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ReusableTextView(
                        text = "Loan:",
                        fontSize = 12,
                        textColor = Color.Black,
                        fontFamily = FontFamily(Font(Res.font.roboto_medium))
                    )
                    ReusableTextView(
                        text = item.loanAmount,
                        fontSize = 11,
                        textColor = Color.Black,
                        fontFamily = FontFamily(Font(Res.font.roboto_medium))
                    )
                }

                Spacer(modifier = Modifier.height(3.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    ReusableTextView(
                        text = "EMI ",
                        fontSize = 11,
                        textColor = Color.Black,
                        fontFamily = FontFamily(Font(Res.font.roboto_medium))
                    )
                    ReusableTextView(
                        text = item.emiAmount,
                        fontSize = 11,
                        fontWeight = FontWeight.Bold,
                        textColor = Color(0xFFFF7043),
                        fontFamily = FontFamily(Font(Res.font.roboto_medium))
                    )
                }
            }

            // Total Due
            Column(
                modifier = Modifier.width(75.dp),
                verticalArrangement = Arrangement.Center
            ) {
                ReusableTextView(
                    text = item.totalDue,
                    fontSize = 13,
                    fontWeight = FontWeight.Bold,
                    textColor = Color(0xFFE53935),
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )

                Spacer(modifier = Modifier.height(2.dp))

                ReusableTextView(
                    text = "Week(s): ${item.weeksInArrear}",
                    fontSize = 12,
                    textColor = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )
            }

            // Payment Mode + Camera icon
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                // Dropdown
                Box {
                    Button(
                        onClick = { showMenu = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBDEFB)),
                        shape = RoundedCornerShape(4.dp),
                        contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                        modifier = Modifier
                            .width(85.dp)
                            .height(20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ReusableTextView(
                                text = selectedPaymentMode,
                                fontSize = 12,
                                textColor = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.roboto_medium))
                            )
                            Text("▼", fontSize = 10.sp)
                        }
                    }

                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        paymentOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option, fontSize = 12.sp) },
                                onClick = {
                                    selectedPaymentMode = option
                                    showMenu = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                ReusableTextView(
                    text = "Total Repayment",
                    fontSize = 12,
                    textColor = Color.Gray,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                )

                Spacer(modifier = Modifier.height(2.dp))

                IconButton(
                    onClick = { /*camera click*/ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = "Camera",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
