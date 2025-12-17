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
import com.psc.elekha.utils.FormFieldCompact
import com.psc.elekha.utils.FormSpinner
import com.psc.elekha.utils.ReusableTextView
import com.psc.elekha.utils.StaticComboBoxData
import com.psc.elekha.utils.toValueList
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.movable_assets
import e_lekha.composeapp.generated.resources.ok
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.vehicle_no
import org.jetbrains.compose.resources.stringResource

@Composable
fun CustomAlertMovableAssets(
    title: String = stringResource(Res.string.app_name),
    submitText: String = stringResource(Res.string.ok),
    cancelText: String = stringResource(Res.string.cancel),
    onSubmit: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    var movableAssets by remember { mutableStateOf("") }
    var vehicleNo by remember { mutableStateOf("") }

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

                // --------------------- HEADER (NO MARGIN) ---------------------
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
                        modifier = Modifier.fillMaxWidth()   // Perfect center
                    )
                }

                // ------------------- CONTENT AREA (WITH PADDING) -------------------
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),      // Only content has padding
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(Modifier.height(12.dp))

                    // Movable Assets Spinner
                    FormSpinner(
                        label = stringResource(Res.string.movable_assets),
                        options = StaticComboBoxData.vehicleasset.toValueList(),
                        selectedOption = movableAssets,
                        onOptionSelected = {movableAssets = it},
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(12.dp))

                    // Vehicle Number Field
                    FormFieldCompact(
                        label = stringResource(Res.string.vehicle_no),
                        value = vehicleNo,
                        onValueChange = { vehicleNo = it },
                        placeholder = stringResource(Res.string.type_here),
                        maxLength = 10,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(20.dp))

                    // ------------------ BUTTON ROW -------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        // Cancel Button
                        Button(
                            onClick = onCancel,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Text(cancelText)
                        }

                        // Submit Button
                        Button(
                            onClick = onSubmit,
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btn_color,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(15.dp)
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
