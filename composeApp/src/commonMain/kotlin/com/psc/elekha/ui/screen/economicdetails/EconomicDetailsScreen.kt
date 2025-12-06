package com.psc.elekha.ui.screen.economicdetails

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
import com.psc.elekha.model.EconomicMovableAssetsModel
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CustomAlertMovableAssets
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.SelectableChip
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add
import e_lekha.composeapp.generated.resources.annual
import e_lekha.composeapp.generated.resources.daily_expenses
import e_lekha.composeapp.generated.resources.education_expenses
import e_lekha.composeapp.generated.resources.ic_add
import e_lekha.composeapp.generated.resources.medical_expenses
import e_lekha.composeapp.generated.resources.monthly_expenditure
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


    LaunchedEffect(Unit) {

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    )
    {

        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                SelectableChip(
                    text = stringResource(Res.string.other_income),
                    isSelected = selectedChip == 0,
                    onClick = { selectedChip = 0 },
                    modifier = Modifier.weight(1f)
                )

                SelectableChip(
                    text = stringResource(Res.string.monthly_expenditure),
                    isSelected = selectedChip == 1,
                    onClick = { selectedChip = 1 },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {

                when (selectedChip) {

                    0 -> {
                        Text("Enter Consumer Number")
                    }

                    1 -> {

                        Column(modifier = Modifier.fillMaxWidth()) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                FormField(
                                    label = stringResource(Res.string.daily_expenses),
                                    value = "",
                                    onValueChange = { "" },
                                    placeholder = stringResource(Res.string.type_here),
                                    maxLength = 6,
                                    modifier = Modifier.weight(1f),
                                    inputType = KeyboardType.Number
                                )

                                FormField(
                                    label = stringResource(Res.string.education_expenses),
                                    value = "",
                                    onValueChange = { "" },
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
                            ) {
                                FormField(
                                    label = stringResource(Res.string.medical_expenses),
                                    value = "",
                                    onValueChange = { "" },
                                    placeholder = stringResource(Res.string.type_here),
                                    maxLength = 6,
                                    modifier = Modifier.weight(1f),
                                    inputType = KeyboardType.Number
                                )

                                FormField(
                                    label = stringResource(Res.string.other_expenses),
                                    value = "",
                                    onValueChange = { "" },
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
                            ) {
                                FormField(
                                    label = stringResource(Res.string.total_monthly_expenditure),
                                    value = "",
                                    onValueChange = { "" },
                                    placeholder = stringResource(Res.string.type_here),
                                    maxLength = 6,
                                    modifier = Modifier.weight(1f),
                                    inputType = KeyboardType.Number
                                )

                                FormField(
                                    label = stringResource(Res.string.annual),
                                    value = "",
                                    onValueChange = { "" },
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
                                    onClick = {showDialog = true},
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
                                        economicMovableAssetsModel[index]
                                    )
                                }
                            }

                        }
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