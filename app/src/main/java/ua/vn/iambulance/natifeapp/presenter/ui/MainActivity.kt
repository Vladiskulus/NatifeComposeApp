package ua.vn.iambulance.natifeapp.presenter.ui

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import ua.vn.iambulance.natifeapp.data.entity.GiphyData
import ua.vn.iambulance.natifeapp.domain.internetChecker.InternetStatusReceiver
import ua.vn.iambulance.natifeapp.domain.viewModel.InternetViewModel

import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel
import ua.vn.iambulance.natifeapp.presenter.*
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    private lateinit var connectivityReceiver: InternetStatusReceiver

    private val internetViewModel by viewModels<InternetViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNetworkConnectionReceiver()
        setContent {
           MainScreen()
        }
    }

    @Composable
    fun MainScreen(){
        val isConnected by internetViewModel.isConnected.collectAsState()
        val lastScreen by internetViewModel.lastScreen.collectAsState()
        val imageState = rememberSaveable {
            mutableStateOf("")
        }
        val screenState = rememberSaveable {
            mutableStateOf(SCREEN_ORIENTATION_OF_LIST_GRID)
        }
        LaunchedEffect(isConnected) {
            if (!isConnected) {
                screenState.value = SCREEN_INTERNET_IS_NOT_AVAILABLE
            } else {
                screenState.value = lastScreen
            }
        }
        Column {
            if (isConnected){
                when(screenState.value){
                    SCREEN_ORIENTATION_OF_LIST_GRID -> {
                        TopToolbarWithListSorting(
                            title = "Giphy Natife App",
                            onCrossClick = { finish() },
                            onGridClick = {
                                screenState.value = SCREEN_ORIENTATION_OF_LIST_GRID
                            },
                            onLinearClick = {
                                screenState.value = SCREEN_ORIENTATION_OF_LIST_LINEAR
                            }
                        )
                        GridList(
                            onItemClick = {
                                imageState.value = it
                                screenState.value = SCREEN_IMAGE
                            }
                        )
                        internetViewModel.setLastScreenAsState(screenState.value)
                    }
                    SCREEN_ORIENTATION_OF_LIST_LINEAR -> {

                        TopToolbarWithListSorting(
                            title = "Giphy Natife App",
                            onCrossClick = { finish() },
                            onGridClick = {
                                screenState.value = SCREEN_ORIENTATION_OF_LIST_GRID
                            },
                            onLinearClick = {
                                screenState.value = SCREEN_ORIENTATION_OF_LIST_LINEAR
                            }
                        )
                        LinearList(
                            onItemClick = {
                                imageState.value = it
                                screenState.value = SCREEN_IMAGE
                            })
                        internetViewModel.setLastScreenAsState(screenState.value)

                    }

                    SCREEN_IMAGE-> {
                        TopToolbarWithOneButton(
                            state = screenState.value,
                            onClick = { screenState.value = lastScreen }
                        )
                        FullScreenImage(urlImage = imageState.value)
                    }
                }
            } else {
                TopToolbarWithOneButton(
                    state = screenState.value,
                    onClick = {}
                )
                InternetIsNotAvailable()
            }
        }
    }

    private fun initNetworkConnectionReceiver(){
        connectivityReceiver = InternetStatusReceiver(internetViewModel)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityReceiver)
    }
}