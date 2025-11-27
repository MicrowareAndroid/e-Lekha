package com.psc.elekha.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {
    private val _finished = MutableStateFlow(false)
    val finished = _finished

    init {
        viewModelScope.launch {
            delay(3000)  // Splash delay
            _finished.value = true
        }
    }
}