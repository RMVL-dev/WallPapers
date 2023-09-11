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

    var currentImage: String? = null
        private set
    init {
        getListPhotos(
            page = 1,
            category = "80s"
        )
    }

    fun getListPhotos(page:Int, category:String){

        viewModelScope.launch {
            wallpaperState = try {
                ImagesUIState.Success(
                    photos = repository.getWallpapers(
                        page = page,
                        category = category.replace(" ","-")
                    )
                )
            }catch (e:HttpException){
                ImagesUIState.Error
            }catch (e:IOException){
                ImagesUIState.Error
            }
        }

    }

    fun setCurrentImage(imageUrl:String){
        currentImage = imageUrl
    }
}