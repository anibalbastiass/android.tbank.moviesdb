package com.anibalbastias.coolmovies.library.base.ui.extension

import android.content.res.Resources
import android.os.Handler
import android.os.SystemClock
import android.util.TypedValue
import android.view.View

fun View.setOnDebouncedClickListener(action: () -> Unit) {
    val actionDebouncer =
        ActionDebouncer(
            action
        )

    // This is the only place in the project where we should actually use setOnClickListener
    setOnClickListener {
        actionDebouncer.notifyAction()
    }
}

fun View.removeOnDebouncedClickListener() {
    setOnClickListener(null)
    isClickable = false
}

private class ActionDebouncer(private val action: () -> Unit) {

    companion object {
        const val DEBOUNCE_INTERVAL_MILLISECONDS = 600L
    }

    private var lastActionTime = 0L

    fun notifyAction() {
        val now = SystemClock.elapsedRealtime()

        val millisecondsPassed = now - lastActionTime
        val actionAllowed = millisecondsPassed > DEBOUNCE_INTERVAL_MILLISECONDS
        lastActionTime = now

        if (actionAllowed) {
            action.invoke()
        }
    }
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.disableAndPostDelayEnabled() {
    this.isEnabled = false
    Handler().postDelayed({
        this.isEnabled = true
    }, 1500)
}

fun dpToPx(dp: Float): Int =
    (TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        Resources.getSystem().displayMetrics
    )).toInt()

fun dpToPx(dp: Int) =
    dpToPx(dp.toFloat())

fun String.Companion.empty() = ""