package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InternetIsNotAvailable(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Internet is not available. \n Please connect your device to internet.",
        modifier = Modifier.align(Alignment.Center))
    }
}