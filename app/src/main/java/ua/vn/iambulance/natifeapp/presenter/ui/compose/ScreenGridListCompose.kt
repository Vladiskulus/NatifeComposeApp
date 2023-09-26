package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import ua.vn.iambulance.natifeapp.data.entity.*
import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel


@Composable
fun GridList(
    onItemClick: (String) -> Unit
) {
    val mainViewModel = hiltViewModel<MainViewModel>()
    val data = mainViewModel.getTrendingGiphy().collectAsLazyPagingItems()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(data.itemSnapshotList) {  item ->
            GridItem(
                urlImage = item?.images?.original?.url!!,
                onItemClick = { onItemClick(item.images.original.url) }
            )
        }
    }
}
