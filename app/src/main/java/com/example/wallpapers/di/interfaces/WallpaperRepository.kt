package com.example.wallpapers.di.interfaces

import com.example.wallpapers.model.Photos

interface WallpaperRepository {
    suspend fun getWallpapers(page:Int, category:String):Photos
}