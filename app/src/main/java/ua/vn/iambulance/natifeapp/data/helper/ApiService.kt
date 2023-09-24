package ua.vn.iambulance.natifeapp.data.helper

import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getItems(): String
}