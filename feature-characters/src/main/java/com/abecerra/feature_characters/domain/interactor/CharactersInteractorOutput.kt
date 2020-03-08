package com.abecerra.feature_characters.domain.interactor

import com.abecerra.feature_characters.domain.model.Character

interface CharactersInteractorOutput {

    fun onCharactersReceived(characters: List<Character>)
}