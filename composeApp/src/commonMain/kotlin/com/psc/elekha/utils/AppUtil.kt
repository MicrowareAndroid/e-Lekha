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
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.psc.elekha.model.SliderItem
import com.psc.elekha.response.MasterResponse
import com.psc.elekha.ui.screen.gtrlist.CustomerData
import com.psc.elekha.ui.screen.gtrlist.GroupCardData
import com.psc.elekha.ui.theme.CardColor
import com.psc.elekha.ui.theme.LoginTextBox
import com.psc.elekha.ui.theme.PrimaryDark
import com.psc.elekha.ui.theme.appleblue
import com.psc.elekha.ui.theme.bgColor
import com.psc.elekha.ui.theme.black
import com.psc.elekha.ui.theme.boderColor
import com.psc.elekha.ui.theme.btn_color
import com.psc.elekha.ui.theme.desire_orange
import com.psc.elekha.ui.theme.formborder
import com.psc.elekha.ui.theme.hintColor
import com.psc.elekha.ui.theme.homeTopIconsBg
import com.psc.elekha.ui.theme.lightGrey
import com.psc.elekha.ui.theme.loginBg
import com.psc.elekha.ui.theme.loginTitle
import com.psc.elekha.ui.theme.loginbgGradientBottom
import com.psc.elekha.ui.theme.repaymentColor
import com.psc.elekha.ui.theme.rose
import com.psc.elekha.ui.theme.teal700
import com.psc.elekha.ui.theme.text_fiiled_color
import com.psc.elekha.ui.theme.textview_color
import com.psc.elekha.ui.theme.toolbar_color
import com.psc.elekha.ui.theme.transaperentBgColor
import com.psc.elekha.ui.theme.white
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.add_more_family
import e_lekha.composeapp.generated.resources.app_name
import e_lekha.composeapp.generated.resources.cancel
import e_lekha.composeapp.generated.resources.dd_mm_yy
import e_lekha.composeapp.generated.resources.enter_here
import e_lekha.composeapp.generated.resources.enter_otp
import e_lekha.composeapp.generated.resources.existing_customer
import e_lekha.composeapp.generated.resources.gtr_next_meeting
import e_lekha.composeapp.generated.resources.hh_mm
import e_lekha.composeapp.generated.resources.ic_arrow_drop_down
import e_lekha.composeapp.generated.resources.inter_medium
import e_lekha.composeapp.generated.resources.inter_regular
import e_lekha.composeapp.generated.resources.new_registration
import e_lekha.composeapp.generated.resources.password
import e_lekha.composeapp.generated.resources.roboto_medium
import e_lekha.composeapp.generated.resources.roboto_regular
import e_lekha.composeapp.generated.resources.save
import e_lekha.composeapp.generated.resources.select_center
import e_lekha.composeapp.generated.resources.select_customer
import e_lekha.composeapp.generated.resources.select_customer_id
import e_lekha.composeapp.generated.resources.select_customer_loan
import e_lekha.composeapp.generated.resources.select_customer_mobile
import e_lekha.composeapp.generated.resources.select_customer_name
import e_lekha.composeapp.generated.resources.select_customer_ok
import e_lekha.composeapp.generated.resources.select_customer_please
import e_lekha.composeapp.generated.resources.select_disbursement
import e_lekha.composeapp.generated.resources.select_formation
import e_lekha.composeapp.generated.resources.select_group
import e_lekha.composeapp.generated.resources.select_loan
import e_lekha.composeapp.generated.resources.select_meeting
import e_lekha.composeapp.generated.resources.select_village
import e_lekha.composeapp.generated.resources.spinner_select
import e_lekha.composeapp.generated.resources.type_here
import e_lekha.composeapp.generated.resources.username
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.todayIn
import kotlinx.serialization.decodeFromString
import nl.adaptivity.xmlutil.serialization.XML
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import com.psc.elekha.model.NameParts
import com.psc.elekha.ui.theme.greys

