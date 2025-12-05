package com.psc.elekha.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil3.Uri
import coil3.compose.rememberAsyncImagePainter
import com.psc.elekha.ui.screen.gtrlist.CustomerData
import com.psc.elekha.ui.screen.gtrlist.GroupCardData
import com.psc.elekha.ui.theme.CardColor
import com.psc.elekha.ui.theme.LightBlueBackground
import com.psc.elekha.ui.theme.LightSkyBlue
import com.psc.elekha.ui.theme.LoginTextBox
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.assureOrange
import com.psc.elekha.ui.theme.bgColor
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.boderColor
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.desire_orange
import com.psc.elekha.ui.theme.editext_bg_color
import com.psc.elekha.ui.theme.formborder
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.lightgreens
import com.psc.elekha.ui.theme.teal700
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.white
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.camera
import e_lekha.composeapp.generated.resources.close
import e_lekha.composeapp.generated.resources.dd_mm_yy
import e_lekha.composeapp.generated.resources.document_icon
import e_lekha.composeapp.generated.resources.enter_here
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.gtr_add
import e_lekha.composeapp.generated.resources.gtr_save
import e_lekha.composeapp.generated.resources.hh_mm
import e_lekha.composeapp.generated.resources.ic_arrow_drop_down
import e_lekha.composeapp.generated.resources.ic_close
import e_lekha.composeapp.generated.resources.password
import e_lekha.composeapp.generated.resources.roboto_medium
import e_lekha.composeapp.generated.resources.save
import e_lekha.composeapp.generated.resources.spinner_select
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.user_default
import e_lekha.composeapp.generated.resources.username
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.String

@Composable
fun ReusableTextView(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    backgroundColor: Color = Color.Transparent,
    cornerRadius: Dp = 0.dp,
    padding: Dp = 0.dp,
    style: TextStyle = TextStyle.Default,
    textAlignment: TextAlign = TextAlign.Start,
    isMandatory: Int = 0,
    asteriskColor: Color = Color.Red
) {
    val displayText = if (isMandatory == 1) {
        buildAnnotatedString {
            append(text)
            withStyle(style = SpanStyle(color = asteriskColor)) {
                append(" *")
            }
        }
    } else {
        AnnotatedString(text)
    }

    Text(
        text = displayText,
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding),
        style = style.copy(
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        ),
        textAlign = textAlignment
    )
}

@Composable
fun ReusableTextViews(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    backgroundColor: Color = Color.Transparent,
    cornerRadius: Dp = 0.dp,
    padding: Dp = 0.dp,
    style: TextStyle = TextStyle.Default,
    textAlignment: TextAlign = TextAlign.Start,
    isMandatory: Int = 0,
    asteriskColor: Color = Color.Red
) {

    val displayText = if (isMandatory == 1) {
        buildAnnotatedString {
            // 👈 Asterisk first
            withStyle(style = SpanStyle(color = asteriskColor)) {
                append("* ")
            }
            append(text)
        }
    } else {
        AnnotatedString(text)
    }

    Text(
        text = displayText,
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding),
        style = style.copy(
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        ),
        textAlign = textAlignment
    )
}

@Composable
fun ReusableImageView(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String = stringResource(Res.string.app_name),
    size: Dp = 60.dp,
    flag: Int = 1,                        // 0 = fillMaxSize, 1 = fixed size
    cornerRadius: Dp = 0.dp,
    backgroundColor: Color = Color.Transparent,
    padding: Dp = 0.dp,
    contentScale: ContentScale = ContentScale.Crop,
    onClick: (() -> Unit)? = null
) {
    val baseModifier = modifier
        .then(
            if (flag == 0) Modifier.fillMaxSize()
            else Modifier.size(size)
        )
        .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
        .padding(padding)
        .let { if (onClick != null) it.clickable { onClick() } else it }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = baseModifier,
        contentScale = contentScale
    )
}

