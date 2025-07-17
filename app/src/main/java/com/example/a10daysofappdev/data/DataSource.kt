package com.example.a10daysofappdev.data

import com.example.a10daysofappdev.R
import com.example.a10daysofappdev.model.Day

object DataSource {
    val days = listOf<Day>(
        Day(1, R.string.day_1_title, R.drawable.day_1, R.string.day_1_description),
        Day(2, R.string.day_2_title, R.drawable.day_2, R.string.day_2_description),
        Day(3, R.string.day_3_title, R.drawable.day_3, R.string.day_3_description),
        Day(4, R.string.day_4_title, R.drawable.day_4, R.string.day_4_description),
        Day(5, R.string.day_5_title, R.drawable.day_5, R.string.day_5_description),
        Day(6, R.string.day_6_title, R.drawable.day_6, R.string.day_6_description),
        Day(7, R.string.day_7_title, R.drawable.day_7, R.string.day_7_description),
        Day(8, R.string.day_8_title, R.drawable.day_8, R.string.day_8_description),
        Day(9, R.string.day_9_title, R.drawable.day_9, R.string.day_9_description),
        Day(10, R.string.day_10_title, R.drawable.day_10, R.string.day_10_description)
    )
}