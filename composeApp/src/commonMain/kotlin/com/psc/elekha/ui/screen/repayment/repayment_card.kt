package com.psc.elekha.ui.screen.repayment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.psc.elekha.ui.screen.repayment.model.RepaymentItem
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.utils.*
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.stringResource

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
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .defaultMinSize(minHeight = 45.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

           Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = isSelected,
                    onCheckedChange = { onSelected() },
                    modifier = Modifier.size(22.dp),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF4CAF50),
                        uncheckedColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

               Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {

                   Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Row {
                            ReusableTextViewGrayCard("Customer", fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.customerId, fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.customerName, fontSize = 13)
                        }

                        Row {
                            ReusableTextViewGrayCard("Loan Amount", fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.loanAmount, fontSize = 13)
                            Spacer(modifier = Modifier.width(8.dp))
                            ReusableTextViewGrayCard("EMI", fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.emiAmount, fontSize = 13)
                        }

                        Row {
                            ReusableTextViewGrayCard("Total Due", fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.totalDue, fontSize = 13)
                            Spacer(modifier = Modifier.width(8.dp))
                            ReusableTextViewGrayCard("Weeks Arrear", fontSize = 13)
                            Spacer(modifier = Modifier.width(4.dp))
                            ReusableTextViewBlackCard(item.weeksInArrear, fontSize = 13)
                        }
                    }


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.width(80.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .size(55.dp)
                                .background(Color.LightGray, RoundedCornerShape(6.dp))
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




            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ReusableTextViewGrayCard("Payment Mode", fontSize = 13)

                Spacer(modifier = Modifier.width(4.dp))

                ReusableDynamicSpinner(
                    selectedValue = selectedPaymentMode,
                    options = paymentOptions,
                    onValueSelected = { selectedPaymentMode = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(4.dp))

                FormFieldCompacts(
                    value = repaymentAmount,
                    onValueChange = { repaymentAmount = it },
                    placeholder = stringResource(Res.string.type_here),
                    maxLength = 10,
                    modifier = Modifier.weight(1f)
                )
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
