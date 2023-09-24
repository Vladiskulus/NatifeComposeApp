package ua.vn.iambulance.natifeapp.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class GiphyResponse(
    val data: List<GiphyData>,
    val pagination: GiphyPagination
): Parcelable