@Composable
fun ReusableTextView(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
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
fun ReusableTextViewes(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = appleblue,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
    backgroundColor: Color = Color.Transparent,
    cornerRadius: Dp = 0.dp,
    padding: Dp = 0.dp,
    textAlignment: TextAlign = TextAlign.Start,
    isMandatory: Int = 0,
    asteriskColor: Color = Color.Red
) {

    val displayText = if (isMandatory == 1) {
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = asteriskColor,
                    fontWeight = FontWeight.Bold
                )
            ) {
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
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(padding),
        style = TextStyle(
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
    fontWeight: FontWeight = FontWeight.Medium,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableTopBar(
    title: String,
    backgroundColor: Color = appleblue,
    titleColor: Color = Color.White,
    navigationIcon: Painter? = null,
    onNavigationClick: (() -> Unit)? = null,
    actionIcon: Painter? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
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
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
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
    saveText: String = stringResource(Res.string.save),
    closeText: String = stringResource(Res.string.cancel),
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(1.dp)
        ) {
            Text(saveText, fontFamily = FontFamily(Font(Res.font.inter_medium)))
        }

        Spacer(modifier = Modifier.width(5.dp))

        Button(
            onClick = onCloseClick,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(1.dp)
        ) {
            Text(closeText, fontFamily = FontFamily(Font(Res.font.inter_medium)))
        }
    }
}

@Composable
fun CommonSaveButton(
    onSaveClick: () -> Unit,
    saveText: String = stringResource(Res.string.save),
    backgroundColor: Color = btn_color,
    contentColor: Color = Color.Black
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
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 6.dp,
                focusedElevation = 4.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            ),
            shape = RoundedCornerShape(1.dp)
        ) {
            Text(saveText, fontFamily = FontFamily(Font(Res.font.inter_medium)))
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
            Text(
                stringResource(Res.string.save),
                fontFamily = FontFamily(Font(Res.font.inter_medium))
            )
        }

    }
}

@Composable
fun CommonSingleButtonsBottomString(
    onOkClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    textSize: Int = 18
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onOkClick,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = btn_color,
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 6.dp,
                focusedElevation = 4.dp
            ),
            shape = RoundedCornerShape(1.dp)
        ) {
            Text(
                text = text,
                fontSize = textSize.sp,
                fontFamily = FontFamily(Font(Res.font.inter_medium))
            )
        }
    }
}


fun Modifier.withBottomBarPadding(extra: Int = 80) = this.padding(bottom = extra.dp)

@Composable
fun FormFieldCompact(
    label: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = Int.MAX_VALUE,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.type_here),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = black,
    placeholderColor: Color = greys,
    backgroundColor: Color = text_fiiled_color,
    borderColor: Color = boderColor,
    disabledBackgroundColor: Color = formborder,
    maxLines: Int = 1,
    modifier: Modifier = Modifier,
    placeholderTextSize: Int = 12
) {

    Column(modifier) {

        if (!label.isNullOrEmpty()) {
            ReusableTextView(
                text = label,
                fontSize = 14,
                textColor = labelColor,
                fontFamily = FontFamily(Font(Res.font.inter_regular))

            )
        }

        Spacer(Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    color = if (isEnable) backgroundColor else disabledBackgroundColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .clickable(enabled = isEnable) { /* triggers keyboard focus */ },
            contentAlignment = Alignment.CenterStart
        ) {

            BasicTextField(
                value = value,
                enabled = isEnable,
                readOnly = isReadable,
                onValueChange = { newValue ->
                    val filtered = when (inputType) {
                        KeyboardType.Number, KeyboardType.Phone -> newValue.filter { it.isDigit() }
                        else -> newValue
                    }
                    if (filtered.length <= maxLength) onValueChange(filtered)
                },

                textStyle = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                    textAlign = TextAlign.Start
                ),

                maxLines = maxLines,
                keyboardOptions = KeyboardOptions(keyboardType = inputType),

                modifier = Modifier
                    .matchParentSize()
                    .padding(horizontal = 12.dp, vertical = 8.dp),

                decorationBox = { innerTextField ->

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (value.isEmpty()) {
                                ReusableTextView(
                                    text = placeholder,
                                    fontSize = placeholderTextSize,
                                    textColor = placeholderColor
                                )
                            }
                            innerTextField()
                        }

                        if (trailingIcon != null) {
                            trailingIcon()
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun FilterFieldCompact(
    label: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = Int.MAX_VALUE,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.type_here),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = black,
    placeholderColor: Color = Color.Black,
    backgroundColor: Color = white,
    borderColor: Color = rose,
    disabledBackgroundColor: Color = formborder,
    maxLines: Int = 1,
    modifier: Modifier = Modifier,
    placeholderTextSize: Int = 12,
) {

    Column(modifier) {

        if (!label.isNullOrEmpty()) {
            ReusableTextView(
                text = label,
                fontSize = 14,
                textColor = labelColor,
                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    color = if (isEnable) backgroundColor else disabledBackgroundColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .clickable(enabled = isEnable) { /* triggers keyboard focus */ },
            contentAlignment = Alignment.CenterStart
        ) {

            BasicTextField(
                value = value,
                enabled = isEnable,
                readOnly = isReadable,
                onValueChange = { newValue ->
                    val filtered = when (inputType) {
                        KeyboardType.Number, KeyboardType.Phone -> newValue.filter { it.isDigit() }
                        else -> newValue
                    }
                    if (filtered.length <= maxLength) onValueChange(filtered)
                },

                textStyle = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                    textAlign = TextAlign.Start
                ),

                maxLines = maxLines,
                keyboardOptions = KeyboardOptions(keyboardType = inputType),

                modifier = Modifier
                    .matchParentSize()
                    .padding(horizontal = 12.dp, vertical = 8.dp),

                decorationBox = { innerTextField ->

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (value.isEmpty()) {
                                ReusableTextView(
                                    text = placeholder,
                                    fontSize = placeholderTextSize,
                                    textColor = placeholderColor
                                )
                            }
                            innerTextField()
                        }

                        if (trailingIcon != null) {
                            trailingIcon()
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun DynamicCheckBox(
    label: String,
    isChecked: Boolean,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
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


@Composable
fun FormDatePickerCompact(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: String = stringResource(Res.string.dd_mm_yy),
    isEnable: Boolean = true,
    labelColor: Color = black,
    placeholderColor: Color = Color.Black,
    backgroundColor: Color = text_fiiled_color,
    borderColor: Color = boderColor,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        // Label
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = FontFamily(Font(Res.font.inter_regular))
        )

        Spacer(Modifier.height(5.dp))

        // Full custom box (no cut, compact)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)   // ← EXACT height
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .clickable(enabled = isEnable) { onClick() }
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            // BasicTextField for Date
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = false,          // ← readOnly date picker
                readOnly = true,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.inter_regular))
                ),
                decorationBox = { innerTextField ->

                    // Placeholder (never cut)
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            fontSize = 16.sp,
                            color = placeholderColor,
                            fontFamily = FontFamily(Font(Res.font.inter_regular)),
                        )
                    }

                    innerTextField()

                    // Trailing icon
                    if (trailingIcon != null) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            trailingIcon()
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun FormDatePickerCompacts(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: String = stringResource(Res.string.dd_mm_yy),
    isEnable: Boolean = true,
    labelColor: Color = black,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = text_fiiled_color,
    borderColor: Color = boderColor,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        // Label (same as FormDatePicker)
        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .clickable(enabled = isEnable) { onClick() }
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = false,
                readOnly = true,
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 15.sp, // SAME as FormDatePicker
                    color = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.roboto_medium))
                ),
                decorationBox = { innerTextField ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(modifier = Modifier.weight(1f)) {

                            if (value.isEmpty()) {
                                ReusableTextView(
                                    text = placeholder,
                                    fontSize = 15,
                                    textColor = placeholderColor
                                )
                            }

                            innerTextField()
                        }

                        if (trailingIcon != null) {
                            trailingIcon()
                        }
                    }
                }
            )
        }
    }
}


