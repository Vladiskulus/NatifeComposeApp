package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import ua.vn.iambulance.natifeapp.domain.entity.ImageItemEntity
import ua.vn.iambulance.natifeapp.presenter.entity.Image

@Composable
fun LinearList(
    items: List<Image>,
    onDeleteItem: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(items) { index, item ->
            LinearItem(
                image = item.image.asImageBitmap(),
                onDeleteClick = { onDeleteItem(index) }
            )
        }
    }
}
