package ua.vn.iambulance.natifeapp.presenter.ui.compose

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.*
import kotlinx.coroutines.Dispatchers
import ua.vn.iambulance.natifeapp.R

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

@Composable
fun TextTitle(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text
    )
}

@Composable
fun ButtonBack(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
    }
}

@Composable
fun ButtonClose(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Close, contentDescription = "Back")
    }
}

@Composable
fun ButtonGrid(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(painterResource(id = R.drawable.ic_grid), contentDescription = "Grid")
    }
}

@Composable
fun ButtonLinear(modifier: Modifier, click: () -> Unit) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Menu, contentDescription = "Line")
    }
}