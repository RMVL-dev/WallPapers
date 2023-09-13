package com.example.wallpapers.ui.screens.images

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.wallpapers.di.interfaces.WallpaperRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat

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

    private fun getListPhotos(){

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

    fun setWallPaper(context: Context){
        val wallpaperManager = WallpaperManager.getInstance(context)
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(currentImage)
            .build()
        viewModelScope.launch {
            val image = (loader.execute(request = request) as SuccessResult).drawable
            try{
                wallpaperManager.setBitmap(image.toBitmap())
            }
            catch (e:Exception){
                Toast.makeText(context,":(", Toast.LENGTH_LONG).show()
            }
        }

    }


    fun downloadImage(context: Context){
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Wallpapers")
        val fileName = "${file.absolutePath}/${"IMG_${SimpleDateFormat("yyyymmsshhmmss")}.jpg"}"
        val imageFile = File(fileName)

        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(currentImage)
            .build()

        if (!file.exists() && !file.mkdirs()) {
            file.mkdir()

        }

        viewModelScope.launch{
            try {
                val outputStream = FileOutputStream(imageFile)
                val image =
                    ((loader.execute(request = request) as SuccessResult).drawable as BitmapDrawable).bitmap
                image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            }catch (e:IOException){
                Log.d("DOWNLOAD_", "$e")
            }catch (e:FileNotFoundException){
                Log.d("DOWNLOAD_", "$e")
            }
        }

    }
}