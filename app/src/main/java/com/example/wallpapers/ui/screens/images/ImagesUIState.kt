package com.example.wallpapers.ui.screens.images

import com.example.wallpapers.model.Photos

sealed interface ImagesUIState{

    data class Success(val photos: Photos):ImagesUIState

    object Error:ImagesUIState

    object Loading: ImagesUIState
}