/*edittext*/
@Composable
fun ReusableOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "psc.augp@aubank",
    textColor: Color = Color.Black,
    hintColor: Color = Color.Gray,
    fontSize: TextUnit = 10.sp,
    fontFamily: FontFamily = FontFamily.Default,
    backgroundColor: Color = Color.White,
    focusedBorderColor: Color = lightgreens,
    unfocusedBorderColor: Color = lightgreens,

    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, ),
        placeholder = {
            Text(
                text = hint,
                color = hintColor,
                fontSize = fontSize,
                fontFamily = fontFamily
            )
        },
        textStyle = TextStyle(
            color = textColor,
            fontSize = fontSize,
            fontFamily = fontFamily
        ),
        singleLine = singleLine,
        maxLines = maxLines,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            cursorColor = focusedBorderColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedPlaceholderColor = hintColor,
            unfocusedPlaceholderColor = hintColor,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableTopBar(
    title: String,
    backgroundColor: Color = toolbar_color,
    titleColor: Color = Color.White,
    navigationIcon: Painter? = null,
    onNavigationClick: (() -> Unit)? = null,
    actionIcon: Painter? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily.Default
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = titleColor,
                    fontFamily = fontFamily
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            if (navigationIcon != null && onNavigationClick != null) {
                11
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        painter = navigationIcon,
                        contentDescription = "Back",
                        tint = titleColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        actions = {
            if (actionIcon != null && onActionClick != null) {
                IconButton(onClick = onActionClick) {
                    Icon(
                        painter = actionIcon,
                        contentDescription = "Action",
                        tint = titleColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(48.dp))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = titleColor,
            navigationIconContentColor = titleColor,
            actionIconContentColor = titleColor
        ),
        modifier = modifier
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreenCardItem(
    icon: Painter,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    titleColor: Color = Color.Black,
    buttonColor: Color = Color(0xFFFFE0B2),
    arrowColor: Color = desire_orange,
    fontFamily: FontFamily = FontFamily.Default
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = icon,
                    contentDescription = title,
                    modifier = Modifier.size(90.dp),
                    tint = Color.Unspecified
                )

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fontFamily,
                    color = titleColor
                )
            }

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(buttonColor, RoundedCornerShape(8.dp))
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Go",
                    tint = arrowColor
                )
            }
        }
    }
}

@Composable
fun CommonActionButtons(
    onSaveClick: () -> Unit,
    onCloseClick: () -> Unit,
    accentColor: Color = btn_color,
    saveText: String = stringResource(Res.string.gtr_save),
    closeText: String = stringResource(Res.string.gtr_add),
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {


        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(saveText)
        }



        Button(
            onClick = onCloseClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(closeText)
        }
    }
}

@Composable
fun CommonSaveButton(
    onSaveClick: () -> Unit,
    saveText: String = stringResource(Res.string.save)
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(saveText)
        }
    }
}

@Composable
fun CommonSingleButtons(
    onOkClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Save Button
        Button(
            onClick = onOkClick,
            modifier = Modifier
                .width(150.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(stringResource(Res.string.save))
        }

    }
}

@Composable
fun CommonSingleButtonsBottomString(
    onOkClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    textSize: Int = 14
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center   // 👈 aligns to EditText center
    ) {
        Button(
            onClick = onOkClick,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = text,
                fontSize = textSize.sp,
                fontFamily = FontFamily(Font(Res.font.roboto_medium))
            )
        }
    }
}


fun Modifier.withBottomBarPadding(extra: Int = 80) = this.padding(bottom = extra.dp)


@Composable
fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = Int.MAX_VALUE,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.type_here),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = textview_color,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = editext_bg_color,
    borderColor: Color = boderColor,
    maxLines: Int = 1,
//    disabledBackgroundColor: Color = Color(0xFFE0E0E0),
    disabledBackgroundColor: Color = formborder,
    modifier: Modifier = Modifier, // ✅ ADDED THIS
    placeholderTextSize: Int = 15
) {

    Column(modifier = modifier) {            // ✅ APPLY modifier HERE

        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            enabled = isEnable,
            readOnly = isReadable,
            value = value,
            onValueChange = { newValue ->
                val filteredValue = when (inputType) {
                    KeyboardType.Number, KeyboardType.Phone -> newValue.filter { it.isDigit() }
                    else -> newValue
                }
                if (filteredValue.length <= maxLength) {
                    onValueChange(filteredValue)
                }
            },
            trailingIcon = trailingIcon,
            placeholder = {
                ReusableTextView(
                    text = placeholder,
                    fontSize = placeholderTextSize,
                    textColor = placeholderColor,
                    textAlignment = TextAlign.Start
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .height(48.dp),
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                textAlign = TextAlign.Start
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = if (isEnable) backgroundColor else disabledBackgroundColor,
                unfocusedContainerColor = if (isEnable) backgroundColor else disabledBackgroundColor,
                disabledContainerColor = disabledBackgroundColor,
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                cursorColor = Color.Black
            ),
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = inputType
            )
        )
    }
}

@Composable
fun FormFields(

    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = Int.MAX_VALUE,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.type_here),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = textview_color,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = editext_bg_color,
    borderColor: Color = boderColor,
    maxLines: Int = 1,
