package com.psc.elekha.utils

import androidx.compose.runtime.*
import androidx.compose.ui.interop.LocalUIViewController
import kotlinx.cinterop.*
import platform.Foundation.NSData
import platform.UIKit.*
import platform.darwin.NSObject
import platform.posix.memcpy

@Composable
actual fun CameraPicker(
    onImagePicked: (ByteArray?) -> Unit,
    openCamera: Boolean
) {
    if (!openCamera) return

    val viewController = LocalUIViewController.current
    var launched by remember { mutableStateOf(false) }

    if (!launched) {
        launched = true
        val picker = UIImagePickerController().apply {
            sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
            allowsEditing = false
            delegate = object : NSObject(), UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
                override fun imagePickerController(
                    picker: UIImagePickerController,
                    didFinishPickingMediaWithInfo: Map<Any?, *>
                ) {
                    val image = didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage
                    val imageData = image?.JPEGRepresentation(0.9)
                    val bytes = imageData?.toByteArray()
                    onImagePicked(bytes)
                    picker.dismissViewControllerAnimated(true, completion = null)
                }

                override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
                    picker.dismissViewControllerAnimated(true, completion = null)
                    onImagePicked(null)
                }
            }
        }
        viewController.presentViewController(picker, animated = true, completion = null)
    }
}

// Helper: convert NSData to ByteArray
@OptIn(ExperimentalForeignApi::class)
fun NSData.toByteArray(): ByteArray = ByteArray(length.toInt()).apply {
    usePinned { memcpy(it.addressOf(0), bytes, length) }
}

// Helper: convert UIImage to JPEG NSData
fun UIImage.JPEGRepresentation(compression: Double): NSData? {
    return UIImageJPEGRepresentation(this, compression)
}
