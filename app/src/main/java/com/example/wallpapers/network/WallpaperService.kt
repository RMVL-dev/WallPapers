package com.example.wallpapers.network

import com.example.wallpapers.model.Photos
import retrofit2.http.GET
import retrofit2.http.Url

interface WallpaperService {
    @GET
    suspend fun getListWallPapers(@Url query:String):Photos
}