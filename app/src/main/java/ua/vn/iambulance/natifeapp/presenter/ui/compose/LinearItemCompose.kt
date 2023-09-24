package ua.vn.iambulance.natifeapp.presenter.ui.compose


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import coil.compose.SubcomposeAsyncImage

@Composable
fun LinearItem(
    urlImage: String,
    onDeleteClick: () -> Unit
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubcomposeAsyncImage(
            model = urlImage,
            modifier = Modifier.size(50.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            modifier = Modifier.size(30.dp),
            onClick = onDeleteClick
        ) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}

