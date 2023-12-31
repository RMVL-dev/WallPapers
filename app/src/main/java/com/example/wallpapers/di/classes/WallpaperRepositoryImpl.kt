package com.example.wallpapers.di.classes

import com.example.wallpapers.di.interfaces.WallpaperRepository
import com.example.wallpapers.model.Photos
import com.example.wallpapers.network.WallpaperService

class WallpaperRepositoryImpl(
    private val retrofitWallpaperService:WallpaperService
): WallpaperRepository {
    override suspend fun getWallpapers(page:Int, category:String): Photos =
        retrofitWallpaperService
            .getListWallPapers("photos?page=$page&query=$category&client_id=ATxkfUDyTaJcmcNfpLOadn1sbppwgMYVY2K1Fo3neJk")
}