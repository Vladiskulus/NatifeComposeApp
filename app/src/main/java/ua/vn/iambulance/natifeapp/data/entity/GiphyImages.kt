package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GiphyImages(
    val original: GiphyImage,
    val downsized: GiphyImage
): Parcelable