package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.*
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.repository.GiphyPagerRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GiphyPagerRepository): ViewModel() {

    private var _images = MutableStateFlow<PagingData<GiphyData>>(PagingData.empty())
    val images: Flow<PagingData<GiphyData>>
        get() = _images

    init {
        getTrendingGiphy()
    }

    private fun getTrendingGiphy() = viewModelScope.launch {
        runCatching {
            repository.getGiphyFlow()
                .cachedIn(viewModelScope).collect {
                    _images.value = it
                }
        }.onFailure {

        }
    }
}