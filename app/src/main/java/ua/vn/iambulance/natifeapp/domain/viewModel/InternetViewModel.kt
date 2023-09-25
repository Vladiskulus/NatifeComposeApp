package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ua.vn.iambulance.natifeapp.presenter.SCREEN_ORIENTATION_OF_LIST_GRID

class InternetViewModel: ViewModel() {
    private val _isConnected = MutableStateFlow<Boolean>(false)
    val isConnected: StateFlow<Boolean> = _isConnected
    private val _lastScreen = MutableStateFlow<Int>(SCREEN_ORIENTATION_OF_LIST_GRID)
    val lastScreen: StateFlow<Int> = _lastScreen

    fun setConnectivityStatus(isConnected: Boolean) {
        _isConnected.value = isConnected
    }

    fun setLastScreenAsState(state:Int){
        _lastScreen.value = state
    }
}