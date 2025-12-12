package com.psc.elekha.di

import com.psc.elekha.expectfile.Localization
import org.koin.dsl.module

actual val targetModule = module {
    single<Localization> { Localization() }
}