package com.lucasyago.gastoviagem.util

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)