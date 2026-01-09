// androidMain/src/com/psc/elekha/utils/AppContextProvider.kt
package com.psc.elekha.utils

import android.content.Context

// AppContextProvider
object AppContextProvider {
    private lateinit var appContext: Context

    fun init(context: Context) {
        appContext = context
    }

    fun get(): Context {
        if (!::appContext.isInitialized) {
            throw IllegalStateException("AppContextProvider not initialized")
        }
        return appContext
    }
}

