package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel

@Composable
fun LinearList(
    onItemClick: (String) -> Unit
) {
    val mainViewModel = hiltViewModel<MainViewModel>()
    val data = mainViewModel.getTrendingGiphy().collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(data.itemSnapshotList) {  item ->
            LinearItem(
                urlImage = item?.images?.original?.url!!,
                onItemClick = { onItemClick(item.images.original.url) }
            )
        }
    }
}
