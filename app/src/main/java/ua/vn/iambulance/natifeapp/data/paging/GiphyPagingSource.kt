package ua.vn.iambulance.natifeapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ua.vn.iambulance.natifeapp.data.API_KEY
import ua.vn.iambulance.natifeapp.data.LIMIT
import ua.vn.iambulance.natifeapp.data.REQUEST
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.retrofit.ApiService

class GiphyPagingSource(private val apiService: ApiService):PagingSource<Int, GiphyData>() {
    override fun getRefreshKey(state: PagingState<Int, GiphyData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GiphyData> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getTrendingGifs(API_KEY, LIMIT, page * LIMIT, REQUEST, "messaging_non_clips")

            LoadResult.Page(
                data = response.data,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.data.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}