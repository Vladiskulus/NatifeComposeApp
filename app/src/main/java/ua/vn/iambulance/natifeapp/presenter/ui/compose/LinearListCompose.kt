package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.presenter.LINEAR_ORIENTATION

@Composable
fun LinearList(
    data: List<GiphyData>,
    onItemClick: (Int) -> Unit,
    onDeleteItem: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(data) { index, item ->
            LinearItem(
                urlImage = item.images.original.url
                    ?: "https://media4.giphy.com/media/k93vubaq1hKMurHkKs/giphy.gif?cid=035fffcfpla5mg6zrpj0hsamo0fu7rvthzze4xb8p0yc9ob3&ep=v1_gifs_trending&rid=giphy.gif&ct=g",
                onDeleteClick = { onDeleteItem(index) },
                onItemClick = { onItemClick(index) }
            )
        }
    }
}
