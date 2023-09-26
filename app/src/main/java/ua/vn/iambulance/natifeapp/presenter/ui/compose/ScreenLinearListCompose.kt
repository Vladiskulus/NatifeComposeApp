package ua.vn.iambulance.natifeapp.presenter.ui.compose

import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
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
        when (val state = data.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //TODO Error Item
            }
            is LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .padding(8.dp),
                            text = "Refresh Loading"
                        )

                        CircularProgressIndicator(color = Color.Black)
                    }
                }
            }
            else -> {}
        }

        when (val state = data.loadState.append) { // Pagination
            is LoadState.Error -> {
                //TODO Pagination Error Item
            }
            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Pagination Loading")

                        CircularProgressIndicator(color = Color.Black)
                    }
                }
            }
            else -> {}
        }
    }
}
