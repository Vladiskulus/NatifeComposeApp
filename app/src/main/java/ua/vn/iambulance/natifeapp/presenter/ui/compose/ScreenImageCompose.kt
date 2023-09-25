package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*

@Composable
fun FullScreenImage(
    urlImage: String,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SubComposableImageGif(modifier = Modifier.fillMaxSize(), url = urlImage)
    }
}