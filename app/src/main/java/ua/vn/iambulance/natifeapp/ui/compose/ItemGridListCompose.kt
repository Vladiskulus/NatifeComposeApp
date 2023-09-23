package ua.vn.iambulance.natifeapp.ui.compose

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
    header: String,
    description: String,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier.padding(8.dp)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(200.dp)
                    .align(Alignment.CenterHorizontally),
                bitmap = image,
                contentDescription = null
            )
            Text(
                text = header,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                        .align(Alignment.CenterHorizontally),
            )
            Text(
                text = description,
                fontSize = 14.sp,
                        modifier = Modifier
                        .align(Alignment.CenterHorizontally),
            )
            IconButton(
                modifier = Modifier.size(50.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = onDeleteClick
            ) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}