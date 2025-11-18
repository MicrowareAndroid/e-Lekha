package com.psc.elekha.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager


actual fun provideAppPreferences(): AppPreferences {
     val context: Context = com.psc.elekha.MyApp.instance

    return AppPreferences(context)
}

actual class AppPreferences(private val context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    actual fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    actual fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    actual fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    actual fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    actual fun clearsharedprefrence() {
        sharedPreferences.edit().clear()
        sharedPreferences.edit().commit()
    }
}

actual object VersionInfo {
    private lateinit var appContext: Context

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    actual fun getVersionInfo(): String {
        return try {
            val packageInfo = appContext.packageManager.getPackageInfo(
                appContext.packageName,
                0
            )
            packageInfo.versionName ?: "Unknown"
        } catch (e: PackageManager.NameNotFoundException) {
            "Unknown"
        }
    }
}

private var activityProvider: () -> Activity = {
    throw IllegalArgumentException("Error")
}

fun setActivityProvider(provider: () -> Activity) {
    activityProvider = provider
}