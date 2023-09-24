package ua.vn.iambulance.natifeapp.data.retrofit

import retrofit2.http.*
import ua.vn.iambulance.natifeapp.data.*
import ua.vn.iambulance.natifeapp.data.entity.GiphyResponse


interface ApiService {

    @GET("gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("bundle") bundle: String
    ): GiphyResponse
}