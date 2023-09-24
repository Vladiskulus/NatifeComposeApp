package ua.vn.iambulance.natifeapp.data.pagination

import ua.vn.iambulance.natifeapp.data.API_KEY
import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.entity.GiphyResponse
import ua.vn.iambulance.natifeapp.data.retrofit.*

class PaginationClient {

    private val retrofitClient
        get() = RetrofitClient()

    suspend fun getNextPage(offset: Int): List<GiphyData> = GiphyRepository(retrofitClient.apiService).getGiphy(offset)
}