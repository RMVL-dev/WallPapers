package com.example.wallpapers.ui.screens.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wallpapers.R

@Composable
fun OneImageScreen(
    modifier: Modifier = Modifier,
    imageUrl:String
){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
       AsyncImage(
           model = imageUrl,
           contentDescription = "",
           modifier = modifier
               .fillMaxWidth()
               .defaultMinSize(minHeight = 400.dp)
               .padding(16.dp),
           alignment = Alignment.Center
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
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF7F0642),
                                    Color(0xFFF50243),
                                    Color(0xFFF55F2A)
                                )
                            ),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.set_wallpaper).uppercase(),
                        fontSize = 20.sp,
                        color = Color.White
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
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF7F0642),
                                    Color(0xFFF50243),
                                    Color(0xFFF55F2A)
                                )
                            ),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.download).uppercase(),
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }






        }
    }
}