//    disabledBackgroundColor: Color = Color(0xFFE0E0E0),
    disabledBackgroundColor: Color = formborder,
    modifier: Modifier = Modifier,
    placeholderTextSize: Int = 15
) {


        OutlinedTextField(
            enabled = isEnable,
            readOnly = isReadable,
            value = value,
            onValueChange = { newValue ->
                val filteredValue = when (inputType) {
                    KeyboardType.Number, KeyboardType.Phone -> newValue.filter { it.isDigit() }
                    else -> newValue
                }
                if (filteredValue.length <= maxLength) {
                    onValueChange(filteredValue)
                }
            },
            trailingIcon = trailingIcon,
            placeholder = {
                ReusableTextView(
                    text = placeholder,
                    fontSize = placeholderTextSize,
                    textColor = placeholderColor,
                    textAlignment = TextAlign.Start
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .height(48.dp),
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                textAlign = TextAlign.Start
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = if (isEnable) backgroundColor else disabledBackgroundColor,
                unfocusedContainerColor = if (isEnable) backgroundColor else disabledBackgroundColor,
                disabledContainerColor = disabledBackgroundColor,
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                cursorColor = Color.Black
            ),
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = inputType
            )
        )

}


@Composable
fun DynamicCheckBox(
    label: String,
    isChecked: Boolean,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!isChecked) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { onCheckedChange(it) }
        )
        ReusableTextView(
            text = label,
            fontSize = 13,
            fontFamily = fontFamily,
                    textColor = black,
        )
    }
}


@OptIn(ExperimentalLayoutApi::class, ExperimentalResourceApi::class)
@Composable
fun MultiSelectDropdownWithChips(
    label: String,
    options: List<String>,
    selectedOptions: List<String>,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    onSelectionChange: (List<String>) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        ReusableTextView(
            text = label,
            fontFamily = fontFamily,
            fontSize = 14,
            textColor = desire_orange
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(min = 52.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .heightIn(50.dp)
                    .background(bgColor, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (selectedOptions.isEmpty()) {
                    ReusableTextView(
                        text = "Select",
                        textColor = Color.Gray,
                        fontFamily = fontFamily,
                        fontSize = 14
                    )
                } else {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        selectedOptions.forEach { option ->
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFEDEDED),
                                shadowElevation = 1.dp
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(text = option, color = Color(0xFF323232), fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Icon(
                                        painter = painterResource(Res.drawable.ic_close),
                                        contentDescription = "Remove",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .clickable {
                                                onSelectionChange(selectedOptions - option)
                                            }
                                    )
                                }
                            }
                        }
                    }
                }

                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown",
                    tint = Color.Black
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = selectedOptions.contains(option),
                                onCheckedChange = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(option)
                        }
                    },
                    onClick = {
                        val newList = if (selectedOptions.contains(option)) {
                            selectedOptions - option
                        } else {
                            selectedOptions + option
                        }
                        onSelectionChange(newList)
                    }
                )
            }
        }
    }
}

@Composable
fun FormDatePicker(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.dd_mm_yy),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = textview_color,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = editext_bg_color,
    borderColor: Color = boderColor,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor
        )
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            enabled = isEnable,
            readOnly = true,
            value = value,
            onValueChange = onValueChange,
            trailingIcon = trailingIcon,
            placeholder = {
                ReusableTextView(
                    text = placeholder,
                    fontSize = 15,
                    textColor = placeholderColor
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { onClick() },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                color = Color.Black
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                disabledContainerColor = backgroundColor,
                focusedBorderColor = borderColor,
                unfocusedBorderColor = borderColor,
                cursorColor = Color.Black
            )
        )
    }
}


