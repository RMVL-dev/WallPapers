package com.example.wallpapers.ui.screens.images

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wallpapers.R
import com.example.wallpapers.model.Photos
import com.example.wallpapers.ui.screens.splash.WallpaperSplash
@Composable
fun GridImagesScreen(
    modifier: Modifier = Modifier,
    imagesViewModel:ImagesViewModel,
    navigateToOneImageScreen: () -> Unit,
){
    when(imagesViewModel.wallpaperState){
        ImagesUIState.Error -> {
            Box (modifier = modifier
                .fillMaxSize()
                .background(Color.Red))
        }
        ImagesUIState.Loading -> {
            WallpaperSplash()
        }
        is ImagesUIState.Success -> {
            GridImages(
                photos = (imagesViewModel.wallpaperState as ImagesUIState.Success).photos,
                navigateToOneImageScreen = navigateToOneImageScreen,
                viewModel = imagesViewModel,
                prevPage = { imagesViewModel.toPreviousPage() },
                nextPage = { imagesViewModel.toNextPage() }
            )

        }
    }
}

@Composable
fun GridImages(
    modifier: Modifier = Modifier,
    photos: Photos,
    navigateToOneImageScreen: () -> Unit,
    viewModel: ImagesViewModel,
    nextPage:()->Unit,
    prevPage:()->Unit,
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        //.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .weight(1f),
        columns = GridCells.Fixed(2)
    ) {
        items(photos.results) { result ->
            GridItem(
                link = result.link.image,
                onClickCard = {
                    viewModel.setCurrentImage(result.link.image)
                    navigateToOneImageScreen()
                }
            )
        }
    }
        Row (
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            IconButton(onClick = { prevPage() }) {
                Icon(
                    painter = painterResource(id = R.drawable.previous_page),
                    contentDescription = ""
                )
            }
            Text(
                text = viewModel.currentPage.toString(),
                fontSize = 15.sp
            )
            IconButton(onClick = { nextPage() }) {
                Icon(
                    painter = painterResource(id = R.drawable.next_page),
                    contentDescription = ""
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    link:String,
    onClickCard:() -> Unit
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(194.dp),
        onClick = {onClickCard() }
    ) {
        AsyncImage(
            model = link,
            contentDescription = "",
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id =R.drawable.loading_img),
            error = painterResource(id = R.drawable.ic_broken_image)
        )
    }
}