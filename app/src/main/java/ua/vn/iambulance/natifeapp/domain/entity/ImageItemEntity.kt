package ua.vn.iambulance.natifeapp.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageItemEntity (
    val height: String?,
    val size: String?,
    val url: String?,
    val width: String?
):Parcelable