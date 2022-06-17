package com.swancodes.androidplayground.util

import android.content.Context
import android.content.Intent

fun Context.navigate(activity: Class<*>) {
    val intent = Intent(this, activity)

    startActivity(intent)
}