fun isAge18Plus(dob: String): Boolean {
    // Expected format: dd-MM-yyyy or dd/MM/yyyy
    val parts = dob.replace("/", "-").split("-")
    if (parts.size != 3) return false

    val day = parts[0].toIntOrNull() ?: return false
    val month = parts[1].toIntOrNull() ?: return false
    val year = parts[2].toIntOrNull() ?: return false

    val dobDate = LocalDate(year, month, day)
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

    val eighteenthBirthday = dobDate.plus(DatePeriod(years = 18))

    return today >= eighteenthBirthday  // true if 18 or older
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
            fontFamily = FontFamily(Font(Res.font.inter_medium)),
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


@Composable
fun CustomAlertDialog(
    showDialog: Boolean,
    title: String = stringResource(Res.string.app_name),
    message: String = "",
    confirmText: String = stringResource(Res.string.select_customer_ok),
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
                            toolbar_color,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                            .heightIn(50.dp)
                    ) {
                        ReusableTextView(
                            text = title,
                            fontSize = 20,
                            textColor = white,
                            textAlignment = TextAlign.Center,
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        )
                    }

                    Spacer(Modifier.height(10.dp))

                    ReusableTextView(
                        text = message,
                        fontSize = 18,
                        textColor = black,
                        textAlignment = TextAlign.Center,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Spacer(Modifier.weight(0.5f))

                        // Middle 1/3: a box that centers the button inside it
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            CommonSaveButton(
                                onSaveClick = { onConfirm() },
                                saveText = confirmText
                            )
                        }

                        Spacer(Modifier.weight(0.5f))
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
    message: String = stringResource(Res.string.select_customer_please)
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { /* do nothing to prevent dismiss */ },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
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
                    textAlignment = TextAlign.Center,
                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                )
            }
        }
    }
}


