package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GiphyPagination(
    val total_count: Int,
    val count: Int,
    val offset: Int
): Parcelable