package com.psc.elekha.ui.screen.personaldetails


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.ui.screen.familydetails.FamilyMemberViewModel

import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.FillDynamicSpinnerespts
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CustomAlertFamilyDetails(
    title: String = stringResource(Res.string.app_name),
    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {},
) {

    val viewModel = koinViewModel<FamilyMemberViewModel>()
    val mstComboViewModel = koinViewModel<MSTComboBox_NViewModel>()

    val genderList by mstComboViewModel.genderValue.collectAsState()
    val occupationList by mstComboViewModel.occupationValue.collectAsState()
    val relationList by mstComboViewModel.relationValue.collectAsState()
    val educationList by mstComboViewModel.mstQualificationValue.collectAsState()

    LaunchedEffect(Unit) {
        mstComboViewModel.loadLookUpValues(31)
        mstComboViewModel.loadLookUpValues(4)
        mstComboViewModel.loadLookUpValues(6)
        mstComboViewModel.loadLookUpValues(5)
        viewModel.loadData()
    }

    Dialog(onDismissRequest = {}) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .wrapContentHeight()
                .background(lightGrey, RoundedCornerShape(16.dp))
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {

                //  Toolbar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(
                            toolbar_color,
                            RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ReusableTextView(
                        text = title,
                        fontSize = 18,
                        fontWeight = FontWeight.Bold,
                        textColor = white
                    )
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    FormFieldCompact(
                        label = stringResource(Res.string.name),
                        value = viewModel.memberName,
                        onValueChange = { viewModel.memberName = it },
                        modifier = Modifier.focusRequester(viewModel.focusRequesterAge)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterAge)

                    )

                    FillDynamicSpinnerespts(
                        label = stringResource(Res.string.gender),
                        options = genderList,
                        selectedOption = viewModel.gender,
                        onOptionSelected = { viewModel.gender = it },
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        focusRequester = viewModel.focusRequesterGender,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterGender

                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormFieldCompact(
                            label = stringResource(Res.string.age),
                            value = viewModel.age,
                            onValueChange = { viewModel.age = it },
                            inputType = KeyboardType.Number,
                            modifier = Modifier.weight(1f).focusRequester(viewModel.focusRequesterAge)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterAge)
                        )

                        FillDynamicSpinnerespts(
                            label = stringResource(Res.string.relation),
                            options = relationList,
                            selectedOption = viewModel.relationId,
                            onOptionSelected = { viewModel.relationId = it },
                            getOptionId = { it.ID },
                            getOptionLabel = { it.Value.toString() },
                            modifier = Modifier.weight(1f),
                            focusRequester = viewModel.focusRequesterRelationId,
                            bringIntoViewRequester = viewModel.bringIntoViewRequesterRelationId
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FillDynamicSpinnerespts(
                            label = stringResource(Res.string.education),
                            options = educationList,
                            selectedOption = viewModel.educationId,
                            onOptionSelected = { viewModel.educationId = it },
                            getOptionId = { it.ID },
                            getOptionLabel = { it.Value.toString() },
                            modifier = Modifier.weight(1f),
                            focusRequester = viewModel.focusRequesterEducationId,
                            bringIntoViewRequester = viewModel.bringIntoViewRequesterEducationId
                        )

                        FillDynamicSpinnerespts(
                            label = stringResource(Res.string.occupation),
                            options = occupationList,
                            selectedOption = viewModel.occupationId,
                            onOptionSelected = { viewModel.occupationId = it },
                            getOptionId = { it.ID },
                            getOptionLabel = { it.Value.toString() },
                            modifier = Modifier.weight(1f),
                            focusRequester = viewModel.focusRequesterOccupationId,
                            bringIntoViewRequester = viewModel.bringIntoViewRequesterOccupationId

                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormFieldCompact(
                            label = stringResource(Res.string.monthly_income),
                            value = viewModel.monthlyIncome,
                            onValueChange = { viewModel.monthlyIncome = it },
                            inputType = KeyboardType.Number,
                            modifier = Modifier.weight(1f).focusRequester(viewModel.focusRequesterMonthlyIncome)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterMonthlyIncome)

                        )

                        FormFieldCompact(
                            label = stringResource(Res.string.remarks),
                            value = viewModel.remarks,
                            onValueChange = { viewModel.remarks = it },
                            modifier = Modifier.weight(1f).focusRequester(viewModel.focusRequesterRemarks)
                                .bringIntoViewRequester(viewModel.bringIntoViewRequesterRemarks)

                        )
                    }
                }

                // Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    CommonSingleButtonsBottomString(
                        onOkClick = onCancel,
                        stringResource(Res.string.cancel),
                        modifier = Modifier.weight(1f),
                        textSize = 12
                    )

                    CommonSingleButtonsBottomString(
                        onOkClick = {
                            viewModel.saveData()

                        },
                        stringResource(Res.string.save),
                        modifier = Modifier.weight(1f),
                        textSize = 12
                    )
                    if (viewModel.showSaveAlert) {
                        CustomAlertDialog(
                            showDialog = viewModel.showSaveAlert,
                            message = viewModel.saveMessage,
                            onConfirm = {
                                if (viewModel.saveFlag == 1) {
                                    viewModel.showSaveAlert = false
                                    onSubmit()

                                } else {
                                    viewModel.requestFocus()
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
