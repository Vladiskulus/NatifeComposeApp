package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun FullScreenImage(
    image: ImageBitmap,
    header: String,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            bitmap = image,
            contentDescription = null
        )
        Text(
            modifier = Modifier.align(Alignment.TopCenter),
            text = header,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = onDeleteClick
        ) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}