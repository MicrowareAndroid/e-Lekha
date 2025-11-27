package com.psc.elekha

import android.app.Application
import com.psc.elekha.utils.AppPreferences
import com.psc.elekha.utils.VersionInfo
import com.psc.elekha.di.initKoin


import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class MyApp : Application(), KoinComponent {
    companion object {
        lateinit var instance: MyApp
            private set
        lateinit var appPreferences: AppPreferences
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        VersionInfo.init(applicationContext)
        appPreferences = AppPreferences(this)

        initKoin {
            androidLogger()
            androidContext(this@MyApp)
        }


    }


}