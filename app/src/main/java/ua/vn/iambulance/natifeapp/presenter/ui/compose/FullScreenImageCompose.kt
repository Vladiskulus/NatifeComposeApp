package ua.vn.iambulance.natifeapp.presenter.ui.compose

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlinx.coroutines.Dispatchers

@Composable
fun FullScreenImage(
    urlImage: String,
    onDeleteClick: () -> Unit
) {
    val context = LocalContext.current
    val dispatcher = Dispatchers.IO.limitedParallelism(5)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = urlImage,
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },
            imageLoader = ImageLoader.Builder(context)
                .dispatcher(dispatcher)
                .components {
                    if (Build.VERSION.SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .respectCacheHeaders(false)
                .build(),
            contentDescription = null
        )
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = onDeleteClick
        ) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}