package ua.vn.iambulance.natifeapp

import android.content.Context
import dagger.hilt.EntryPoint


interface AppComponents {

    fun getContext(): Context

}