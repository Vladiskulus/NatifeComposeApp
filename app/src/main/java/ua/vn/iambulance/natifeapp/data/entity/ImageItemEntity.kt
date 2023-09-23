package ua.vn.iambulance.natifeapp.data.entity

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageItemEntity (
    val image: Bitmap,
    val textHeader: String,
    val textDescription: String,
):Parcelable