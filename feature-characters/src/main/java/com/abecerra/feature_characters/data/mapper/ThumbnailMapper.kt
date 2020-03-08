package com.abecerra.feature_characters.data.mapper

import com.abecerra.network.dto.ThumbnailDto

object ThumbnailMapper {

    private const val DOT: String = "."


    fun map(thumbnail: ThumbnailDto): String {
        return thumbnail.path.replace("http", "https") + DOT + thumbnail.extension
    }
}