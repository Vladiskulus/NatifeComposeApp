package ua.vn.iambulance.natifeapp.domain.internetChecker

interface InternetConnectivityListener {
    fun onInternetConnectivityChanged(isConnected: Boolean)
}