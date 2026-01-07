import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.psc.elekha.database.viewmodel.CustomerMovableAssetsViewModel
import com.psc.elekha.database.viewmodel.MSTComboBox_NViewModel
import com.psc.elekha.ui.screen.economicdetails.MovableAssetsViewModel
import com.psc.elekha.ui.screen.familydetails.FamilyMemberViewModel
import com.psc.elekha.ui.theme.blue
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import com.psc.elekha.utils.CameraPicker
import com.psc.elekha.utils.CommonSingleButtonsBottomString
import com.psc.elekha.utils.CustomAlertDialog
import com.psc.elekha.utils.FillDynamicSpinnerespts
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.loadImageFromPath
import com.psc.elekha.utils.toValueList
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.education
import e_lekha.composeapp.generated.resources.front_image
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.name
import e_lekha.composeapp.generated.resources.no_vehicle
import e_lekha.composeapp.generated.resources.ok
import e_lekha.composeapp.generated.resources.save
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.vehicle_no
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CustomAlertMovableAssets(
    title: String = stringResource(Res.string.movable_assets),
    submitText: String = stringResource(Res.string.save),
    cancelText: String = stringResource(Res.string.cancel),
    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    val viewModel = koinViewModel<MovableAssetsViewModel>()
    val mstComboViewModel = koinViewModel<MSTComboBox_NViewModel>()
    val vehicalList by mstComboViewModel.assetVehicle.collectAsState()

    var vehicleImageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var openCamera by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        mstComboViewModel.loadLookUpValues(32)


    }

    Dialog(onDismissRequest = {}) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .wrapContentHeight()
                .background(lightGrey, RoundedCornerShape(16.dp))
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            toolbar_color,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                        .height(55.dp),
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
                        .padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Front Image Box
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
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
                                tint = blue,
                                contentDescription = stringResource(Res.string.front_image),
                                modifier = Modifier
                                    .size(28.dp)
                                    .clickable { openCamera = true})

                            Spacer(modifier = Modifier.height(4.dp))
                            ReusableTextView(text = stringResource(Res.string.front_image))
                        }
                    }
                    FillDynamicSpinnerespts(
                        label = stringResource(Res.string.education),
                        options = vehicalList,
                        selectedOption = viewModel.selectedAssetsId,
                        onOptionSelected = { viewModel.selectedAssetsId = it },
                        getOptionId = { it.ID },
                        getOptionLabel = { it.Value.toString() },
                        focusRequester = viewModel.focusRequesterAssestsId,
                        bringIntoViewRequester = viewModel.bringIntoViewRequesterAssetsId
                    )

                    Spacer(Modifier.height(12.dp))
                    FormFieldCompact(
                        label = stringResource(Res.string.vehicle_no),
                        value = viewModel.vehicleNo,
                        onValueChange = { viewModel.vehicleNo = it },
                        modifier = Modifier.focusRequester(viewModel.focusRequesterVehicleNo)
                            .bringIntoViewRequester(viewModel.bringIntoViewRequesterVehicleNo)

                    )

                    Spacer(Modifier.height(20.dp))

                    // ------------------ BUTTON ROW -------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        CommonSingleButtonsBottomString(
                            onOkClick = {
                              onCancel()
                            },
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
                    if (openCamera) {
                        CameraPicker(
                            openCamera = openCamera,
                            onImagePicked = { path ->
                                path?.let {
                                    vehicleImageBitmap = loadImageFromPath(it)
                                    viewModel.setVehicleImage(it)
                                }
                                openCamera = false
                            }
                        )
                    }
                    }
                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }

