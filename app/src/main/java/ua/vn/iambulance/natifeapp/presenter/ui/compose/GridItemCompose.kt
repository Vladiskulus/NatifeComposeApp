package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
@Composable
fun GridItem(
    image: ImageBitmap,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                bitmap = image,
                contentDescription = null
            )
            IconButton(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = onDeleteClick
            ) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}