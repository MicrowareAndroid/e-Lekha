package com.psc.elekha.utils

import androidx.compose.runtime.*
import androidx.compose.ui.interop.LocalUIViewController
import platform.UIKit.*
import platform.Foundation.*
import platform.darwin.NSObject



@Composable
actual fun CameraPicker(
    openCamera: Boolean,
    onImagePicked: (String?) -> Unit
) {
    if (!openCamera) return

    val controller = LocalUIViewController.current
    var launched by remember { mutableStateOf(false) }

    if (launched) return
    launched = true

    val picker = UIImagePickerController().apply {
        sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
        allowsEditing = false
        delegate = object : NSObject(),
            UIImagePickerControllerDelegateProtocol,
            UINavigationControllerDelegateProtocol {

            override fun imagePickerController(
                picker: UIImagePickerController,
                didFinishPickingMediaWithInfo: Map<Any?, *>
            ) {
                val image =
                    didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage] as? UIImage

                if (image != null) {
                    val data: NSData? = UIImageJPEGRepresentation(image, 0.9)
                    val path = saveImageToDocuments(data)
                    onImagePicked(path)
                } else {
                    onImagePicked(null)
                }

                picker.dismissViewControllerAnimated(true, null)
            }

            override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
                picker.dismissViewControllerAnimated(true, null)
                onImagePicked(null)
            }
        }
    }

    controller.presentViewController(picker, true, null)
}
fun saveImageToDocuments(data: NSData?): String? {
    if (data == null) return null

    val paths = NSSearchPathForDirectoriesInDomains(
        NSDocumentDirectory,
        NSUserDomainMask,
        true
    )

    val documentsDir = paths.firstOrNull() as? String ?: return null
    val filePath = "$documentsDir/IMG_${NSDate().timeIntervalSince1970}.jpg"

    return if (data.writeToFile(filePath, true)) filePath else null
}
