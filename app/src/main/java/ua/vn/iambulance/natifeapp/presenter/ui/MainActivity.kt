package ua.vn.iambulance.natifeapp.presenter.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.vn.iambulance.natifeapp.R
import ua.vn.iambulance.natifeapp.data.API_KEY
import ua.vn.iambulance.natifeapp.data.retrofit.RetrofitClient
import ua.vn.iambulance.natifeapp.presenter.entity.Image
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            RetrofitClient().apiService.getTrendingGifs(
                API_KEY, 25,
                0,
                "g",
                "messaging_non_clips"
            )

        }

        setContent {
            Column {
                TopToolbar(
                    title = "Giphy Natife App",
                    onBackClick = { finish() },
                    onGridClick = { },
                    onLinearClick = { }
                )
                GridList(items = listOf(
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg)),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg))
                ), onDeleteItem = {

                })
            }

        }
    }
}