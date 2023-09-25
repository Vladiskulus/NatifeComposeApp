package ua.vn.iambulance.natifeapp.presenter.ui.compose


import android.os.Build
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlinx.coroutines.Dispatchers

@Composable
fun LinearItem(
    urlImage: String,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
){
    val context = LocalContext.current
    val dispatcher = Dispatchers.IO.limitedParallelism(5)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        SubcomposeAsyncImage(
            model = urlImage,
            modifier = Modifier
                .size(100.dp)
                .weight(10f)
                .clickable (onClick = onItemClick),
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
                .weight(1f)
                .align(Alignment.CenterVertically),
            onClick = onDeleteClick,

        ) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}

