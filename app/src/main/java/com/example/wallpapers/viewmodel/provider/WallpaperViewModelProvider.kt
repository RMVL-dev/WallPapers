package com.example.wallpapers.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.wallpapers.application.WallpaperApp
import com.example.wallpapers.ui.screens.images.ImagesViewModel

class WallpaperViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            ImagesViewModel(repository = wallpaperApplication().wallpaperContainer.wallpaperRepository)
        }
    }
}

fun CreationExtras.wallpaperApplication(): WallpaperApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as WallpaperApp)