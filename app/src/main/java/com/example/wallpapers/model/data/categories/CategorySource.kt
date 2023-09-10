package com.example.wallpapers.model.data.categories

import androidx.annotation.StringRes
import com.example.wallpapers.R

data class Category(
    @StringRes
    val category: Int
)


val categories = listOf(
    Category(R.string.category_lo_fi)
)