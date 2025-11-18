package com.psc.elekha.di

import com.psc.elekha.expectfile.Localization
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val targetModule = module {
    single<Localization> { Localization(context = androidContext()) }
}