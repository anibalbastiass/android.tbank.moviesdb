package com.anibalbastias.coolmovies.library.base.presentation.extension

fun Int.applyMilesSeparator(): String {
    return String.format("%,d", this)
}