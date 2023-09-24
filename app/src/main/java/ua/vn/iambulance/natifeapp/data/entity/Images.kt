package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Images(
    @SerializedName("fixed_height")
    val fixedHeight: FixedHeight?
):Parcelable
