package ua.vn.iambulance.natifeapp.domain.view_models

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.entity.GiphyResponse
import ua.vn.iambulance.natifeapp.data.pagination.PaginationClient
import ua.vn.iambulance.natifeapp.data.retrofit.RetrofitClient
import ua.vn.iambulance.natifeapp.domain.GetGiphyUseCase

class MainViewModel: ViewModel() {

    private val paginationClient = PaginationClient()
    private val getGiphyUseCase: GetGiphyUseCase = GetGiphyUseCase(GiphyRepository(RetrofitClient().apiService))

    val gifsLiveData: MutableLiveData<List<GiphyData>> = MutableLiveData()

    private val _giphyStateFlow = MutableStateFlow(emptyList<GiphyData>())
    val giphyStateFlow get() = _giphyStateFlow as StateFlow<List<GiphyData>>

    suspend fun getGiphy(){
        _giphyStateFlow.value = getGiphyUseCase()
    }


    fun openValue(){
        viewModelScope.launch(Dispatchers.IO) {
            gifsLiveData.postValue(paginationClient.getNextPage(0))
        }
    }
}