@Composable
fun timePicker(
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.hh_mm),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = bgColor,
    borderColor: Color = boderColor
) {

    OutlinedTextField(
        enabled = isEnable,
        readOnly = isReadable,
        value = value,
        onValueChange = onValueChange,
        trailingIcon = trailingIcon,
        placeholder = {
            ReusableTextView(
                text = placeholder,
                fontSize = 15,
                textColor = placeholderColor,
                textAlignment = TextAlign.Start
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .heightIn(min = 45.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(Res.font.roboto_medium)),
            textAlign = TextAlign.Start,
            color = Color.Black
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = inputType
        )
    )
}

/*
@Composable
fun DynamicAlertDialog(
    showDialog: Boolean,
    title: String = stringResource(Res.string.app_name),
    message: String = "",
    confirmText: String = "OK",
    dismissText: String? = null,
    onConfirm: () -> Unit = {},
    onDismiss: (() -> Unit)? = null
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss?.invoke() ?: onConfirm() },
            title = { ReusableTextView(title) },
            text = { ReusableTextView(message) },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    ReusableTextView(confirmText, textColor = black,)
                }
            },
            dismissButton = dismissText?.let {
                {
                    TextButton(onClick = { onDismiss?.invoke() }) {
                        ReusableTextView(dismissText)
                    }
                }
            }
        )
    }
}
*/

@Composable
fun CustomAlertDialog(
    showDialog: Boolean,
    title: String = stringResource(Res.string.app_name),
    message: String = "",
    confirmText: String = "OK",
    onConfirm: () -> Unit = {}
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { onConfirm() },
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .widthIn(min = 400.dp, max = 500.dp)
                    .heightIn(max = 500.dp)
                    .background(lightGrey, RoundedCornerShape(16.dp))
                    .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .widthIn(400.dp)
                        .background(lightGrey, shape = RoundedCornerShape(16.dp))
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().background(
                            teal700,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                            .heightIn(50.dp)
                    ) {
                        ReusableTextView(
                            text = title,
                            fontSize = 20,
                            fontWeight = FontWeight.Bold,
                            textColor = white,
                            textAlignment = TextAlign.Center,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                    Spacer(Modifier.height(30.dp))

                    ReusableTextView(
                        text = message,
                        fontSize = 18,
                        textColor = black,
                        textAlignment = TextAlign.Center,
                        fontFamily = FontFamily(Font(Res.font.roboto_medium)),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Spacer(Modifier.height(20.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(
                            onClick = { onConfirm() },
                            colors = ButtonDefaults.buttonColors(assureOrange),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .width(150.dp)
                                .height(45.dp)
                        ) {
                            ReusableTextView(text = confirmText.uppercase(), textColor = white)
                        }
                    }

                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun ProgressDialog(
    showDialog: Boolean,
    message: String = "Please wait..."
) {
    if (showDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .wrapContentHeight()
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = desire_orange)

                Spacer(modifier = Modifier.height(12.dp))

                ReusableTextView(
                    text = message,
                    textColor = Color.Black,
                    fontSize = 16,
                    textAlignment = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun DynamicRadioButton(
    options: List<String>,
    label: String,
    initialSelection: Int? = null,
    orientation: Orientation = Orientation.Horizontal,
    onOptionSelected: (Int) -> Unit,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
) {

    var selectedOptionIndex by remember {
        mutableStateOf(initialSelection ?: 0)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        ReusableTextView(
            text = label,
            fontSize = 14,
            fontFamily = fontFamily,
            textColor = desire_orange,
            isMandatory = 1
        )

        Spacer(modifier = Modifier.height(8.dp))

        val layoutModifier = Modifier.fillMaxWidth()
        val radioLayout: @Composable () -> Unit = {
            options.forEachIndexed { index, option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedOptionIndex = index
                            onOptionSelected(index)
                        }
                        .padding(4.dp)
                ) {
                    RadioButton(
                        selected = (selectedOptionIndex == index),
                        onClick = {
                            selectedOptionIndex = index
                            onOptionSelected(index)
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Black,
                            unselectedColor = Color.Gray
                        )
                    )
                    ReusableTextView(
                        text = option,
                        fontSize = 14,
                        textColor = black,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }

        if (orientation == Orientation.Horizontal) {
            Row(modifier = layoutModifier) { radioLayout() }
        } else {
            Column(modifier = layoutModifier) { radioLayout() }
        }
    }
}

enum class Orientation {
    Horizontal, Vertical
}

@Composable
fun FormSpinner1(
    label: String,
    options: List<String>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = desire_orange,
    backgroundColor: Color = bgColor,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    borderColor: Color = boderColor
) {
    var expanded by remember { mutableStateOf(false) }

    val finalOptions = remember(options) {
        val list = mutableListOf("Select")
        options?.let { list.addAll(it) }
        list
    }


    val selectedText = if (selectedOption in finalOptions.indices)
        finalOptions[selectedOption!!]
    else
        "Select"

    Column(modifier = modifier) {
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp)
                .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .background(backgroundColor, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableTextView(
                    text = selectedText,
                    textColor = textColor,
                    fontFamily = fontFamily
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                finalOptions.forEachIndexed { index, option ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = option,
                                textColor = black,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            onOptionSelected(index)
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

/*@Composable
fun FillStateSpinner(
    label: String,
    options: List<StateEntity>?,
    selectedOption: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = desire_orange,
    backgroundColor: Color = bgColor,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    borderColor: Color = boderColor
) {
    var expanded by remember { mutableStateOf(false) }

    val optionList = remember(options) {
        val list = mutableListOf<Pair<Int, String>>()
        list.add(0 to "Select")
        options?.forEach { list.add((it.stateId to it.stateName.toString()) as Pair<Int, String>) }
        list
    }

    val selectedText = optionList.find { it.first == selectedOption }?.second ?: "Select"

    Column(modifier = modifier) {
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(min = 52.dp)
                .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .background(backgroundColor, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableTextView(
                    text = selectedText,
                    textColor = textColor,
                    fontFamily = fontFamily
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(Color.White).fillMaxWidth()
            ) {
                optionList.forEach { (id,option) ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = option,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            onOptionSelected(id)
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}*/

@Composable
fun DrawerItem(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    icon: Painter
) {
    val background =
        if (selected) desire_orange.copy(alpha = 0.1f)
        else MaterialTheme.colorScheme.surface

    val textColor =
        if (selected) black
        else MaterialTheme.colorScheme.onSurface

    val iconTint: Color =
        if (selected) desire_orange
        else Color.Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = icon,
                contentDescription = label,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 12.dp),
                colorFilter = ColorFilter.tint(iconTint)
            )
            ReusableTextView(label, textColor = textColor)
        }
    }
}


/*@Composable
fun FillLookUpSpinner(
    label: String,
    options: List<LookUpValueEntity>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = desire_orange,
    backgroundColor: Color = bgColor,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    borderColor: Color = boderColor
) {
    var expanded by remember { mutableStateOf(false) }

    val optionList = remember(options) {
        val list = mutableListOf<Pair<Int, String>>() // Pair<id, name>
        list.add(0 to "Select")
        options?.forEach { list.add((it.lookup_PK to it.lookName.toString()) as Pair<Int, String>) }
        list
    }


    val selectedText = optionList.find { it.first == selectedOption }?.second ?: "Select"

    Column(modifier = modifier) {
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp)
                .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .background(backgroundColor, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableTextView(
                    text = selectedText,
                    textColor = textColor,
                    fontFamily = fontFamily
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                optionList.forEach { (id, name) ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = name,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            onOptionSelected(id)
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}*/

@Composable
fun FormSpinner(
    label: String,
    options: List<String>?,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = textview_color,
    backgroundColor: Color = editext_bg_color,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    borderColor: Color = boderColor
) {
    var expanded by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0) }

    val optionsList = remember(options) {
        val list = mutableListOf("Select")
        options?.forEach { list.add(it) }
        list
    }

    Column(modifier = modifier) {

        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .clickable { expanded = true }
                .onGloballyPositioned {
                    spinnerWidth = it.size.width
                },
            contentAlignment = Alignment.CenterStart
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ReusableTextView(
                    text = selectedOption.ifEmpty { "Select" },
                    textColor = textColor,
                    fontFamily = fontFamily
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { spinnerWidth.toDp() })
                    .background(CardColor)
            ) {
                optionsList.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = option,
                                textColor = Color.Black,
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}




/*@OptIn(ExperimentalLayoutApi::class, ExperimentalResourceApi::class)
@Composable
fun MultiSelectDropdownWithChips1(
    label: String,
    options: List<LookUpValueEntity>,
    selectedOptions: List<LookUpValueEntity>,
    onSelectionChange: (List<LookUpValueEntity>) -> Unit,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        ReusableTextView(
            text = label,
            fontFamily = fontFamily,
            fontSize = 14,
            textColor = desire_orange
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(min = 52.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .background(Color.White))
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .heightIn(50.dp)
                    .background(bgColor, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                if (selectedOptions.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        ReusableTextView(
                            text = "Select",
                            textColor = Color.Gray,
                            fontFamily = fontFamily,
                            fontSize = 14
                        )
                    }
                } else {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        selectedOptions.forEach { option ->
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = Color(0xFFEDEDED),
                                shadowElevation = 1.dp
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(text = option.lookName.toString(), color = Color(0xFF323232), fontSize = 12.sp)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Icon(
                                        painter = painterResource(Res.drawable.ic_close),
                                        contentDescription = "Remove",
                                        modifier = Modifier.size(20.dp).clickable {
                                            onSelectionChange(selectedOptions - option)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }

                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown",
                    tint = Color.Black
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = selectedOptions.contains(option),
                                onCheckedChange = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(option.lookName.toString())
                        }
                    },
                    onClick = {
                        val newList = if (selectedOptions.contains(option)) {
                            selectedOptions - option
                        } else {
                            selectedOptions + option
                        }
                        onSelectionChange(newList)
                    }
                )
            }
        }
    }
}*/



val ALLOWED_USERNAME_CHARS: Set<Char> =
    ('a'..'z').toSet() +
            ('A'..'Z').toSet() +
            ('0'..'9').toSet() +
            setOf('@', '.')
val ALLOWED_PASSWORD_CHARS: Set<Char> =
    ('a'..'z').toSet() +
            ('A'..'Z').toSet() +
            ('0'..'9').toSet() +
            setOf('@', '.', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')')

fun filterAllowed(input: String, allowed: Set<Char>): String {
    return input.filter { it in allowed }
}

@Composable
fun UsernameField(
    label: String = stringResource(Res.string.username),
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = 50
) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
        Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                val updated = updateFilteredInput(
                    oldValue = value,
                    newValue = newValue,
                    allowed = ALLOWED_USERNAME_CHARS,
                    maxLength = maxLength
                )
                onValueChange(updated)
            },
            placeholder = { Text(stringResource(Res.string.enter_here), color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = LoginTextBox,
                focusedContainerColor = LoginTextBox,
                unfocusedBorderColor = LoginTextBox,
                focusedBorderColor = LoginTextBox,
                cursorColor = Color.White
            ),
            textStyle = TextStyle(color = Color.White),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            )
        )
    }
}

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    label: String = stringResource(Res.string.password),
    maxLength: Int = 50
) {
    var passwordVisible by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
        Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { newValue ->
//                onPasswordChange(filterAllowed(newValue, ALLOWED_PASSWORD_CHARS))
                val filtered = filterAllowed(newValue, ALLOWED_PASSWORD_CHARS)
                val limited = filtered.take(maxLength)
                onPasswordChange(limited)

            },
            placeholder = { Text(stringResource(Res.string.enter_here), color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = LoginTextBox,
                focusedContainerColor = LoginTextBox,
                unfocusedBorderColor = LoginTextBox,
                focusedBorderColor = LoginTextBox,
                cursorColor = Color.White
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            Icons.Default.Visibility
                        else
                            Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = Color.White
                    )
                }
            },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            textStyle = TextStyle(color = Color.White),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Composable
fun SimpleOtp(
    otp: String,
    onOtpChange: (String) -> Unit
) {
    val focusRequesters = remember { List(4) { FocusRequester() } }

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()   // Auto focus first box
    }

    Text(
        text = stringResource(Res.string.enter_otp),
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp
        ),
    )

    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        (0 until 4).forEach { index ->
            val char = otp.getOrNull(index)?.toString() ?: ""

            OutlinedTextField(
                value = char,
                onValueChange = { newValue ->
                    // allow only digits
                    if (newValue.length <= 1 && (newValue.isEmpty() || newValue[0].isDigit())) {

                        val newOtp = otp.padEnd(4, ' ').toCharArray()

                        // Update value
                        newOtp[index] = if (newValue.isEmpty()) ' ' else newValue[0]

                        onOtpChange(newOtp.concatToString().trimEnd())

                        // Move to next box automatically
                        if (newValue.isNotEmpty() && index < 3) {
                            focusRequesters[index + 1].requestFocus()
                        }

                        // Move to previous on delete
                        if (newValue.isEmpty() && index > 0) {
                            focusRequesters[index - 1].requestFocus()
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = Color.Gray,
                    cursorColor = Color.Black
                ),
                singleLine = true,
                modifier = Modifier
                    .width(55.dp)
                    .height(60.dp)
                    .focusRequester(focusRequesters[index]),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}

fun updateFilteredInput(
    oldValue: String,
    newValue: String,
    allowed: Set<Char>,
    maxLength: Int
): String {
    return if (newValue.length > oldValue.length) {
        val added = newValue.last()

        if (added in allowed && oldValue.length < maxLength) {
            oldValue + added
        } else {
            oldValue
        }
    } else {
        newValue
    }
}

@Composable
fun DashboardCardItem(
    number: String,
    label: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFB8EEDC),
    onClick: () -> Unit = {}
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // CARD + ICON Group
        Box(
            modifier = Modifier.size(75.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 10.dp)        // Same offset
                    .clickable { onClick() },
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number,
                        fontSize = 20.sp,
                        color = Color(0xFF0A6B78),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // ICON on Top Left
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(lightgreens.copy(alpha = 0.6f), CircleShape)
                    .align(Alignment.TopStart)
                    .border(1.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = Color(0xFF0A6B78),
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // FIXED LABEL
        Text(
            text = label,
            fontSize = 8.sp,
            fontWeight = FontWeight.Medium,
            color =lightgreens,
            textAlign = TextAlign.Start,
            maxLines = 1,
        )
    }
}

@Composable
fun CommonSingleButtons(
    onOkClick: () -> Unit,
    backgroundColor: Color,
    text: String = "",
    textColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(end = 25.dp, start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onOkClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = lightgreens
            ),
            shape = RoundedCornerShape(18.dp)
        ) {
            ReusableTextView(
                text = text,
                textColor =textColor ,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun TripleIconSlider(
    items: List<Triple<Painter, Painter, Painter>>,
    modifier: Modifier = Modifier,
    bgColor: Color = Color(0xFFDDEFFF)
) {
    LazyRow(
        modifier = modifier.height(170.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        items(items.size) { index ->

            val (leftIcon, centerIcon, rightIcon) = items[index]

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(160.dp)
                    .background(bgColor, RoundedCornerShape(25.dp)),
                contentAlignment = Alignment.Center
            ) {


                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                ) {


                    Icon(
                        painter = centerIcon,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(22.dp)
                            .align(Alignment.TopCenter)
                    )


                    Icon(
                        painter = leftIcon,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.BottomStart)
                    )


                    Icon(
                        painter = rightIcon,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd)
                    )
                }


                Text(
                    text = "INFORMATION",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 8.dp)
                )
            }
        }
    }
}
@Composable
fun ReusableCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    cornerRadius: Int = 12,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(backgroundColor),
        shape = RoundedCornerShape(cornerRadius.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 15.dp)
        ) {
            content()
        }
    }
}

