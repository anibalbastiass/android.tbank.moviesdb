package com.anibalbastias.coolmovies.library.base.presentation.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val ddmmyyyyFormat = "yyyy-MM-dd"
private const val MMMddyyyyFormat = "MMM dd, yyyy"

fun String.formatDate(): String {
    var format = SimpleDateFormat(ddmmyyyyFormat, Locale.ENGLISH)
    format.timeZone = TimeZone.getTimeZone("UTC")
    var newDate: Date? = null
    try {
        newDate = format.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    format = SimpleDateFormat(MMMddyyyyFormat, Locale.ENGLISH)
    format.timeZone = TimeZone.getDefault()

    return format.format(newDate)
}