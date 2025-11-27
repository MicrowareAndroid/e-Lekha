package com.psc.elekha

import androidx.compose.runtime.Composable
import platform.Foundation.NSBundle
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

@Composable
actual fun getAppVersion(): String {
    return NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString")?.toString() ?: "Unknown"
}