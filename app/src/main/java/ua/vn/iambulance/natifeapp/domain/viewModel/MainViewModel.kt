package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.domain.GetGiphyUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getGiphyUseCase: GetGiphyUseCase): ViewModel() {


    private val _gifsLiveData: MutableLiveData<List<GiphyData>> = MutableLiveData()
    val gifsLiveData get() = _gifsLiveData as LiveData<List<GiphyData>>

    private val _giphyStateFlow = MutableStateFlow(emptyList<GiphyData>())
    val giphyStateFlow get() = _giphyStateFlow as StateFlow<List<GiphyData>>

    private var currentPage = 0
    private var isFetching = false

    suspend fun getGiphy(){
        _giphyStateFlow.value = getGiphyUseCase()
    }


}