package com.psc.elekha.expectfile


import androidx.compose.runtime.Composable
import androidx.room.Room
import androidx.room.RoomDatabase
import com.psc.elekha.database.appdatabase.AppDatabase
import com.psc.elekha.database.appdatabase.dbFileName
import com.psc.elekha.utils.AppPermission
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.AVFoundation.AVAuthorizationStatusAuthorized
import platform.AVFoundation.AVAuthorizationStatusDenied
import platform.AVFoundation.AVAuthorizationStatusRestricted
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeAudio
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedAlways
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedWhenInUse
import platform.CoreLocation.kCLAuthorizationStatusDenied
import platform.CoreLocation.kCLAuthorizationStatusRestricted
import platform.Foundation.NSApplicationSupportDirectory
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import platform.Foundation.NSXMLParser
import platform.Photos.PHAuthorizationStatusAuthorized
import platform.Photos.PHAuthorizationStatusDenied
import platform.Photos.PHAuthorizationStatusLimited
import platform.Photos.PHAuthorizationStatusRestricted
import platform.Photos.PHPhotoLibrary
import platform.UIKit.UIActivityViewController
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationOpenSettingsURLString
import platform.UIKit.popoverPresentationController
import kotlin.coroutines.resume
import platform.Foundation.*

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/${dbFileName}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    )
}

actual class PermissionManager {

    actual suspend fun checkPermission(permission: AppPermission): PermissionStatus {
        return when (permission) {
            AppPermission.CAMERA -> checkCameraPermission()
            AppPermission.STORAGE -> checkGalleryPermission()
            AppPermission.LOCATION -> checkLocationPermission()
            AppPermission.MICROPHONE -> checkMicrophonePermission()
        }
    }

    actual suspend fun requestPermission(permission: AppPermission): PermissionStatus {
        return when (permission) {
            AppPermission.CAMERA -> requestCameraPermission()
            AppPermission.STORAGE -> requestGalleryPermission()
            AppPermission.LOCATION -> requestLocationPermission()
            AppPermission.MICROPHONE -> requestMicrophonePermission()
        }
    }

    actual suspend fun requestMultiplePermissions(permissions: List<AppPermission>): Map<AppPermission, PermissionStatus> {
        val results = mutableMapOf<AppPermission, PermissionStatus>()

        for (permission in permissions) {
            results[permission] = requestPermission(permission)
        }

        return results
    }

    actual fun openAppSettings() {
        val settingsUrl = NSURL.URLWithString(UIApplicationOpenSettingsURLString)
        if (settingsUrl != null && UIApplication.sharedApplication.canOpenURL(settingsUrl)) {
            UIApplication.sharedApplication.openURL(settingsUrl)
        }
    }

    private fun checkCameraPermission(): PermissionStatus {
        return when (AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeVideo)) {
            AVAuthorizationStatusAuthorized -> PermissionStatus.GRANTED
            AVAuthorizationStatusDenied -> PermissionStatus.DENIED_PERMANENTLY
            AVAuthorizationStatusRestricted -> PermissionStatus.DENIED_PERMANENTLY
            else -> PermissionStatus.NOT_DETERMINED
        }
    }

    private suspend fun requestCameraPermission(): PermissionStatus = suspendCancellableCoroutine { continuation ->
        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) { granted ->
            continuation.resume(
                if (granted) PermissionStatus.GRANTED else PermissionStatus.DENIED
            )
        }
    }

    private fun checkMicrophonePermission(): PermissionStatus {
        return when (AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeAudio)) {
            AVAuthorizationStatusAuthorized -> PermissionStatus.GRANTED
            AVAuthorizationStatusDenied -> PermissionStatus.DENIED_PERMANENTLY
            AVAuthorizationStatusRestricted -> PermissionStatus.DENIED_PERMANENTLY
            else -> PermissionStatus.NOT_DETERMINED
        }
    }

    private suspend fun requestMicrophonePermission(): PermissionStatus = suspendCancellableCoroutine { continuation ->
        AVCaptureDevice.requestAccessForMediaType(AVMediaTypeAudio) { granted ->
            continuation.resume(
                if (granted) PermissionStatus.GRANTED else PermissionStatus.DENIED
            )
        }
    }

    private fun checkGalleryPermission(): PermissionStatus {
        return when (PHPhotoLibrary.authorizationStatus()) {
            PHAuthorizationStatusAuthorized, PHAuthorizationStatusLimited -> PermissionStatus.GRANTED
            PHAuthorizationStatusDenied -> PermissionStatus.DENIED_PERMANENTLY
            PHAuthorizationStatusRestricted -> PermissionStatus.DENIED_PERMANENTLY
            else -> PermissionStatus.NOT_DETERMINED
        }
    }

    private suspend fun requestGalleryPermission(): PermissionStatus = suspendCancellableCoroutine { continuation ->
        PHPhotoLibrary.requestAuthorization { status ->
            continuation.resume(
                when (status) {
                    PHAuthorizationStatusAuthorized, PHAuthorizationStatusLimited -> PermissionStatus.GRANTED
                    PHAuthorizationStatusDenied -> PermissionStatus.DENIED_PERMANENTLY
                    else -> PermissionStatus.DENIED
                }
            )
        }
    }

    private fun checkLocationPermission(): PermissionStatus {
        val locationManager = CLLocationManager()
        return when (locationManager.authorizationStatus) {
            kCLAuthorizationStatusAuthorizedWhenInUse,
            kCLAuthorizationStatusAuthorizedAlways -> PermissionStatus.GRANTED
            kCLAuthorizationStatusDenied -> PermissionStatus.DENIED_PERMANENTLY
            kCLAuthorizationStatusRestricted -> PermissionStatus.DENIED_PERMANENTLY
            else -> PermissionStatus.NOT_DETERMINED
        }
    }

    private suspend fun requestLocationPermission(): PermissionStatus = suspendCancellableCoroutine { continuation ->
        val locationManager = CLLocationManager()
        locationManager.requestWhenInUseAuthorization()
        // Note: In production, you'd need a proper delegate implementation
        continuation.resume(PermissionStatus.NOT_DETERMINED)
    }
}



