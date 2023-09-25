package ua.vn.iambulance.natifeapp.presenter.ui.compose

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.size.Scale
import kotlinx.coroutines.Dispatchers

@Composable
fun SubComposableImageGif(modifier: Modifier, url: String){
    val context = LocalContext.current
    val dispatcher = Dispatchers.IO.limitedParallelism(5)
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
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
}