package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GiphyImage(
    val url: String,
    val width: Int,
    val height: Int
): Parcelable