@Composable
fun ReusableCards(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    cornerRadius: Int = 12,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(backgroundColor),
        shape = RoundedCornerShape(cornerRadius.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 15.dp)
        ) {
            content()
        }
    }
}



@Composable
fun GroupCardUI(
    item: GroupCardData,
    onCardClick: (GroupCardData) -> Unit
) {
    ReusableCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable { onCardClick(item) },
        backgroundColor = CardColor
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

                    LabelValueText(label = "Group Name :", value = item.groupName)
                    LabelValueText(label = "No. of Customers :", value = item.customers.toString())
                    LabelValueText(label = "Village Name :", value = item.village)
                    LabelValueText(label = "Loan Officer :", value = item.officer)
                    LabelValueText(label = "Group formation date :", value = item.formation)
                }

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

                    LabelValueText(label = "Disbursement date :", value = item.disbursement)
                    LabelValueText(label = "Center :", value = item.center)
                    LabelValueText(label = "Meeting day :", value = item.meetingDay)
                    LabelValueText(label = "Next meeting Date :", value = item.nextMeeting)
                }
            }
        }
    }
}

@Composable
fun <T : Any> FillDynamicSpinner(
    label: String = "",
    options: List<T>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    getOptionId: (T) -> Int,
    getOptionLabel: (T) -> String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CardColor,
    textColor: Color = Color.Black,
    focusRequester: FocusRequester? = null,
    bringIntoViewRequester: BringIntoViewRequester? = null,
    placeholder:   String = stringResource(Res.string.spinner_select)
) {
    var expanded by remember { mutableStateOf(false) }
    var hasFocus by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0) }

    LaunchedEffect(hasFocus) {
        if (hasFocus) {
            delay(120)
            bringIntoViewRequester?.bringIntoView()
            expanded = true
        }
    }

    val displayText = if (selectedOption == null || selectedOption == 0) {
        placeholder
    } else {
        options?.find { getOptionId(it) == selectedOption }?.let { getOptionLabel(it) } ?: placeholder
    }

    Column(modifier = modifier.fillMaxWidth()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    spinnerWidth = coordinates.size.width
                }
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(backgroundColor, RoundedCornerShape(8.dp))
                    .focusTarget()
                    .focusable()
                    .clickable { expanded = true }
                    .then(if (focusRequester != null) Modifier.focusRequester(focusRequester) else Modifier)
                    .onFocusChanged { state -> hasFocus = state.isFocused }
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ReusableTextView(text = displayText, textColor = textColor)

                Icon(
                  painter  = painterResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = "Dropdown",
                    tint = textColor
                )
            }


            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { spinnerWidth.toDp() })
                    .background(CardColor)
            ) {

                DropdownMenuItem(
                    text = { Text(placeholder) },
                    onClick = {
                        onOptionSelected(0)
                        expanded = false
                    }
                )

                options?.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(getOptionLabel(item)) },
                        onClick = {
                            onOptionSelected(getOptionId(item))
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun LabelValueText(label: String, value: String) {
    Row {
        ReusableTextViewGrayCard (
            text = label,
            )
        Spacer(modifier = Modifier.width(4.dp))
        ReusableTextViewBlackCard(
            text = value,


        )
    }
}
@Composable
fun CustomerItemCard(
    customer: CustomerData,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onCardClick: (CustomerData) -> Unit
) {

    ReusableCards(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                if (checked) {
                    onCardClick(customer)
                }
            },
        backgroundColor = CardColor,
        cornerRadius = 12
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ✔ Checkbox
            Checkbox(
                checked = checked,
                onCheckedChange = { onCheckedChange(it) },
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryDark,
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                )
            )


            Column(
                modifier = Modifier.weight(1f)
            ) {
                LabelValueText("Customer ID :", "New Customer")
                LabelValueText("Name :", customer.name)
                LabelValueText("Mobile number :", customer.mobile)
                LabelValueText("Loan Amount :", "Rs ${customer.amount}")
            }

            Spacer(modifier = Modifier.width(10.dp))

            // ✔ 2 Gray Boxes
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .background(Color.Gray, RoundedCornerShape(6.dp))
                )
                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .background(Color.Gray, RoundedCornerShape(6.dp))
                )
            }
        }
    }
}

