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
import dagger.hilt.android.AndroidEntryPoint
import ua.vn.iambulance.natifeapp.domain.internetChecker.InternetStatusReceiver
import ua.vn.iambulance.natifeapp.domain.viewModel.ScreenStatusViewModel
import ua.vn.iambulance.natifeapp.presenter.*
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

@AndroidEntryPoint
class MainActivity : ComponentActivity(){

    private lateinit var connectivityReceiver: InternetStatusReceiver

    private val screenStatusViewModel by viewModels<ScreenStatusViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNetworkConnectionReceiver()
        setContent {
           MainScreen()
        }
    }

    @Composable
    fun MainScreen(){
        val isConnected by screenStatusViewModel.isConnected.collectAsState()
        val lastScreen by screenStatusViewModel.lastScreen.collectAsState()
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
                        screenStatusViewModel.setLastScreenAsState(screenState.value)
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
                        screenStatusViewModel.setLastScreenAsState(screenState.value)
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
        connectivityReceiver = InternetStatusReceiver(screenStatusViewModel)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityReceiver)
    }
}