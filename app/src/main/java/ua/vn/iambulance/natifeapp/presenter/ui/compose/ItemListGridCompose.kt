package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

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