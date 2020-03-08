package com.abecerra.feature_characters.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.abecerra.feature_characters.domain.model.Character
import com.abecerra.feature_characters.domain.repository.CharactersRepository
import com.abecerra.feature_characters.domain.repository.CharactersRepositoryOutput

class CharactersInteractorImpl(private val charactersRepository: CharactersRepository) :
    BaseInteractorImpl<CharactersInteractorOutput>(),
    CharactersInteractor, CharactersRepositoryOutput {

    init {
        charactersRepository.setOutput(this)
    }

    override fun getCharacters(offset: Int) {
        charactersRepository.getCharacters(offset)
    }

    override fun searchCharactersByName(nameStartWith: String) {
        charactersRepository.getCharactersStartingWith(nameStartWith)
    }

    override fun onCharactersReceived(characters: List<Character>) {
        output?.onCharactersReceived(characters)
    }
}