package com.example.wallpapers.model.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links (
    @SerialName("download")
    val image: String
)