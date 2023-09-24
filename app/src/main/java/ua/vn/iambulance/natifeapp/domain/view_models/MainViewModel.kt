package ua.vn.iambulance.natifeapp.domain.view_models

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.entity.GiphyResponse
import ua.vn.iambulance.natifeapp.data.pagination.PaginationClient
import ua.vn.iambulance.natifeapp.data.retrofit.RetrofitClient

class MainViewModel: ViewModel() {

    val paginationClient = PaginationClient()

    val gifsLiveData: MutableLiveData<GiphyResponse> = MutableLiveData()

//    fun getNextPage(offset: Int) {
//
//        viewModelScope.launch {
//            response = paginationClient.getNextPage(offset)
//            gifsLiveData.postValue(response)
//        }
//
//    }

//    val gifsFlow = flow {
//        emit(paginationClient.getNextPage(0).body()!!.data)
//        var offset = 25
//        while (true) {
//            val response = paginationClient.getNextPage(offset)
//            emit(response.body()!!.data)
//            offset += 25
//        }
//    }
}