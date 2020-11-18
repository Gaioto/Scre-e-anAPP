package general.dev.screean.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


fun bitmapToBase64(bitmap: Bitmap): String {

    val byteArrayOutputStream = ByteArrayOutputStream()

    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)

    val imagemArray = byteArrayOutputStream.toByteArray()

    val imagemBase64 = Base64.encodeToString(imagemArray, Base64.NO_WRAP)

    return imagemBase64
}

fun base64ToBitmap(base64: String?): Bitmap {

    val decodeString = Base64.decode(base64, Base64.NO_WRAP);

    val decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.size)

    return decoded
}