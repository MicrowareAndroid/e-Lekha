package com.psc.elekha.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.psc.elekha.ui.theme.LoginTextBox
import e_lekha.composeapp.generated.resources.Res
import e_lekha.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

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
            color = Color.White
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
