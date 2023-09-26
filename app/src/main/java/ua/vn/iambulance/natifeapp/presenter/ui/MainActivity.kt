package ua.vn.iambulance.natifeapp.presenter.ui

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.*
import ua.vn.iambulance.natifeapp.domain.internetChecker.InternetStatusReceiver
import ua.vn.iambulance.natifeapp.domain.viewModel.InternetViewModel

import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel
import ua.vn.iambulance.natifeapp.presenter.*
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

class MainActivity : ComponentActivity(){

    private lateinit var connectivityReceiver: InternetStatusReceiver

    private val mainViewModel by viewModels<MainViewModel>()
    private val internetViewModel by viewModels<InternetViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityReceiver = InternetStatusReceiver(internetViewModel)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, filter)
        setContent {
            val isConnected by internetViewModel.isConnected.collectAsState()
            val lastScreen by internetViewModel.lastScreen.collectAsState()
            val imagePositionState = rememberSaveable {
                mutableStateOf(0)
            }
            val screenState = rememberSaveable {
                mutableStateOf(SCREEN_ORIENTATION_OF_LIST_GRID)
            }
            val scope = rememberCoroutineScope()
            LaunchedEffect(isConnected) {
                if (!isConnected) {
                    screenState.value = SCREEN_INTERNET_IS_NOT_AVAILABLE
                } else {
                    scope.launch {
                        mainViewModel.getGiphy()
                    }
                    screenState.value = lastScreen
                }
            }

            val data by mainViewModel.giphyStateFlow.collectAsState()
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
                            GridList(data = data,
                                onItemClick = {
                                    imagePositionState.value = it
                                    screenState.value = SCREEN_IMAGE
                                },
                                onDeleteItem = {
                                    imagePositionState.value = it
                                })
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
                            LinearList(data = data,
                                onItemClick = {
                                    imagePositionState.value = it
                                    screenState.value = SCREEN_IMAGE
                                },
                                onDeleteItem = {
                                    imagePositionState.value = it
                                })
                            internetViewModel.setLastScreenAsState(screenState.value)

                        }

                        SCREEN_IMAGE-> {
                            TopToolbarWithOneButton(
                                state = screenState.value,
                                onClick = { screenState.value = lastScreen }
                            )
                            FullScreenImage(urlImage = data[imagePositionState.value].images.original.url)
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
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityReceiver)
    }
}