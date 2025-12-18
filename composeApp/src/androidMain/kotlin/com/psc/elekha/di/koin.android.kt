package com.psc.elekha.di

import androidx.activity.ComponentActivity
import com.psc.elekha.expectfile.Localization
import com.psc.elekha.expectfile.PermissionManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val targetModule = module {
    single<Localization> { Localization(context = androidContext()) }
    single<PermissionManager> { PermissionManager(get()) }
}