package com.example.a10daysofappdev.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
