package ua.vn.iambulance.natifeapp.data.pagination

import ua.vn.iambulance.natifeapp.data.API_KEY
import ua.vn.iambulance.natifeapp.data.entity.GiphyResponse
import ua.vn.iambulance.natifeapp.data.retrofit.*

class PaginationClient {

    private val retrofitClient
        get() = RetrofitClient()

    suspend fun getNextPage(offset: Int): GiphyResponse =
        retrofitClient.apiService.getTrendingGifs(
        API_KEY,
        25,
        offset,
        "g",
        "messaging_non_clips"
    )
}