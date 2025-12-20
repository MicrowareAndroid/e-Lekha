package com.psc.elekha.ui.screen.personaldetails

import FamilyMemberDetailViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.toValueList
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CustomAlertFamilyDetails(
    title: String = stringResource(Res.string.app_name),
    submitText: String = stringResource(Res.string.ok),
    cancelText: String = stringResource(Res.string.cancel),

    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {},
) {
    val viewModel = koinViewModel<FamilyMemberDetailViewModel>()
    // Reset function
    fun resetForm() {
        viewModel.memberFirstName = ""
        viewModel.gender = ""
        viewModel.age = ""
        viewModel.relationId = ""
        viewModel.educationId = ""
        viewModel.occupationId = ""
    }
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = Modifier
                .widthIn(min = 350.dp, max = 500.dp)
                .background(lightGrey, RoundedCornerShape(16.dp))
                .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // HEADER
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            toolbar_color,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ReusableTextView(
                        text = title,
                        fontSize = 20,
                        fontWeight = FontWeight.Bold,
                        textColor = white,
                        textAlignment = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // CONTENT AREA
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(8.dp))

                    // NAME FIELD
                    FormFieldCompact(
                        label = stringResource(Res.string.name),
                        value = viewModel.memberFirstName,
                        placeholder = stringResource(Res.string.type_here),
                        onValueChange = { viewModel.memberFirstName = it }
                    )

                    Spacer(Modifier.height(12.dp))

                    // GENDER SPINNER
                    FormSpinner(
                        label = stringResource(Res.string.gender),
                        options = StaticComboBoxData.gender.toValueList(),
                        selectedOption = viewModel.gender,
                        onOptionSelected = { viewModel.gender = it }
                    )

                    Spacer(Modifier.height(12.dp))

                    // AGE & RELATION ROW
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormFieldCompact(
                            label = stringResource(Res.string.age),
                            value = viewModel.age,
                            onValueChange = { viewModel.age = it },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 2,
                            inputType = KeyboardType.Number,
                            modifier = Modifier.weight(1f)
                        )

                        FormSpinner(
                            label = stringResource(Res.string.relation),
                            options = StaticComboBoxData.religionList.toValueList(),
                            selectedOption = viewModel.relationId,
                            onOptionSelected = { viewModel.relationId = it },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    // EDUCATION & OCCUPATION ROW
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormSpinner(
                            label = stringResource(Res.string.education),
                            options = StaticComboBoxData.educationList.toValueList(),
                            selectedOption = viewModel.educationId,
                            onOptionSelected = { viewModel.educationId = it },
                            modifier = Modifier.weight(1f)
                        )

                        FormSpinner(
                            label = stringResource(Res.string.occupation),
                            options = StaticComboBoxData.occupatin.toValueList(),
                            selectedOption = viewModel.occupationId,
                            onOptionSelected = { viewModel.occupationId = it },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(Modifier.height(24.dp))


                    }

                    Spacer(Modifier.height(10.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.monthly_income),
                        value ="",
                        placeholder = stringResource(Res.string.type_here),
                        onValueChange = { viewModel.memberFirstName = it }
                    )
                    Spacer(Modifier.height(24.dp))
                    // BUTTONS
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CommonSingleButtonsBottomString(
                            onOkClick = {
                                onSubmit()
                            },
                            stringResource(Res.string.cancel),
                            modifier = Modifier.weight(1f),
                            textSize = 12
                        )
                        CommonSingleButtonsBottomString(
                            onOkClick = {
                                onSubmit()
                            },
                            stringResource(Res.string.gtr_saves),
                            modifier = Modifier.weight(1f),
                            textSize = 12
                        )
                    }

                    }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }

