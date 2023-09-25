package ua.vn.iambulance.natifeapp.presenter.ui

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.*
import ua.vn.iambulance.natifeapp.domain.internetChecker.InternetConnectivityListener
import ua.vn.iambulance.natifeapp.domain.internetChecker.InternetStatusReceiver
import ua.vn.iambulance.natifeapp.domain.viewModel.InternetViewModel

import ua.vn.iambulance.natifeapp.domain.viewModel.MainViewModel
import ua.vn.iambulance.natifeapp.extension.*
import ua.vn.iambulance.natifeapp.presenter.*
import ua.vn.iambulance.natifeapp.presenter.ui.compose.*

class MainActivity : ComponentActivity(), InternetConnectivityListener {

    private lateinit var connectivityReceiver: InternetStatusReceiver

    private val mainViewModel by viewModels<MainViewModel>()
    private val internetViewModel by viewModels<InternetViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityReceiver = InternetStatusReceiver(this)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(connectivityReceiver, filter)
//        val localDB = getSharedPreferences(USER_DEFAULT, Context.MODE_PRIVATE)
        setContent {
            val imagePositionState = rememberSaveable {
                mutableStateOf(0)
            }
            val screenState = rememberSaveable {
                mutableStateOf(SCREEN_ORIENTATION_OF_LIST_GRID)
            }
            val scope = rememberCoroutineScope()
            LaunchedEffect(key1 = Unit) {
                scope.launch {
                    mainViewModel.getGiphy()
                }
            }
            val context = LocalContext.current
            val isConnected by internetViewModel.isConnected.collectAsState()
            val data by mainViewModel.giphyStateFlow.collectAsState()
            if (!isConnected){
                screenState.value = SCREEN_INTERNET_IS_NOT_AVAILABLE
            }
            Column {
                TopToolbar(
                    title = "Giphy Natife App",
                    onBackClick = { finish() },
                    onGridClick = {
                        screenState.value = SCREEN_ORIENTATION_OF_LIST_GRID
                        //localDB.put(DB_SCREEN, SCREEN_ORIENTATION_OF_LIST_GRID)
                    },
                    onLinearClick = {
                        screenState.value = SCREEN_ORIENTATION_OF_LIST_LINEAR
                        //localDB.put(DB_SCREEN, SCREEN_ORIENTATION_OF_LIST_LINEAR)
                    }
                )
                when(screenState.value){
                    SCREEN_ORIENTATION_OF_LIST_GRID -> {
                        GridList(data = data,
                            onItemClick = {
                                imagePositionState.value = it
                                screenState.value = SCREEN_IMAGE
                                //localDB.put(DB_SCREEN, SCREEN_IMAGE)
                            },
                            onDeleteItem = {
                                imagePositionState.value = it
                            })
                    }
                    SCREEN_ORIENTATION_OF_LIST_LINEAR -> {
                        LinearList(data = data,
                            onItemClick = {
                                imagePositionState.value = it
                                screenState.value = SCREEN_IMAGE
                                //localDB.put(DB_SCREEN, SCREEN_IMAGE)
                            },
                            onDeleteItem = {
                                imagePositionState.value = it
                            })

                    }
                    SCREEN_INTERNET_IS_NOT_AVAILABLE -> {
                        InternetIsNotAvailable()
                    }
                    SCREEN_IMAGE-> {
                        FullScreenImage(urlImage = data[imagePositionState.value].images.original.url) {

                        }
                    }
                }
            }

        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(connectivityReceiver)
    }

    override fun onInternetConnectivityChanged(isConnected: Boolean) {
        internetViewModel.setConnectivityStatus(isConnected)
    }
}