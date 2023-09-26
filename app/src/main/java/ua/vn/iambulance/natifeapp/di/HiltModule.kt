package ua.vn.iambulance.natifeapp.di

import dagger.*
import dagger.hilt.InstallIn
import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService
import dagger.hilt.android.components.ViewModelComponent
import ua.vn.iambulance.natifeapp.domain.GetGiphyUseCase

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {
    @Provides
    fun provideGiphyRepository(apiService: ApiService):GiphyRepository = GiphyRepository(apiService = apiService)

    @Provides
    fun provideGiphyUseCase(apiService: ApiService):GetGiphyUseCase = GetGiphyUseCase(GiphyRepository(apiService))
}