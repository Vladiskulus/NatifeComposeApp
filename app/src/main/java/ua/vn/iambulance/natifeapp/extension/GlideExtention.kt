package ua.vn.iambulance.natifeapp.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

infix fun Context.loadImageFromUrl(url:String): Bitmap? {
    var bitmap:Bitmap? = null
    Glide.with(this).asBitmap().load(url).into(object: CustomTarget<Bitmap>(){
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
            bitmap = resource
        }

        override fun onLoadCleared(placeholder: Drawable?) {
            bitmap = null
        }
    })
    return bitmap
}