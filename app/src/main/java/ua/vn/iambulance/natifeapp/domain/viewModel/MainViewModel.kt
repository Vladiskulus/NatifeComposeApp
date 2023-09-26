package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.retrofit.RetrofitClient
import ua.vn.iambulance.natifeapp.domain.GetGiphyUseCase

class MainViewModel: ViewModel() {

    private val getGiphyUseCase: GetGiphyUseCase = GetGiphyUseCase(GiphyRepository(RetrofitClient().apiService))
    val gifsLiveData: MutableLiveData<List<GiphyData>> = MutableLiveData()

    private val _giphyStateFlow = MutableStateFlow(emptyList<GiphyData>())
    val giphyStateFlow get() = _giphyStateFlow as StateFlow<List<GiphyData>>

    private var currentPage = 0
    private var isFetching = false

    suspend fun getGiphy(){
        _giphyStateFlow.value = getGiphyUseCase()
    }

}