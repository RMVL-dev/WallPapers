package com.example.wallpapers.di.classes

import com.example.wallpapers.di.interfaces.WallpaperContainer
import com.example.wallpapers.di.interfaces.WallpaperRepository
import com.example.wallpapers.network.WallpaperService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class WallpaperContainerImpl: WallpaperContainer {

    private val BASE_URL = "https://api.unsplash.com/search/"

    //photos?page=1&query=lofi&client_id=ATxkfUDyTaJcmcNfpLOadn1sbppwgMYVY2K1Fo3neJk

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("json/application".toMediaType()))
        .build()

    private val retrofitWallpaperService:WallpaperService by lazy {
        retrofit.create(WallpaperService::class.java)
    }

    override val wallpaperRepository: WallpaperRepository by lazy {
        WallpaperRepositoryImpl(retrofitWallpaperService = retrofitWallpaperService)
    }
}