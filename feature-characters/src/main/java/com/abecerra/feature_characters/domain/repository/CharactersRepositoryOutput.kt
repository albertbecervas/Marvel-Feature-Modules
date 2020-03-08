package com.abecerra.feature_characters.domain.repository

import com.abecerra.feature_characters.domain.model.Character

interface CharactersRepositoryOutput {

    fun onCharactersReceived(characters: List<Character>)
}