@Composable
fun CameraPreviewField(
    image: Uri?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholderRes: DrawableResource = Res.drawable.document_icon
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        // Pure Image Button with NO rounded background
        Icon(
            painter = painterResource(Res.drawable.camera),
            contentDescription = "Camera Button",
            modifier = Modifier
                .size(25.dp)
                .clickable { onClick() },
            tint = Color.Unspecified   // remove tint if needed
        )

        // Preview Image
        ReusableImageView(
            painter = if (image != null)
                rememberAsyncImagePainter(model = image)
            else
                painterResource(placeholderRes),
            contentDescription = "Image Preview",
            modifier = Modifier
                .size(100.dp)
                .border(2.dp, Color.White),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ReusableTextViewGrayCard(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Gray,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.W500,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    backgroundColor: Color = Color.Transparent,
    cornerRadius: Dp = 0.dp,
    padding: Dp = 0.dp,
    style: TextStyle = TextStyle.Default,
    textAlignment: TextAlign = TextAlign.Start,
    isMandatory: Int = 0,
    asteriskColor: Color = Color.Red
) {
    val displayText = if (isMandatory == 1) {
        buildAnnotatedString {
            append(text)
            withStyle(style = SpanStyle(color = asteriskColor)) {
                append(" *")
            }
        }
    } else {
        AnnotatedString(text)
    }

    Text(
        text = displayText,
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding),
        style = style.copy(
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        ),
        textAlign = textAlignment
    )
}

@Composable
fun ReusableTextViewBlackCard(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium)),
    backgroundColor: Color = Color.Transparent,
    cornerRadius: Dp = 0.dp,
    padding: Dp = 0.dp,
    style: TextStyle = TextStyle.Default,
    textAlignment: TextAlign = TextAlign.Start,
    isMandatory: Int = 0,
    asteriskColor: Color = Color.Red
) {
    val displayText = if (isMandatory == 1) {
        buildAnnotatedString {
            append(text)
            withStyle(style = SpanStyle(color = asteriskColor)) {
                append(" *")
            }
        }
    } else {
        AnnotatedString(text)
    }

    Text(
        text = displayText,
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding),
        style = style.copy(
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        ),
        textAlign = textAlignment
    )


}
@Composable
fun ReusablePaymentDropdown(
    selectedValue: String,
    options: List<String>,
    onValueSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 32.dp,
    backgroundColor: Color = Color(0xFFBBDEFB),
    cornerRadius: Dp = 4.dp,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_medium))
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {

        // SAME BUTTON AS YOUR OLD CODE
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor
            ),
            shape = RoundedCornerShape(cornerRadius),
            contentPadding = PaddingValues(horizontal = 2.dp, vertical = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = selectedValue,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = fontFamily
                )

                Text("▼", fontSize = 10.sp, color = Color.Black)
            }
        }

        // DROPDOWN MENU
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            option,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    },
                    onClick = {
                        onValueSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CommonDivider(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    thickness: Dp = 2.dp,
    startPadding: Dp = 5.dp,
    endPadding: Dp = 5.dp
) {
    Box(
        modifier = modifier
            .padding(startPadding, 0.dp, endPadding, 0.dp)
            .height(thickness)
            .background(color)
    )
}





