package com.anibalbastias.coolmovies.library.base.ui.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.anibalbastias.coolmovies.library.base.R

@SuppressLint("ShowToast")
fun Activity.getToastTypeFaced(text: String, duration: Int = Toast.LENGTH_SHORT): Toast {
    val toast = Toast.makeText(this, text, duration)
    val typeface = ResourcesCompat.getFont(applicationContext!!, R.font.opensans_regular)
    val toastLayout = toast.view as? LinearLayout
    val toastTV = (toastLayout?.getChildAt(0) as? TextView)
    toastTV?.typeface = typeface
    return toast
}

fun Activity.toast(text: String?, duration: Int = Toast.LENGTH_SHORT) =
    text?.let {
        getToastTypeFaced(text, duration).show()
    }

fun SwipeRefreshLayout.initSwipe(onSwipeUnit: (() -> Unit)?) {
    this.setColorSchemeColors(ContextCompat.getColor(context, R.color.primaryColor))
    this.setOnRefreshListener { onSwipeUnit?.invoke() }
}