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
    onItemClick: (Int) -> Unit,
    onDeleteItem: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(data) { index, item ->
            GridItem(
                urlImage = item.images.original.url
                    ?: "https://media4.giphy.com/media/k93vubaq1hKMurHkKs/giphy.gif?cid=035fffcfpla5mg6zrpj0hsamo0fu7rvthzze4xb8p0yc9ob3&ep=v1_gifs_trending&rid=giphy.gif&ct=g",
                onDeleteClick = { onDeleteItem(index) },
                onItemClick = { onItemClick(index) }

            )
        }
    }
}
