package ua.vn.iambulance.natifeapp.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import ua.vn.iambulance.natifeapp.data.entity.ImageItemEntity

@Composable
fun LinearList(
    items: List<ImageItemEntity>,
    onDeleteItem: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(items) { index, item ->
            LinearItem(
                image = item.image.asImageBitmap(),
                header = item.textHeader,
                description = item.textDescription,
                onDeleteClick = { onDeleteItem(index) }
            )
        }
    }
}
