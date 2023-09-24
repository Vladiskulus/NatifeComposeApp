package ua.vn.iambulance.natifeapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


class NatifeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        
    }


    lateinit var context: Context
}