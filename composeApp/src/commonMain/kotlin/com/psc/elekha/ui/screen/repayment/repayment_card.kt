package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.ReusableTextViewBlackCard
import com.psc.elekha.utils.ReusableTextViewGrayCard
import com.psc.elekha.utils.ReusablePaymentDropdown
import com.psc.elekha.utils.toPlatformImageBitmap

@Composable
fun RepaymentItemCard(
    item: RepaymentItem,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    var selectedPaymentMode by remember { mutableStateOf("Select") }
    val paymentOptions = listOf("Cash", "Online", "UPI")
    var repaymentAmount by remember { mutableStateOf("") }

    var openCamera by remember { mutableStateOf(false) }
    var capturedImage by remember { mutableStateOf<androidx.compose.ui.graphics.ImageBitmap?>(null) }

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = editext_bg_color),
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
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

            // LEFT SIDE
            Column(modifier = Modifier.weight(1f)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("Customer")
                    ReusableTextViewBlackCard(item.customerId)
                    ReusableTextViewBlackCard(item.customerName)
                }

                Spacer(modifier = Modifier.height(10.dp))

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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ReusableTextViewGrayCard("Total Due")
                    ReusableTextViewBlackCard(item.totalDue)

                    ReusableTextViewGrayCard("Weeks in Arrear")
                    ReusableTextViewBlackCard(item.weeksInArrear)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    ReusableTextViewGrayCard("Payment Mode")

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
                        modifier = Modifier.weight(1f).height(50.dp),
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


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.width(80.dp)
            ) {


                Box(
                    modifier = Modifier.size(100.dp).background(Color.LightGray)
                ) {
                    capturedImage?.let { bitmap ->
                        Image(
                            bitmap = bitmap,
                            contentDescription = "Captured Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


                IconButton(
                    onClick = { openCamera = true },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = "Camera",
                        tint = black,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }


    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { bytes ->
                if (bytes != null) {
                    capturedImage = bytes.toPlatformImageBitmap()
                }
                openCamera = false
            }
        )
    }
}
