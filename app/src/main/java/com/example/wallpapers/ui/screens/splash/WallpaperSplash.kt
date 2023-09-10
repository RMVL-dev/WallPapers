package com.example.wallpapers.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.wallpapers.R

@Composable
fun WallpaperSplash(
    modifier: Modifier = Modifier
){

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
            ){

            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 30.sp,
                color = Color.White
            )

            CircularProgressIndicator(
                modifier = modifier,
                color = Color.White
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun SplashPreview(){
    WallpaperSplash()
}