@Composable
fun FormSpinner(
    label: String,
    options: List<String>?,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = black,
    backgroundColor: Color = text_fiiled_color,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
    borderColor: Color = boderColor
) {
    var expanded by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0.dp) }

    // FIX: Get density only once in Composable scope
    val density = LocalDensity.current
    val select = stringResource(Res.string.spinner_select)
    val optionsList = remember(options) {
        val list = mutableListOf(select)
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
                .height(40.dp)
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .clickable { expanded = true }
                .onGloballyPositioned { coords ->
                    // SAFE: No composable call inside callback
                    spinnerWidth = with(density) { coords.size.width.toDp() }
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
                    text = selectedOption.ifEmpty { stringResource(Res.string.spinner_select) },
                    textColor = textColor,
                    fontFamily = fontFamily
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = null
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(spinnerWidth)        // FULL WIDTH MATCH
                    .background(Color.White)
            ) {
                optionsList.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = option,
                                textColor = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
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

@Composable
fun FilterSpinner(
    label: String,
    options: List<String>?,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelColor: Color = black,
    backgroundColor: Color = white,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
    borderColor: Color = rose,
    fontWeight: FontWeight = FontWeight.Normal
) {
    var expanded by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0.dp) }

    // FIX: Get density only once in Composable scope
    val density = LocalDensity.current
    val select = stringResource(Res.string.spinner_select)
    val optionsList = remember(options) {
        val list = mutableListOf(select)
        options?.forEach { list.add(it) }
        list
    }

    Column(modifier = modifier) {

        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily,
            fontWeight = fontWeight
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .clickable { expanded = true }
                .onGloballyPositioned { coords ->
                    // SAFE: No composable call inside callback
                    spinnerWidth = with(density) { coords.size.width.toDp() }
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
                    text = selectedOption.ifEmpty { stringResource(Res.string.spinner_select) },
                    textColor = textColor,
                    fontFamily = fontFamily
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = null
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(spinnerWidth)        // FULL WIDTH MATCH
                    .background(Color.White)
            ) {
                optionsList.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = option,
                                textColor = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
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

@Composable
fun <T : Any> FillDynamicSpinners(
    label: String,
    options: List<T>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    getOptionId: (T) -> Int,
    getOptionLabel: (T) -> String,
    modifier: Modifier = Modifier,
    labelColor: Color = black,
    backgroundColor: Color = text_fiiled_color,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.roboto_regular)),
    borderColor: Color = boderColor,
    focusRequester: FocusRequester? = null,
    bringIntoViewRequester: BringIntoViewRequester? = null
) {

    var expanded by remember { mutableStateOf(false) }
    var hasFocus by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0.dp) }

    val density = LocalDensity.current
    val selectText = "Select"

    // ID + Label list
    val optionList = remember(options) {
        buildList {
            add(0 to selectText)
            options?.forEach {
                add(getOptionId(it) to getOptionLabel(it))
            }
        }
    }

    val selectedText =
        optionList.firstOrNull { it.first == selectedOption }?.second ?: selectText

    //  Same behavior as old FillDynamicSpinner
    LaunchedEffect(hasFocus) {
        if (hasFocus) {
            delay(120)
            bringIntoViewRequester?.bringIntoView()
            expanded = true
        }
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
                .height(40.dp) // FormSpinner height
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .focusTarget()
                .focusable()
                .then(
                    if (focusRequester != null)
                        Modifier.focusRequester(focusRequester)
                    else Modifier
                )
                .onFocusChanged { hasFocus = it.isFocused }
                .clickable { expanded = true }
                .onGloballyPositioned {
                    spinnerWidth = with(density) { it.size.width.toDp() }
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
                    text = selectedText,
                    textColor = textColor,
                    fontFamily = fontFamily
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                    contentDescription = null
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(spinnerWidth)
                    .background(Color.White)
            ) {
                optionList.forEach { (id, name) ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = name,
                                modifier = Modifier.fillMaxWidth(),
                                textColor = Color.Black
                            )
                        },
                        onClick = {
                            onOptionSelected(id)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun <T : Any> FillDynamicSpinner(
    label: String,
    options: List<T>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    getOptionId: (T) -> Int,
    getOptionLabel: (T) -> String,
    modifier: Modifier = Modifier,
    labelColor: Color = black,
    backgroundColor: Color = text_fiiled_color,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
    borderColor: Color = desire_orange,
    focusRequester: FocusRequester? = null,
    bringIntoViewRequester: BringIntoViewRequester? = null
) {
    var expanded by remember { mutableStateOf(false) }
    var hasFocus by remember { mutableStateOf(false) }

    LaunchedEffect(hasFocus) {
        if (hasFocus) {
            delay(120)
            bringIntoViewRequester?.bringIntoView()
            expanded = true
        }
    }

    val optionList = remember(options) {
        val list = mutableListOf<Pair<Int, String>>()
        list.add(0 to "Select")
        options?.forEach { list.add(getOptionId(it) to getOptionLabel(it)) }
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
                .heightIn(min = 40.dp)
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .background(backgroundColor, RoundedCornerShape(15.dp))
                .focusTarget()
                .focusable()
                .focusProperties { canFocus = true }
                .then(
                    if (focusRequester != null)
                        Modifier.focusRequester(focusRequester)
                    else Modifier
                )
                .onFocusChanged { state ->
                    hasFocus = state.isFocused
                }
                .clickable { expanded = true },
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
                    imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
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
                                modifier = Modifier.fillMaxWidth(),
                                fontFamily = fontFamily
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
}


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
        ReusableTextViews(
            text = label, fontSize = 16,
            fontWeight = FontWeight.Thin,
            textColor = Color.White,
            fontFamily = FontFamily(Font(Res.font.inter_regular)),
        )
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
            placeholder = { Text(stringResource(Res.string.enter_here), color = hintColor) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(3.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = LoginTextBox,
                focusedContainerColor = LoginTextBox,
                unfocusedBorderColor = LoginTextBox,
                focusedBorderColor = LoginTextBox,
                cursorColor = loginTitle
            ),
            textStyle = TextStyle(color = black),
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
        ReusableTextViews(
            text = label, fontSize = 16, fontWeight = FontWeight.Thin, textColor = Color.White,
            fontFamily = FontFamily(Font(Res.font.inter_regular)),
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { newValue ->
//                onPasswordChange(filterAllowed(newValue, ALLOWED_PASSWORD_CHARS))
                val filtered = filterAllowed(newValue, ALLOWED_PASSWORD_CHARS)
                val limited = filtered.take(maxLength)
                onPasswordChange(limited)

            },
            placeholder = { Text(stringResource(Res.string.enter_here), color = hintColor) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(3.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = LoginTextBox,
                focusedContainerColor = LoginTextBox,
                unfocusedBorderColor = LoginTextBox,
                focusedBorderColor = LoginTextBox,
                cursorColor = loginTitle
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
                        tint = Color.Black
                    )
                }
            },
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            textStyle = TextStyle(color = black),
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
        focusRequesters[0].requestFocus()
    }

    Text(
        text = stringResource(Res.string.enter_otp),
        fontFamily = FontFamily(Font(Res.font.inter_regular)),
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Thin,
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
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.Black
                ),
                singleLine = true,
                modifier = Modifier
                    .width(55.dp)
                    .height(60.dp)
                    .padding(horizontal = 2.dp)
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
    backgroundColor: Color = homeTopIconsBg,
    onClick: () -> Unit = {}
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(70.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 10.dp)
                    .clickable { onClick() }
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    ),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 10.dp, bottom = 8.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(
                        text = number,
                        fontSize = 22.sp,
                        color = white,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(white.copy(alpha = 0.6f), CircleShape)
                    .align(Alignment.TopStart)
                    .border(1.dp, homeTopIconsBg, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),

                    )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // FIXED LABEL
        Text(
            text = label,
            fontSize = 11.sp,
            fontFamily = FontFamily(Font(Res.font.inter_regular)),
            color = black,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Composable
fun CommonSingleButtons(
    onOkClick: () -> Unit,
    backgroundColor: Color,
    text: String = "",
    textColor: Color,
    bgImage: Painter? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .size(115.dp)
                .clickable { onOkClick() },
            shape = RoundedCornerShape(14.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 7.dp),
            border = BorderStroke(1.dp, homeTopIconsBg)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                backgroundColor.copy(alpha = 0.7f),
                                backgroundColor.copy(alpha = 0.0f)

                            )
                        )
                    )
            ) {
                bgImage?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        ReusableTextView(
            text = text,
            textColor = textColor,
            textAlignment = TextAlign.Center,
            fontSize = 18,
            fontFamily = FontFamily(Font(Res.font.inter_medium))
        )
    }
}


