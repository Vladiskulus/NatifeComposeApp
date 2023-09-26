package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.*
import ua.vn.iambulance.natifeapp.data.entity.*


@Composable
fun GridList(
    data: List<GiphyData>,
    columns: Int = 2,
    onItemClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(data) { index, item ->
            GridItem(
                urlImage = item.images.original.url,
                onItemClick = { onItemClick(index) }
            )
        }
    }
}