actual class DatabaseExporter {

    actual fun exportAndShare(dbBaseName: String) {
        val files = prepareDatabaseFiles(dbBaseName)
        if (files.isNotEmpty()) {
            shareFiles(files)
        }
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun prepareDatabaseFiles(dbBaseName: String): List<NSURL> {
    val fm = NSFileManager.defaultManager
    val result = mutableListOf<NSURL>()

    val timestamp = NSDateFormatter().apply {
        dateFormat = "yyyyMMdd_HHmmss"
    }.stringFromDate(NSDate())

    val exportBase = "Elekha_$timestamp"

    val cacheDir = fm.URLForDirectory(
        directory = NSCachesDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = true,
        error = null
    ) ?: return emptyList()

    val dbUrl = getDatabaseUrl(dbBaseName) ?: return emptyList()

    fun copyIfExists(src: NSURL, name: String) {
        if (!fm.fileExistsAtPath(src.path!!)) return

        val dst = cacheDir.URLByAppendingPathComponent(name) ?: return
        fm.removeItemAtURL(dst, null)
        fm.copyItemAtURL(src, dst, null)
        result.add(dst)
    }

    copyIfExists(dbUrl, "$exportBase.db")
    copyIfExists(dbUrl.URLByAppendingPathExtension("-wal") ?: return emptyList(), "$exportBase.db-wal")
    copyIfExists(dbUrl.URLByAppendingPathExtension("-shm") ?: return emptyList(), "$exportBase.db-shm")

    return result
}



@OptIn(ExperimentalForeignApi::class)
private fun getDatabaseUrl(dbBaseName: String): NSURL? {
    val fileManager = NSFileManager.defaultManager

    val appSupportDir = fileManager.URLForDirectory(
        directory = NSApplicationSupportDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = true,
        error = null
    ) ?: return null

    return appSupportDir.URLByAppendingPathComponent("$dbBaseName.db")
}

private fun shareFiles(files: List<NSURL>) {
    val controller = UIActivityViewController(
        activityItems = files,
        applicationActivities = null
    )

    val rootVC = UIApplication.sharedApplication
        .keyWindow
        ?.rootViewController ?: return

    controller.popoverPresentationController?.sourceView =
        rootVC.view

    rootVC.presentViewController(controller, true, null)
}


