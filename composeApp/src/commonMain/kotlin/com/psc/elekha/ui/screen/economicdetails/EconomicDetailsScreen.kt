package com.psc.elekha.ui.screen.economicdetails

import CustomAlertMovableAssets
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.psc.elekha.model.EconomicMonthlyIncomeModel
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSaveButton

import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.ReusableTextView

import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add
import e_lekha.composeapp.generated.resources.annual
import e_lekha.composeapp.generated.resources.daily_expenses
import e_lekha.composeapp.generated.resources.education_expenses
import e_lekha.composeapp.generated.resources.ic_add
import e_lekha.composeapp.generated.resources.income
import e_lekha.composeapp.generated.resources.medical_expenses
import e_lekha.composeapp.generated.resources.monthly_expenditure
import e_lekha.composeapp.generated.resources.monthly_income
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.next
import e_lekha.composeapp.generated.resources.other_expenses
import e_lekha.composeapp.generated.resources.other_income
import e_lekha.composeapp.generated.resources.total_monthly_expenditure
import e_lekha.composeapp.generated.resources.type_here
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EconomicDetailsScreen(onNextTab: () -> Unit = {}, onCancelTab: () -> Unit = {}) {
    var selectedChip by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
    var showDialogMonthlyIncome by remember { mutableStateOf(false) }
    var dailyexpenses by remember {mutableStateOf("")}
    var educationexpenses by remember{mutableStateOf("")}
    var medicalexpenses by remember { mutableStateOf("")}
    var otherexpenses by remember { mutableStateOf("") }
    var totalmonthlyexpenditure by remember { mutableStateOf("") }
    var annual by remember {mutableStateOf("")}


    var economicMovableAssetsModel by rememberSaveable {
        mutableStateOf(
            listOf(
                EconomicMovableAssetsModel(
                    "Car",
                    "DL02A4444"
                ),
                EconomicMovableAssetsModel(
                    "Bike",
                    "DL02A4000"
                ),
                EconomicMovableAssetsModel(
                    "Truck",
                    "DL02A3000"
                )
            )
        )
    }

    var economicMonthlyIncomeModel by rememberSaveable {
        mutableStateOf(
            listOf(
                EconomicMonthlyIncomeModel(
                    "Test",
                    "Self",
                    "Working",
                    "20000"
                ),
                EconomicMonthlyIncomeModel(
                    "ABC",
                    "Brother",
                    "Working",
                    "10000"
                )
            )
        )
    }


    LaunchedEffect(Unit) {

    }

    Box(
        modifier = Modifier
            .fillMaxSize()

    )
    {

        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 15.dp)
            )
            {
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.monthly_income),
                        modifier = Modifier.weight(1f)
                    )

                    // Right FAB
                    FloatingActionButton(
                        onClick = { showDialogMonthlyIncome = true },
                        containerColor = btn_color,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = btn_color,
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_add),
                            contentDescription = stringResource(Res.string.add),
                            tint = black
                        )
                    }
                }

                if (showDialogMonthlyIncome) {
                    CustomAlertMonthlyIncome(
                        onSubmit = {
                            showDialogMonthlyIncome = false
                        },
                        onCancel = {
                            showDialogMonthlyIncome = false
                        }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 100.dp, max = 600.dp)
                        .padding(bottom = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(economicMonthlyIncomeModel.size) { index ->
                        EconomicMonthlyIncomeCard(
                            economicMonthlyIncomeModel[index]
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.income),
                        modifier = Modifier.weight(1f)
                    )

                    ReusableTextView(
                        text = "20000",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                )
                {
                    FormFieldCompact(
                        label = stringResource(Res.string.daily_expenses),
                        value = dailyexpenses,
                        onValueChange = {
                            dailyexpense->
                            dailyexpenses = dailyexpense
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 6,
                        modifier = Modifier.weight(1f),
                        inputType = KeyboardType.Number
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.education_expenses),
                        value = educationexpenses,
                        onValueChange = {
                            educationexpense->
                            educationexpenses = educationexpense
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 6,
                        inputType = KeyboardType.Number
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                )
                {
                    FormFieldCompact(
                        label = stringResource(Res.string.medical_expenses),
                        value = medicalexpenses,
                        onValueChange = {
                            medicalexpense->
                            medicalexpenses = medicalexpense
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 6,
                        modifier = Modifier.weight(1f),
                        inputType = KeyboardType.Number
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.other_expenses),
                        value = otherexpenses,
                        onValueChange = {
                            otherexpense->
                            otherexpenses = otherexpense
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 6,
                        inputType = KeyboardType.Number
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.Bottom
                )
                {
                    FormFieldCompact(
                        label = stringResource(Res.string.total_monthly_expenditure),
                        value = totalmonthlyexpenditure,
                        onValueChange = { totalmonthlyexpenditures->
                            totalmonthlyexpenditure = totalmonthlyexpenditures
                        },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 6,
                        modifier = Modifier.weight(1f),
                        inputType = KeyboardType.Number
                    )

                    FormFieldCompact(
                        label = stringResource(Res.string.annual),
                        value = annual,
                        onValueChange = { annuals->
                            annual = annuals
                        },
                        placeholder = stringResource(Res.string.type_here),
                        modifier = Modifier.weight(1f),
                        maxLength = 6,
                        inputType = KeyboardType.Number
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    ReusableTextView(
                        text = stringResource(Res.string.movable_assets),
                        modifier = Modifier.weight(1f)
                    )

                    // Right FAB
                    FloatingActionButton(
                        onClick = { showDialog = true },
                        containerColor = btn_color,
                        shape = CircleShape,
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = btn_color,
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_add),
                            contentDescription = stringResource(Res.string.add),
                            tint = black
                        )
                    }
                }

                if (showDialog) {
                    CustomAlertMovableAssets(
                        onSubmit = {
                            showDialog = false
                        },
                        onCancel = {
                            showDialog = false
                        }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 100.dp, max = 600.dp)
                        .padding(bottom = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(economicMovableAssetsModel.size) { index ->
                        EconomicMovableAssetsCard(
                            economicMovableAssetsModel = economicMovableAssetsModel[index],
                            onDelete = {
                                economicMovableAssetsModel =
                                    economicMovableAssetsModel.toMutableList().also {
                                        it.removeAt(index)
                                    }
                            }
                        )

                    }
                }

            }
            CommonSaveButton(
                onSaveClick = {},
                saveText = stringResource(Res.string.next)
            )
        }
    }

}