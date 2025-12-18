package com.psc.elekha.ui.screen.economicdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.occupation
import e_lekha.composeapp.generated.resources.ok
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.remarks
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.stringResource

@Composable
fun CustomAlertMonthlyIncome(
    title: String = stringResource(Res.string.app_name),
    submitText: String = stringResource(Res.string.ok),
    cancelText: String = stringResource(Res.string.cancel),
    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var relation by remember { mutableStateOf("") }
    var occupation by remember { mutableStateOf("") }
    var income by remember { mutableStateOf("") }
    var remarks by remember { mutableStateOf("") }

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

                // ----------------------- HEADER (NO MARGIN) -----------------------
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
                        modifier = Modifier.fillMaxWidth()  // Perfect centering
                    )
                }

                // ----------------------- CONTENT AREA -----------------------
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),             // Padding ONLY inside content area
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(Modifier.height(8.dp))

                    // ----------- NAME & RELATION SPINNERS -----------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormSpinner(
                            label = stringResource(Res.string.name),
                            options = listOf("Test", "ABC", "XYZ"),
                            selectedOption = name,
                            onOptionSelected = {name = it},
                            modifier = Modifier.weight(1f)
                        )

                        FormSpinner(
                            label = stringResource(Res.string.relation),
                            options = listOf("Brother", "Self", "Sister"),
                            selectedOption = relation,
                            onOptionSelected = {relation = it},
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    // ----------- OCCUPATION & INCOME SPINNERS -----------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormSpinner(
                            label = stringResource(Res.string.occupation),
                            options = listOf("Shop", "Farming", "Labour", "Other"),
                            selectedOption = occupation,
                            onOptionSelected = {occupation =it},
                            modifier = Modifier.weight(1f)
                        )

                        FormSpinner(
                            label = stringResource(Res.string.income),
                            options = listOf("<5000", "5000-10000", "10000-20000", ">20000"),
                            selectedOption = income,
                            onOptionSelected = {income = it},
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    // ----------- REMARKS FIELD -----------
                    FormFieldCompact(
                        label = stringResource(Res.string.remarks),
                        value = remarks,
                        onValueChange = { remarks =it },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 30,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(24.dp))

                    // ----------------------- BUTTONS -----------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
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
                            stringResource(Res.string.ok),
                            modifier = Modifier.weight(1f),
                            textSize = 12
                        )
                    }

                    }

                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }

