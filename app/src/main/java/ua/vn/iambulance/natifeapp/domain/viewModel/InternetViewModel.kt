package ua.vn.iambulance.natifeapp.domain.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InternetViewModel: ViewModel() {
    private val _isConnected = MutableStateFlow<Boolean>(false)
    val isConnected: StateFlow<Boolean> = _isConnected

    fun setConnectivityStatus(isConnected: Boolean) {
        _isConnected.value = isConnected
    }
}