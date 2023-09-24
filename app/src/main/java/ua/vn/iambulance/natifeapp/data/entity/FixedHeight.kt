package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixedHeight(
    @SerializedName("height")
    val height: String?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: String?
):Parcelable
