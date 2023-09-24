package ua.vn.iambulance.natifeapp.data

import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService

class GiphyRepository(private val apiService: ApiService) {
    suspend fun getGiphy(offset:Int = 0):List<GiphyData>{
        return apiService.getTrendingGifs(API_KEY, LIMIT, offset * LIMIT, REQUEST, "messaging_non_clips").data
    }
}