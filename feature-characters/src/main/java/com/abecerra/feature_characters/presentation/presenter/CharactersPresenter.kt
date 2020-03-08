package com.abecerra.feature_characters.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.base.utils.RecyclerPaginationListener
import com.abecerra.feature_characters.presentation.view.CharactersView
import com.abecerra.feature_characters.presentation.view.adapter.CharactersAdapter
import com.abecerra.feature_characters.ui.characters.model.CharacterModel

interface CharactersPresenter : BasePresenter<CharactersView> {

    fun getCharacters(offset: Int = 0)

    fun searchCharactersByName(nameStartWith: String)

    fun onCharacterClick(character: CharacterModel)

    fun getRecyclerListener(): RecyclerPaginationListener
    fun getCharactersAdapter(): CharactersAdapter
}