package com.example.wallpapers.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpapers.R
import com.example.wallpapers.ui.theme.Benzin
import com.example.wallpapers.utils.gradient

@OptIn(ExperimentalTextApi::class)
@Composable
fun WallpaperSplash(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontFamily = Benzin,
            style = TextStyle(brush = gradient)
        )
        CircularProgressIndicator(
            modifier = modifier.padding(16.dp),
            color = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SplashPreview(){
    WallpaperSplash()
}