package com.psc.elekha.model

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.ui.focus.FocusRequester


data class ValidationModelContorl (
    val isValid: Boolean,
    val errorMessage: String = "",
    val focusRequester: FocusRequester? = null,
    val bringIntoViewRequester: BringIntoViewRequester? = null
)
