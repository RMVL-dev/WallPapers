package com.example.wallpapers.ui.screens.images

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.di.interfaces.WallpaperRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ImagesViewModel(
    private val repository: WallpaperRepository
):ViewModel() {

    var wallpaperState:ImagesUIState by mutableStateOf(ImagesUIState.Loading)
        private set


    fun getListPhotos(){

        viewModelScope.launch {
            wallpaperState = try {
                ImagesUIState.Success(
                    photos = repository.getWallpapers()
                )
            }catch (e:HttpException){
                ImagesUIState.Error
            }catch (e:IOException){
                ImagesUIState.Error
            }
        }

    }
}