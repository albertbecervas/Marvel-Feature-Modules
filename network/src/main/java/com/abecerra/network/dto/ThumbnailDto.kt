package com.abecerra.network.dto

import com.google.gson.annotations.SerializedName

data class ThumbnailDto(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)