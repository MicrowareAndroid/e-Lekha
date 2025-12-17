package com.psc.elekha.ui.screen.familydetails

import FamilyMemberDetailViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil3.Uri
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPreviewField
import com.psc.elekha.utils.CommonDivider
import com.psc.elekha.utils.CommonSaveButton
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.DynamicCheckBox
import com.psc.elekha.utils.FormDatePicker
import com.psc.elekha.utils.FormField
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableImageView
import com.psc.elekha.utils.ReusableTextView
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.age
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.gender

import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.occupation
import e_lekha.composeapp.generated.resources.ok
import e_lekha.composeapp.generated.resources.relation
import e_lekha.composeapp.generated.resources.type_here
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
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


    val viewModel = koinViewModel<FamilyMemberDetailViewModel>();
    var coroutine=rememberCoroutineScope()
    LaunchedEffect(Unit){
        viewModel.loadFamilyMembers()
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
                    FormFieldCompact(
                        label = stringResource(Res.string.name),
                        value = viewModel.memberFirstName,
                        placeholder = stringResource(Res.string.type_here),
                        onValueChange = {
                            viewModel.memberFirstName = it
                        },

                        )
                    Spacer(Modifier.height(12.dp))
                    FormSpinner(
                        label = stringResource(Res.string.gender),
                        options = listOf("Male", "Female", "Other"),
                        selectedOption = when (viewModel.gender) {
                            1 -> "Male"
                            2 -> "Female"
                            3 -> "Other"
                            else -> ""
                        },
                        onOptionSelected = {
                            viewModel.gender = when (it) {
                                "Male" -> 1
                                "Female" -> 2
                                "Other" -> 3
                                else -> 0
                            }
                        }
                    )

                    Spacer(Modifier.height(12.dp))

                    // ----------- OCCUPATION & INCOME SPINNERS -----------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        FormFieldCompact(
                            label = stringResource(Res.string.age),
                            value = viewModel.age.toString(),
                            onValueChange = {
                                viewModel.age = it.toIntOrNull() ?: 0
                            },
                            placeholder = stringResource(Res.string.type_here),
                            maxLength = 2,
                            inputType = KeyboardType.Number,
                            modifier = Modifier.weight(1f)

                        )

                        FormSpinner(
                            label = stringResource(Res.string.relation),
                            options = listOf("Brother", "Husband"),
                            selectedOption = if (viewModel.relationId == 1) "Brother" else "Husband",
                            onOptionSelected = {
                                viewModel.relationId = if (it == "Brother") 1 else 2
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        FormSpinner(
                            label = stringResource(Res.string.education),
                            options = listOf("Graduation", "Post Graduation", "12th"),
                            selectedOption =viewModel.educationId.toString() ,
                            onOptionSelected = {
                                viewModel.educationId = when (it) {
                                    "Graduation" -> 1
                                    "Post Graduation" -> 2
                                    "12th" -> 3
                                    else -> 0
                                }
                            },
                            modifier = Modifier.weight(1f)

                        )
                        FormSpinner(
                            label = stringResource(Res.string.occupation),
                            options = listOf("Doctor", "Teacher", "Driver"),
                            selectedOption = viewModel.occupationId.toString(),
                            onOptionSelected = {
                                viewModel.occupationId = when (it) {
                                    "Doctor" -> 1
                                    "Teacher" -> 2
                                    "Driver" -> 3
                                    else -> 0
                                }
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    // ----------- REMARKS FIELD -----------
                    Spacer(Modifier.height(24.dp))
                    // ----------------------- BUTTONS -----------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = onCancel,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(1.dp)
                        ) {
                            Text(cancelText)
                        }
                        Button(
                            onClick = {
                                coroutine.launch {
                                   viewModel.saveFamilyMember()
                                    onSubmit()
                               }

                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(1.dp)
                        ) {
                            Text(submitText)
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}