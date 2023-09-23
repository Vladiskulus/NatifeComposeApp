package ua.vn.iambulance.natifeapp.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import ua.vn.iambulance.natifeapp.R
import ua.vn.iambulance.natifeapp.data.entity.ImageItemEntity
import ua.vn.iambulance.natifeapp.ui.compose.GridList
import ua.vn.iambulance.natifeapp.ui.compose.TopToolbar

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
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item2", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item3", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item4", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item5", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item2", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item3", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item4", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item5", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item2", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item3", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item4", "item"),
                    ImageItemEntity(BitmapFactory.decodeResource(resources, R.drawable.bg), "item5", "item"),
                    ) , onDeleteItem = {

                })
            }

        }
    }
}