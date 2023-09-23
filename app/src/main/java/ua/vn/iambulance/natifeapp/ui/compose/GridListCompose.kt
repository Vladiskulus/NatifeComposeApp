package ua.vn.iambulance.natifeapp.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*
import ua.vn.iambulance.natifeapp.data.entity.ImageItemEntity


@Composable
fun GridList(
    items: List<ImageItemEntity>,
    columns: Int = 2,
    onDeleteItem: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items) { index, item ->
            GridItem(
                image = item.image.asImageBitmap(),
                header = item.textHeader,
                description = item.textDescription,
                onDeleteClick = { onDeleteItem(index) }
            )
        }
    }
}
