package ua.vn.iambulance.natifeapp.presenter.ui.compose


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import kotlinx.coroutines.Dispatchers

@Composable
fun LinearItem(
    urlImage: String,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubComposableImageGif(modifier = Modifier
            .size(100.dp)
            .weight(10f)
            .clickable(onClick = onItemClick), url = urlImage)
    }
}

