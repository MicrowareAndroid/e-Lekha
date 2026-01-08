package com.psc.elekha.ui.screen.bankdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.relocation.bringIntoViewRequester
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
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.Uri
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.ReusableTextViewes
import com.psc.elekha.utils.RouteName
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.loadImageFromPath
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
import e_lekha.composeapp.generated.resources.select_customer_submit
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankDetailsScreen(navController: NavController) {
    val viewModel = koinViewModel<BankDetailViewModel>()
    var openCamera by remember { mutableStateOf(false) }
    var passbookImageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        viewModel.loadSavedBankData()
        // Wait for data to load
        kotlinx.coroutines.delay(500)
        if (viewModel.passbookImage.isNotEmpty()) {
            passbookImageBitmap = loadImageFromPath(viewModel.passbookImage)
        }
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
                    value = viewModel.accountName,
                    modifier = Modifier
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterAccountName)
                        .focusRequester(viewModel.focusRequesterAccountName),
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { viewModel.accountName = it},
                    maxLength = 20
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormFieldCompact(
                    label = stringResource(Res.string.bank_account_number),
                    value = viewModel.accountNumber,
                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { viewModel.accountNumber = it },
                    modifier = Modifier
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterAccountNumber)
                        .focusRequester(viewModel.focusRequesterAccountNumber),
                    maxLength = 18,
                    inputType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormSpinner(
                    label = stringResource(Res.string.bank_name),
                    options = StaticComboBoxData.bankname.toValueList(),
                    selectedOption = viewModel.selectedBankname,
                    modifier = Modifier
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterBankName)
                        .focusRequester(viewModel.focusRequesterBankName),
                    onOptionSelected = {
                        viewModel.selectedBankname = it
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormSpinner(
                    label = stringResource(Res.string.branch_name),
                    options = StaticComboBoxData.branchname.toValueList(),
                    selectedOption = viewModel.selectedBranchname,
                    modifier = Modifier
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterBranchName)
                        .focusRequester(viewModel.focusRequesterBranchName),
                    onOptionSelected = {viewModel.selectedBranchname = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                FormFieldCompact(
                    label = stringResource(Res.string.ifsc_code),
                    value = viewModel.ifscCode,

                    placeholder = stringResource(Res.string.type_here),
                    onValueChange = { viewModel.ifscCode = it},
                    modifier = Modifier
                        .bringIntoViewRequester(viewModel.bringIntoViewRequesterIfscCode)
                        .focusRequester(viewModel.focusRequesterIfscCode),
                    maxLength = 11
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
                                .background(Color(0xFFE8E8E8)),
                            contentAlignment = Alignment.Center
                        ) {
                            passbookImageBitmap?.let { img ->
                                Image(
                                    bitmap = img,
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop

                                )
                            }
                            }
                        Spacer(modifier = Modifier.height(6.dp))
                        Icon(
                            painter = painterResource(Res.drawable.camera),
                            contentDescription = "",
                            tint = blue,
                            modifier = Modifier
                                .size(28.dp)
                                .clickable { openCamera = true }
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
                saveText = stringResource(Res.string.select_customer_submit)
            )
        }
        if (viewModel.showSaveAlert) {
            CustomAlertDialog(
                showDialog = viewModel.showSaveAlert,
                message = viewModel.saveMessage,
                onConfirm = {
                    viewModel.showSaveAlert = false
                    if (viewModel.saveFlag == 1) {

                        navController.popBackStack()
                        navController.navigate(RouteName.registration_list) // RegistrationListScreen
                    } else {
                        viewModel.requestFocus()
                    }
                }
            )
        }
    }
    if (openCamera) {
        CameraPicker(
            openCamera = openCamera,
            onImagePicked = { path ->
                path?.let {
                    passbookImageBitmap = loadImageFromPath(it)
                    viewModel.setPassbookImage(it)
                }
                openCamera = false
            }
        )
    }

}