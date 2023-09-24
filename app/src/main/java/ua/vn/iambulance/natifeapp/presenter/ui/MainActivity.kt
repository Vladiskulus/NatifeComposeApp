package ua.vn.iambulance.natifeapp.presenter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.*
import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.data.retrofit.RetrofitClient
import ua.vn.iambulance.natifeapp.domain.GetGiphyUseCase

import ua.vn.iambulance.natifeapp.domain.view_models.MainViewModel
import ua.vn.iambulance.natifeapp.extension.nonNullObserve
import ua.vn.iambulance.natifeapp.presenter.GRID_ORIENTATION
import ua.vn.iambulance.natifeapp.presenter.INTERNET_IS_NOT_AVAILABLE
import ua.vn.iambulance.natifeapp.presenter.LINEAR_ORIENTATION
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDefaultValues()
        setContent {
            val scope = rememberCoroutineScope()
            LaunchedEffect(key1 = Unit) {
                scope.launch {
                    mainViewModel.getGiphy()
                }
            }
            val data by mainViewModel.giphyStateFlow.collectAsState()
            Column {
                val listState = rememberSaveable {
                    mutableStateOf(LINEAR_ORIENTATION)
                }
                TopToolbar(
                    title = "Giphy Natife App",
                    onBackClick = { finish() },
                    onGridClick = {
                        listState.value = GRID_ORIENTATION
                    },
                    onLinearClick = {
                        listState.value = LINEAR_ORIENTATION
                    }
                )
                when(listState.value){
                    GRID_ORIENTATION -> {
                        GridList(data = data,
                            onDeleteItem = {

                            })
                    }
                    LINEAR_ORIENTATION -> {
                        LinearList(data = data,
                            onDeleteItem = {

                            })
                    }
                    INTERNET_IS_NOT_AVAILABLE -> {
                        //need implement broadcast receiver
                    }
                }
            }

        }
    }

    private fun setDefaultValues() {
        val postRepository = GiphyRepository(RetrofitClient().apiService)
        val getGiphyUseCase = GetGiphyUseCase(postRepository)

        //mainViewModel = ViewModelProvider(this)[MainViewModel(getPostsUseCase)::class.java]
    }

    private fun setViewModelCallback(dataState: MutableState<List<GiphyData>>, offset: Int = 0) {
        mainViewModel.gifsLiveData.nonNullObserve(this) {
            dataState.value = it
        }
    }
}