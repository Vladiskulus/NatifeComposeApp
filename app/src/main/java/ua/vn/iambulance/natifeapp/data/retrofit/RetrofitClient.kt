package ua.vn.iambulance.natifeapp.data.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.vn.iambulance.natifeapp.data.REQUEST_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClient {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): ApiService=
        Retrofit.Builder()
            .baseUrl(REQUEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}