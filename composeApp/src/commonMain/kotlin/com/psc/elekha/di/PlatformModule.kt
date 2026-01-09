package com.psc.elekha.di

import com.psc.elekha.apicall.ApiService
import com.psc.elekha.utils.NetworkMonitor

import org.koin.dsl.module

val platformModule = module {

    single { NetworkMonitor() }
}
