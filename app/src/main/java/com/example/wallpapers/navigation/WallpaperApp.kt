package com.example.wallpapers.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallpapers.R
import com.example.wallpapers.ui.screens.categories.CategoriesScreen
import com.example.wallpapers.ui.screens.image.OneImageScreen
import com.example.wallpapers.ui.screens.images.GridImagesScreen
import com.example.wallpapers.ui.screens.images.ImagesViewModel
import com.example.wallpapers.viewmodel.provider.WallpaperViewModelProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    imagesViewModel: ImagesViewModel = viewModel(
        factory = WallpaperViewModelProvider().factory
    ),
    context: Context
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
            )
        }
    ){paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavGraph.Categories.name,
            modifier = modifier.padding(paddingValues = paddingValues)
        ){
            composable(route = NavGraph.Categories.name){
                CategoriesScreen(
                    viewModel = imagesViewModel,
                    context = context,
                    navigateToImagesScreen = {
                        navController.navigate(route = NavGraph.ListPhotos.name)
                    }
                )
            }
            composable(route = NavGraph.ListPhotos.name){
                GridImagesScreen(
                    imagesViewModel = imagesViewModel,
                    navigateToOneImageScreen = { navController.navigate(route = NavGraph.OneImage.name)}
                )
            }
            composable(route = NavGraph.OneImage.name){
                imagesViewModel.currentImage?.let {
                        imageUrl -> OneImageScreen(imageUrl = imageUrl)
                }
            }
        }
    }
}