@Composable
fun TripleIconSlider(
    items: List<SliderItem>,
    modifier: Modifier = Modifier,
    bgColor: Color = Color(0xFFDDEFFF)
) {
    LazyRow(
        modifier = modifier.height(170.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        items(items.size) { index ->

            val item = items[index]

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(160.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFE4E1),
                                Color(0xFFEAF4FF),
                                Color(0xFFD6E9F8)
                            )
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                ) {

                    Icon(
                        painter = item.center,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(22.dp)
                            .align(Alignment.TopCenter)
                    )

                    Icon(
                        painter = item.left,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.BottomStart)
                    )

                    Icon(
                        painter = item.right,
                        contentDescription = null,
                        tint = Color(0xFF32567A),
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd)
                    )
                }

                Text(
                    text = item.title,
                    color = Color.White,
                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
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
                .padding(horizontal = 8.dp, vertical = 10.dp)
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .clickable { onCardClick(item) },
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = loginBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            // 🔹 HEADER (Group + Customers)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LabelValueText(
                    label = stringResource(Res.string.select_group),
                    value = item.groupName
                )

                LabelValueText(
                    label = stringResource(Res.string.select_customer),
                    value = item.customers.toString()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Divider()

            Spacer(modifier = Modifier.height(6.dp))

            // BODY
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {

                // First 3 items (one under another)
                LabelValueText(
                    label = stringResource(Res.string.select_village),
                    value = item.village
                )

                LabelValueText(
                    label = stringResource(Res.string.select_loan),
                    value = item.officer
                )

                LabelValueText(
                    label = stringResource(Res.string.select_formation),
                    value = item.formation
                )

                // Disbursement + Center (same line)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    LabelValueText(
                        label = stringResource(Res.string.select_disbursement),
                        value = item.disbursement
                    )

                    LabelValueText(
                        label = stringResource(Res.string.select_center),
                        value = item.center
                    )
                }

                // Meeting (below)
                LabelValueText(
                    label = stringResource(Res.string.select_meeting),
                    value = item.meetingDay
                )
            }


            Spacer(modifier = Modifier.height(6.dp))

            // FOOTER
            LabelValueText(
                label = stringResource(Res.string.gtr_next_meeting),
                value = item.nextMeeting,
                highlight = true
            )
        }
    }
}

