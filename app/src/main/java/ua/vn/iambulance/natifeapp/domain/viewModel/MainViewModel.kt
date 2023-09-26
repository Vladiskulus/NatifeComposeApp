package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.repository.GiphyPagerRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GiphyPagerRepository): ViewModel() {

    fun getTrendingGiphy():Flow<PagingData<GiphyData>> = repository.getGiphyFlow().cachedIn(viewModelScope)

}