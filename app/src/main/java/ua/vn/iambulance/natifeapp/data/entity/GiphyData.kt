package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GiphyData(
    val id: String,
    val url: String,
    val images: GiphyImages
):Parcelable