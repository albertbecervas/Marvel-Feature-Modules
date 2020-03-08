package com.abecerra.feature_characters.data.mapper

import com.abecerra.network.dto.CharacterDto
import com.abecerra.feature_characters.domain.model.Character

object CharacterDtoMapper {

    fun map(from: List<CharacterDto>): List<Character> {
        return from.map { it.mapToCharacter() }
    }

    private fun CharacterDto.mapToCharacter(): Character {
        return Character(id, name, description,
            ThumbnailMapper.map(thumbnail)
        )
    }
}