package com.abecerra.feature_characters.presentation.router

import com.abecerra.feature_characters.ui.characters.model.CharacterModel

interface CharactersRouter {
    fun onCharacterClick(characterModel: CharacterModel)
}