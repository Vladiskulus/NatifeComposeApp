package ua.vn.iambulance.natifeapp.data.retrofit

import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
            .client(OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }.build())
            .build()
            .create(ApiService::class.java)
}