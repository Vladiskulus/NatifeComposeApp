package ua.vn.iambulance.natifeapp.domain.paging

import androidx.paging.*
import ua.vn.iambulance.natifeapp.data.*
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService

class GiphyPagingSource(private val apiService: ApiService):PagingSource<Int, GiphyData>() {

    private var offset = 0

    override fun getRefreshKey(state: PagingState<Int, GiphyData>): Int? {
        offset = 0
        return offset
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GiphyData> {
        return try {
            val response = apiService.getTrendingGifs(API_KEY, LIMIT, offset, REQUEST, "messaging_non_clips")
            offset += LIMIT
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = if (response.data.isEmpty() || response.data.size < LIMIT) null else offset
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true
}