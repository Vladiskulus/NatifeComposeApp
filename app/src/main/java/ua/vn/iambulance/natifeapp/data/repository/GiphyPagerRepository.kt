package ua.vn.iambulance.natifeapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ua.vn.iambulance.natifeapp.data.LIMIT
import ua.vn.iambulance.natifeapp.data.paging.GiphyPagingSource
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService
import javax.inject.Inject


class GiphyPagerRepository @Inject constructor(private val apiService: ApiService) {

    fun getGiphyFlow() = Pager(
        config = PagingConfig(pageSize = LIMIT), pagingSourceFactory ={
            GiphyPagingSource(apiService)
        }
    ).flow
}