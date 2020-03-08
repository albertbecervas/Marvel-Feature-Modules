package com.abecerra.feature_characters.presentation.model

import com.abecerra.feature_characters.domain.model.Character
import com.abecerra.feature_characters.ui.characters.model.CharacterModel


object CharacterModelMapper {

    fun map(from: List<Character>): List<CharacterModel> {
        return from.map { mapToCharacterModel(it) }
    }

    private fun mapToCharacterModel(from: Character): CharacterModel {
        return with(from) {
            CharacterModel(id, name, description, thumbnail)
        }
    }
}