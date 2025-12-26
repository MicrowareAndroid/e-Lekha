package com.psc.elekha.ui.screen.bankdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.Uri
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.toValueList
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.bank_account_number
import e_lekha.composeapp.generated.resources.bank_name
import e_lekha.composeapp.generated.resources.branch_name
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.customer_bank_details
import e_lekha.composeapp.generated.resources.customer_name_in_bank_dairy
import e_lekha.composeapp.generated.resources.ifsc_code
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.passbook_image
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankDetailsScreen(onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}) {
    var passbookImage by remember { mutableStateOf<Uri?>(null) }
    var nameOnAccount by remember { mutableStateOf("") }
    var AccountNo by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var branchName by remember { mutableStateOf("") }
    var ifscCode by remember { mutableStateOf("") }
    val viewModel = koinViewModel<BankDetailViewModel>()


    LaunchedEffect(Unit) {
        viewModel.loadSaveData()

    }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 15.dp)
            ) {

                ReusableTextViewes(
                    text = stringResource(Res.string.customer_bank_details)
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.customer_name_in_bank_dairy),
                    value = nameOnAccount,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { nameOnAccount = it},
                    maxLength = 30
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.bank_account_number),
                    value = AccountNo,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { AccountNo = it },
                    maxLength = 18,
                    inputType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormSpinner(
                    label = stringResource(Res.string.bank_name),
                    options = StaticComboBoxData.bankname.toValueList(),
                    selectedOption = bankName,
                    onOptionSelected = { bankName = it}
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormSpinner(
                    label = stringResource(Res.string.branch_name),
                    options = StaticComboBoxData.branchname.toValueList(),
                    selectedOption = branchName,
                    onOptionSelected = {branchName = it }
                )

                Spacer(modifier = Modifier.height(8.dp))

                FormFieldCompact(
                    label = stringResource(Res.string.ifsc_code),
                    value = ifscCode,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { ifscCode = it},
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Front Image Box
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(120.dp)
                                .background(Color(0xFFE8E8E8)), // Light Grey Box
                            contentAlignment = Alignment.Center
                        ) {
                            // Preview can go here
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = "",
                            tint = blue,
                            modifier = Modifier.size(28.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        ReusableTextView(
                            text = stringResource(Res.string.passbook_image),
                            fontSize = 14,
                            textColor = textview_color
                        )
                    }
                }


            }

            CommonSaveButton(
                onSaveClick = { viewModel.saveData()},
                saveText = stringResource(Res.string.next)
            )
        }
        if (viewModel.showSaveAlert) {
            CustomAlertDialog(
                showDialog = viewModel.showSaveAlert,
                message = viewModel.saveMessage,
                onConfirm = {
                    if (viewModel.saveFlag == 1) {
                        viewModel.showSaveAlert = false
                        onNextTab()
                    } else {
                        viewModel.requestFocus()
                    }
                }
            )
        }
    }

}