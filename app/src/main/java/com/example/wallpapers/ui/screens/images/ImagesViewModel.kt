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

    var currentCategory: String = "80s"
        private set

    var currentPage:Int = 1
        private set
    init {
        getListPhotos()
    }

    fun getListPhotos(){

        viewModelScope.launch {
            wallpaperState = try {
                ImagesUIState.Success(
                    photos = repository.getWallpapers(
                        page = currentPage,
                        category = currentCategory.replace(" ","-")
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

    fun toNextPage(){
        currentPage++
        getListPhotos()
    }

    fun toPreviousPage(){
        if (currentPage<1){
            currentPage = 1
        }else{
            currentPage--
        }
        getListPhotos()
    }

    fun changeCategory(category: String){
        currentPage = 1
        currentCategory = category
        getListPhotos()
    }
}