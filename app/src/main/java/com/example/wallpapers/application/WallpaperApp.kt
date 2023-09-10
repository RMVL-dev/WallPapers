package com.example.wallpapers.application

import android.app.Application
import com.example.wallpapers.di.classes.WallpaperContainerImpl
import com.example.wallpapers.di.interfaces.WallpaperContainer

class WallpaperApp:Application() {

    lateinit var wallpaperContainer: WallpaperContainer

    override fun onCreate() {
        super.onCreate()
        wallpaperContainer = WallpaperContainerImpl()
    }
}