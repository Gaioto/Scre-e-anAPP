package general.dev.screean.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


fun bitmapToBase64(bitmap: Bitmap): String {

    val byteArrayOutputStream = ByteArrayOutputStream()

    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream)

    val imagemArray = byteArrayOutputStream.toByteArray()

    return Base64.encodeToString(imagemArray, Base64.NO_WRAP)
}

fun base64ToBitmap(base64: String?): Bitmap {

    val decodeString = Base64.decode(base64, Base64.NO_WRAP)

    return BitmapFactory.decodeByteArray(decodeString, 0, decodeString.size)
}

