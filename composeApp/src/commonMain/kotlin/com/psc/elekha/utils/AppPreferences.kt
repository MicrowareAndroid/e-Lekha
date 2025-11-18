package com.psc.elekha.utils


expect fun provideAppPreferences(): AppPreferences
expect class AppPreferences {
    fun putString(key: String, value: String)
    fun getString(key: String): String?
    fun putInt(key: String, value: Int)
    fun getInt(key: String): Int
    fun clearsharedprefrence()
}

expect object VersionInfo {
    fun getVersionInfo(): String
}

