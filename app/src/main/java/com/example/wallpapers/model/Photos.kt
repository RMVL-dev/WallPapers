package com.example.wallpapers.model

import com.example.wallpapers.model.utils.Results
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photos(
    @SerialName("results")
    val results: List<Results>
)
