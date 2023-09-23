package ua.vn.iambulance.natifeapp.data

import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getItems(): String
}