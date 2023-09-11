package com.example.wallpapers.model.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link (
    @SerialName("download")
    val image: String
)