package com.psc.elekha.di


import com.psc.elekha.utils.provideAppPreferences
import org.koin.dsl.module


val commonModule = module {
    single { provideAppPreferences() }
}