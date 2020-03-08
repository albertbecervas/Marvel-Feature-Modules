package com.abecerra.feature_characters.domain.interactor

import com.abecerra.base.domain.BaseInteractor

interface CharactersInteractor: BaseInteractor<CharactersInteractorOutput> {

    fun getCharacters(offset: Int)

    fun searchCharactersByName(nameStartWith: String)
}