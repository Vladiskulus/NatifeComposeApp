package ua.vn.iambulance.natifeapp.presenter.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import ua.vn.iambulance.natifeapp.R
import ua.vn.iambulance.natifeapp.domain.entity.ImageItemEntity
import ua.vn.iambulance.natifeapp.presenter.entity.Image
import ua.vn.iambulance.natifeapp.presenter.ui.compose.GridList
import ua.vn.iambulance.natifeapp.presenter.ui.compose.TopToolbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TopToolbar(
                    title = "Giphy Natife App",
                    onBackClick = { finish() },
                    onGridClick = { },
                    onLinearClick = { }
                )
                GridList(items = listOf(
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) ),
                    Image(BitmapFactory.decodeResource(resources, R.drawable.bg) )
                    ) , onDeleteItem = {

                })
            }

        }
    }
}