package com.psc.elekha

import androidx.compose.ui.window.ComposeUIViewController
import com.psc.elekha.application.ELekhaApplication
import com.psc.elekha.di.initKoin
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.provideAppPreferences


fun MainViewController() = ComposeUIViewController(


    configure = {

        initKoin()
    }
) {
    val appPreferences: AppPreferences = provideAppPreferences()
    ELekhaApplication(appPreferences)
}