@Composable
fun HeaderText(
    label: String,
    value: String
) {
    Column {
        ReusableTextView(
            text = "$label :",
            textColor = PrimaryDark
        )
        ReusableTextView(
            text = value,
            textColor = black
        )
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
    placeholder: String = stringResource(Res.string.spinner_select)
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
        options?.find { getOptionId(it) == selectedOption }?.let { getOptionLabel(it) }
            ?: placeholder
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

                ReusableTextView(
                    text = displayText, textColor = textColor,
                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                )

                Icon(
                    painter = painterResource(Res.drawable.ic_arrow_drop_down),
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
                    text = {
                        Text(
                            placeholder,
                            fontFamily = FontFamily(Font(Res.font.inter_regular)),
                        )
                    },

                    onClick = {
                        onOptionSelected(0)
                        expanded = false
                    }
                )

                options?.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                getOptionLabel(item),
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                            )
                        },
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
fun LabelValueText(
    label: String,
    value: String,
    highlight: Boolean = false
) {
    Row {
        ReusableTextView(
            text = "$label : ",
            textColor = PrimaryDark
        )
        ReusableTextView(
            text = value,
            textColor = if (highlight) toolbar_color else black
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
//            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable { onCardClick(customer) },
        backgroundColor = loginBg,
        cornerRadius = 12
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            /* LEFT : Images stacked */
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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

            Spacer(modifier = Modifier.width(12.dp))

            /* CENTER : Details */
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        LabelValueText(
                            stringResource(Res.string.select_customer_id),
                            customer.id.toString()
                        )
                    }

                    Checkbox(
                        checked = checked,
                        onCheckedChange = { onCheckedChange(it) },
                        colors = CheckboxDefaults.colors(
                            checkedColor = PrimaryDark,
                            uncheckedColor = Color.Gray,
                            checkmarkColor = Color.White
                        )
                    )
                }

                LabelValueText(
                    stringResource(Res.string.select_customer_name),
                    customer.name
                )
                Spacer(modifier = Modifier.width(10.dp))
                LabelValueText(
                    stringResource(Res.string.select_customer_mobile),
                    customer.mobile
                )
                Spacer(modifier = Modifier.width(10.dp))
                LabelValueText(
                    stringResource(Res.string.select_customer_loan),
                    "Rs ${customer.amount}"
                )
            }
        }
    }


}


@Composable
fun FormFieldCompacts(
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = Int.MAX_VALUE,
    trailingIcon: @Composable (() -> Unit)? = null,
    inputType: KeyboardType = KeyboardType.Text,
    placeholder: String = stringResource(Res.string.type_here),
    isEnable: Boolean = true,
    isReadable: Boolean = false,
    labelColor: Color = toolbar_color,
    placeholderColor: Color = Color(0xFF212121),
    backgroundColor: Color = text_fiiled_color,
    borderColor: Color = boderColor,
    disabledBackgroundColor: Color = formborder,
    maxLines: Int = 1,
    modifier: Modifier = Modifier,
    placeholderTextSize: Int = 13
) {
    var text by remember { mutableStateOf(value) }

    Column(modifier) {


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    color = if (isEnable) backgroundColor else disabledBackgroundColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                .clickable(enabled = isEnable) { /* triggers keyboard focus */ },
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = text,
                enabled = isEnable,
                readOnly = isReadable,
                onValueChange = { newValue ->
                    if (newValue.length <= maxLength) {
                        text = newValue
                        onValueChange(newValue)
                    }
                },
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                    textAlign = TextAlign.Start
                ),
                maxLines = maxLines,
                keyboardOptions = KeyboardOptions(keyboardType = inputType),
                modifier = Modifier
                    .matchParentSize()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (text.isEmpty()) {
                                ReusableTextView(
                                    text = placeholder,
                                    fontSize = placeholderTextSize,
                                    textColor = placeholderColor
                                )
                            }
                            innerTextField()
                        }

                        trailingIcon?.invoke()
                    }
                }
            )
        }
    }
}


