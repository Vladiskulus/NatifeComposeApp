package ua.vn.iambulance.natifeapp.di

import dagger.*
import dagger.hilt.InstallIn
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService
import dagger.hilt.android.components.ViewModelComponent
import ua.vn.iambulance.natifeapp.data.repository.GiphyPagerRepository

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {
    @Provides
    fun provideGiphyRepository(apiService: ApiService): GiphyPagerRepository = GiphyPagerRepository(apiService = apiService)

}