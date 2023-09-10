package com.example.wallpapers.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperApp(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
){
    Scaffold (
        topBar = {}
    ){paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavGraph.Categories.name,
            modifier = modifier.padding(paddingValues = paddingValues)
        ){
            composable(route = NavGraph.Categories.name){

            }
            composable(route = NavGraph.ListPhotos.name){

            }
            composable(route = NavGraph.OneImage.name){

            }
        }
    }
}