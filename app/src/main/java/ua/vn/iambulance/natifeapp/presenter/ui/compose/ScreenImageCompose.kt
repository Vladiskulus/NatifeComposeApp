package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel

@Composable
fun FullScreenImage(
    urlImage: String)
{
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        SubComposableImageGif(modifier = Modifier.fillMaxSize(), url = urlImage)
    }
}