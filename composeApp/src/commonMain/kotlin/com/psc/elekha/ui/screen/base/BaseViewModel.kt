package com.psc.elekha.ui.screen.base



import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psc.elekha.model.ValidationModelContorl

import kotlinx.coroutines.launch

/**
 * Created By Deepak 13 November 2025
 * For any viewmodel
 */
abstract class BaseValidationViewModel : ViewModel() {

    var showSaveAlert by mutableStateOf(false)

    var saveFlag by mutableStateOf(0)

    var saveMessage by mutableStateOf("")

    var validationFieldFocus: FocusRequester? by mutableStateOf(null)
        private set

    var validationFieldBringIntoView: BringIntoViewRequester? by mutableStateOf(null)
        private set

    //Shows validation error and prepares field for focus

    protected fun showValidationError(result: ValidationModelContorl) {
        saveMessage = result.errorMessage
        validationFieldFocus = result.focusRequester
        validationFieldBringIntoView = result.bringIntoViewRequester
        showSaveAlert = true
    }


    //Requests focus on the validation field and scrolls it into view
    fun requestFocus() {
        viewModelScope.launch {
            showSaveAlert = false
            validationFieldBringIntoView?.bringIntoView()
            validationFieldFocus?.requestFocus()
            validationFieldFocus = null
            validationFieldBringIntoView = null
        }
    }

}