package com.example.wallpapers.ui.screens.image

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wallpapers.R
import com.example.wallpapers.utils.gradient

@SuppressLint("ResourceType")
@Composable
fun OneImageScreen(
    modifier: Modifier = Modifier,
    imageUrl:String,
    setWallpaper: () -> Unit,
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
       AsyncImage(
           model = imageUrl,
           contentDescription = "",
           modifier = modifier
               .fillMaxWidth()
               .defaultMinSize(minHeight = 400.dp)
               .padding(16.dp),
           alignment = Alignment.Center,
           placeholder = painterResource(id =R.drawable.loading_img),
           error = painterResource(id = R.drawable.ic_broken_image)
       )
        Column (
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp),
                onClick = setWallpaper,
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
                shape = RoundedCornerShape(30.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = gradient,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.set_wallpaper).uppercase(),
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp),
                onClick = {

                },
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
                shape = RoundedCornerShape(30.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = gradient,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.download).uppercase(),
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }






        }
    }
}