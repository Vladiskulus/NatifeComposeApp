package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*

import kotlinx.coroutines.Dispatchers

@Composable
fun GridItem(
    urlImage: String,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(10.dp)

    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubComposableImageGif(modifier = Modifier
                .size(200.dp)
                .clickable(onClick = onItemClick)
                .align(Alignment.CenterHorizontally), url = urlImage)
        }
    }
}