@Composable
fun ReusableTextViewGrayCard(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = toolbar_color,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.W500,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
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
    modifier: Modifier = Modifier.fillMaxWidth(),
    textColor: Color = Color.Black,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_medium)),
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
fun ReusableDynamicSpinner(
    selectedValue: String?,
    options: List<String>,
    placeholder: String = stringResource(Res.string.spinner_select),
    onValueSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = text_fiiled_color,
    borderColor: Color = boderColor,
) {

    var expanded by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0) }

    val density = LocalDensity.current

    val robotoMedium = FontFamily(Font(Res.font.inter_medium))
    val textColor = Color.Black

    val displayText = selectedValue?.takeIf { it.isNotEmpty() } ?: placeholder

    Box(
        modifier = modifier
            .height(40.dp)
            .onGloballyPositioned { coordinates ->
                spinnerWidth = coordinates.size.width
            }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(15.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable { expanded = true }
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = displayText,
                color = textColor,
                fontSize = 12.sp,
                fontFamily = robotoMedium
            )

            Text(
                text = "▼",
                fontSize = 12.sp,
                fontFamily = robotoMedium,
                color = textColor
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(density) { spinnerWidth.toDp() })
        ) {

            options.forEach { item ->

                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            fontSize = 12.sp,
                            fontFamily = robotoMedium,
                            color = textColor
                        )
                    },
                    onClick = {
                        onValueSelected(item)
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
    endPadding: Dp = 5.dp,
    topPadding: Dp = 0.dp,
    bottomPadding: Dp = 0.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(startPadding, topPadding, endPadding, bottomPadding)
            .height(thickness)
            .background(color)
    )
}

@Composable
fun CustomAlertDialogRegistrationExisting(
    title: String = stringResource(Res.string.app_name),
    confirmText: String = stringResource(Res.string.cancel),
    onRegistration: () -> Unit = {},
    onExitsing: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    Dialog(
        onDismissRequest = { },
    )
    {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .widthIn(min = 400.dp, max = 500.dp)
                .heightIn(max = 500.dp)
                .background(white, RoundedCornerShape(16.dp))

        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .widthIn(400.dp)
                    .background(white, shape = RoundedCornerShape(16.dp)),
                //.border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().background(
                        appleblue,
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
                        modifier = Modifier.padding(start = 10.dp),

                        )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.weight(0.2f))

                    // Middle 1/3: a box that centers the button inside it
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        CommonSaveButton(
                            onSaveClick = {
                                onRegistration()
                            },
                            saveText = stringResource(Res.string.new_registration)
                        )
                    }

                    Spacer(Modifier.weight(0.2f))
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Spacer(Modifier.weight(0.2f))

                    // Middle 1/3: a box that centers the button inside it
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        CommonSaveButton(
                            onSaveClick = {
                                onExitsing()
                            },
                            saveText = stringResource(Res.string.existing_customer)
                        )
                    }

                    Spacer(Modifier.weight(0.2f))
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Spacer(Modifier.weight(0.5f))

                    // Middle 1/3: a box that centers the button inside it
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        CommonSaveButton(
                            onSaveClick = {
                                onBack()
                            },
                            saveText = confirmText
                        )
                    }

                    Spacer(Modifier.weight(0.5f))
                }

                Spacer(Modifier.height(10.dp))
            }
        }
    }
}

