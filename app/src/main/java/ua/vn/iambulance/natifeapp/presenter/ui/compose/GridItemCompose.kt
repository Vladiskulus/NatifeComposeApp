package ua.vn.iambulance.natifeapp.presenter.ui.compose

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.*

import kotlinx.coroutines.Dispatchers

@Composable
fun GridItem(
    urlImage: String,
    onDeleteClick: () -> Unit
) {
    val context = LocalContext.current
    val dispatcher = Dispatchers.IO.limitedParallelism(5)
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
            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally),
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