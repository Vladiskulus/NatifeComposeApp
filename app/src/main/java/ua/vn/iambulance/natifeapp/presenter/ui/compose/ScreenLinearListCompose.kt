package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.vn.iambulance.natifeapp.data.entity.GiphyData

@Composable
fun LinearList(
    data: List<GiphyData>,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(data) { index, item ->
            LinearItem(
                urlImage = item.images.original.url,
                onItemClick = { onItemClick(index) }
            )
        }
    }
}