fun convertDateFormatYYYYMMDD(inputDate: String): String {
    var newDate = ""
    try {
        if (!inputDate.isNullOrEmpty()) {
            val parts = inputDate.split("-")
            val day = parts[0].toInt()
            val month = parts[1].toInt()
            val year = parts[2].toInt()
            newDate = "$year-$month-$day"
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return newDate
}

fun convertDateFormatDDMMYYYY(inputDate: String): String {
    var newDate = ""
    try {
        if (!inputDate.isNullOrEmpty()) {
            val parts = inputDate.split("-")
            val day = parts[2].toInt()
            val month = parts[1].toInt()
            val year = parts[0].toInt()
            newDate = "$day-$month-$year"
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return newDate

}

@Composable
fun AddCircleButton(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = btn_color,
                shape = CircleShape
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(Res.string.add_more_family),
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

}


object MasterXmlParser {

    private val xml = XML {
        autoPolymorphic = true

    }

    fun parse(xmlResponse: String): MasterResponse {
        return xml.decodeFromString(xmlResponse)
    }
}

@Composable
fun <T : Any> FillDynamicSpinnerespt(
    label: String,
    options: List<T>?,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    getOptionId: (T) -> Int,
    getOptionLabel: (T) -> String,
    modifier: Modifier = Modifier,
    labelColor: Color = black,
    backgroundColor: Color = text_fiiled_color,
    textColor: Color = Color.Black,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
    borderColor: Color = boderColor,
    focusRequester: FocusRequester? = null,
    bringIntoViewRequester: BringIntoViewRequester? = null,
    placeholder: String = stringResource(Res.string.spinner_select),
    isMandatory: Int = 1
) {
    var expanded by remember { mutableStateOf(false) }
    var hasFocus by remember { mutableStateOf(false) }
    var spinnerWidth by remember { mutableStateOf(0.dp) }

    val density = LocalDensity.current

    //  Light Black color for placeholder
    val lightBlack = Color(0xFF666666)

    val isPlaceholder = selectedOption == null || selectedOption == 0

    val displayText = if (isPlaceholder) {
        placeholder
    } else {
        options?.find { getOptionId(it) == selectedOption }?.let {
            getOptionLabel(it)
        } ?: placeholder
    }

    LaunchedEffect(hasFocus) {
        if (hasFocus) {
            delay(120)
            bringIntoViewRequester?.bringIntoView()
            expanded = true
        }
    }

    Column(modifier = modifier) {

        ReusableTextView(
            text = label,
            fontSize = 14,
            textColor = labelColor,
            fontFamily = fontFamily
        )

        Spacer(modifier = Modifier.height(5.dp))

        Box(modifier = Modifier.fillMaxWidth()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .border(1.dp, borderColor, RoundedCornerShape(15.dp))
                    .background(backgroundColor, RoundedCornerShape(15.dp))
                    .focusTarget()
                    .focusable()
                    .focusProperties { canFocus = true }
                    .then(
                        if (focusRequester != null)
                            Modifier.focusRequester(focusRequester)
                        else Modifier
                    )
                    .onFocusChanged { state -> hasFocus = state.isFocused }
                    .clickable { expanded = true }
                    .onGloballyPositioned {
                        spinnerWidth = with(density) { it.size.width.toDp() }
                    },
                contentAlignment = Alignment.CenterStart
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(text_fiiled_color, RoundedCornerShape(15.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ReusableTextView(
                        text = displayText,
                        textColor = if (isPlaceholder) lightBlack else textColor,
                        fontFamily = fontFamily
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = vectorResource(Res.drawable.ic_arrow_drop_down),
                        contentDescription = "Dropdown",
                        tint = if (isPlaceholder) lightBlack else textColor
                    )
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(spinnerWidth)
                    .background(White)
            ) {

                DropdownMenuItem(
                    text = {
                        ReusableTextView(
                            text = placeholder,
                            fontSize = 14,
                            textColor = lightBlack
                        )
                    },
                    onClick = {
                        onOptionSelected(0)
                        expanded = false
                    }
                )

                options?.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            ReusableTextView(
                                text = getOptionLabel(item),
                                fontSize = 14,
                                textColor = textColor
                            )
                        },
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

fun parseNameDynamic(fullName: String): NameParts {
    val parts = fullName.trim()
        .split("\\s+".toRegex())

    val firstName = parts.firstOrNull().orEmpty()
    val lastName = if (parts.size > 1) parts.last() else ""

    val middleName = if (parts.size > 2) {
        parts.subList(1, parts.size - 1).joinToString(" ")
    } else ""

    return NameParts(firstName, middleName, lastName)
}

fun calculateAgeFromDobKMP(dob: String): Int {
    if (dob.isBlank()) return 0

    return try {
        // DOB format: dd-MM-yyyy
        val parts = dob.split("-")
        if (parts.size != 3) return 0

        val day = parts[0].toInt()
        val month = parts[1].toInt()
        val year = parts[2].toInt()

        val birthDate = LocalDate(year, month, day)
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

        var age = today.year - birthDate.year

        // Birthday abhi aaya ya nahi
        if (
            today.monthNumber < birthDate.monthNumber ||
            (today.monthNumber == birthDate.monthNumber && today.dayOfMonth < birthDate.dayOfMonth)
        ) {
            age--
        }

        age
    } catch (e: Exception) {
        0
    }
}