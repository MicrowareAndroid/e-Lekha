package com.psc.elekha.ui.screen.repayment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.Uri
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.utils.CameraPreviewField
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import com.psc.elekha.utils.ReusablePaymentDropdown
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.user_default

@Composable
fun RepaymentItemCard(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit,
    onCameraClick: () -> Unit = {},
) {
    var showMenu by remember { mutableStateOf(false) }
    var selectedPaymentMode by remember { mutableStateOf("Select") }
    val paymentOptions = listOf("Cash", "Online", "UPI")
    var repaymentAmount by remember { mutableStateOf("") }
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = editext_bg_color),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
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
                modifier = Modifier
                    .size(20.dp)
                    .padding(top = 4.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF4CAF50),
                    uncheckedColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            // LEFT SIDE CONTENT
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // ---------- FIRST ROW ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("Customer")
                    Spacer(Modifier.width(4.dp))
                    ReusableTextViewBlackCard(item.customerId)
                    ReusableTextViewBlackCard(item.customerName)

                    Spacer(modifier = Modifier.height(10.dp))
                }

                Spacer(modifier = Modifier.height(10.dp))

                // ---------- SECOND ROW (Loan Details) ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("Loan Amount")
                    ReusableTextViewBlackCard(item.loanAmount)
                    ReusableTextViewGrayCard("EMI")
                    ReusableTextViewBlackCard(item.emiAmount)
                }

                Spacer(modifier = Modifier.height(10.dp))

                // ---------- THIRD ROW (Total Due) ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("Total Due")
                    Spacer(Modifier.height(4.dp))
                    ReusableTextViewBlackCard(item.totalDue)

                    Spacer(modifier = Modifier.width(20.dp))
                    ReusableTextViewGrayCard("Weeks in Arrear")
                    Spacer(Modifier.height(4.dp))
                    ReusableTextViewBlackCard(item.weeksInArrear)
                }

                Spacer(modifier = Modifier.height(10.dp))

                // ---------- FOURTH ROW (Payment Mode & Repayment) ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ReusableTextViewGrayCard("Payment Mode")
                    Spacer(modifier = Modifier.width(3.dp))
                    ReusablePaymentDropdown(
                        selectedValue = selectedPaymentMode,
                        options = paymentOptions,
                        onValueSelected = { selectedPaymentMode = it },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))


                    OutlinedTextField(
                        value = repaymentAmount,
                        onValueChange = { repaymentAmount = it },
                        placeholder = { Text("Payment", fontSize = 10.sp) },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.LightGray,
                            unfocusedBorderColor = Color.Gray
                        ),
                        shape = RoundedCornerShape(4.dp),
                        textStyle = LocalTextStyle.current.copy(fontSize = 10.sp)
                    )

                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // RIGHT SIDE - IMAGE PREVIEW AND CAMERA BUTTON
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                // Image Preview
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.LightGray)
                )

                // Camera Icon Button
                IconButton(
                    onClick = onCameraClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = "Camera",
                        modifier = Modifier.size(30.dp),
                        tint = black
                    )
                }
            }
        }
    }
}