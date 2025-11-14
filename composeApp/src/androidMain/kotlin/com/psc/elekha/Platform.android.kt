package com.psc.elekha

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

@Composable
actual fun getAppVersion(): String {
    val context = LocalContext.current
    return try {
        context.packageManager
            .getPackageInfo(context.packageName, 0)
            .versionName ?: "Unknown"
    } catch (e: Exception) {
        "Unknown"
    }
}