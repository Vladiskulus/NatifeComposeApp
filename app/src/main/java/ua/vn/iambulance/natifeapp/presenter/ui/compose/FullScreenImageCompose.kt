package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import coil.size.Scale
import kotlinx.coroutines.Dispatchers

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