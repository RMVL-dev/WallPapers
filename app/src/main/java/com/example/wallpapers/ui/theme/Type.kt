package com.example.wallpapers.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wallpapers.R
import com.example.wallpapers.utils.gradient

val Benzin = FontFamily(
    Font(R.font.benzin_regular)
)

// Set of Material typography styles to start with
@OptIn(ExperimentalTextApi::class)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Benzin,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = Benzin,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        letterSpacing = 1.sp,
        brush = gradient
    ),
    headlineMedium = TextStyle(
        fontFamily = Benzin,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    headlineSmall = TextStyle(
        fontFamily = Benzin,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    )
)