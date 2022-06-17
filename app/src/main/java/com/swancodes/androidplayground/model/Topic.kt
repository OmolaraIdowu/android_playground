package com.swancodes.androidplayground.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    @StringRes val details: Int,
) : Parcelable