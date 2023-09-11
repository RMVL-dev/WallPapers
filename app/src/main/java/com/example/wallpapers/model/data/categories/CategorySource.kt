package com.example.wallpapers.model.data.categories

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wallpapers.R

data class Category(
    @StringRes
    val category: Int,
    @DrawableRes
    val background: Int
)


val categories = listOf(
    Category(R.string.category_lo_fi, R.drawable.category_lofi),
    Category(R.string.category_cats,R.drawable.category_cats),
    Category(R.string.category_dogs,R.drawable.category_dogs),
    Category(R.string.category_cannabis,R.drawable.category_cannabis),
    Category(R.string.category_dc_characters,R.drawable.category_dc_character),
    Category(R.string.category_marvel_characters,R.drawable.category_marvel_comics),
    Category(R.string.category_dragons,R.drawable.category_dragons),
    Category(R.string.category_jdm,R.drawable.category_jdm),
    Category(R.string.category_minimalism,R.drawable.category_minimalism),
    Category(R.string.category_night_city,R.drawable.category_night_city),
    Category(R.string.category_mountains,R.drawable.category_mountains),
    Category(R.string.category_spider_web,R.drawable.category_spider_web),
)