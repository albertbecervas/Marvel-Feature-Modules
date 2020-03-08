package com.abecerra.feature_characters.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.base.utils.RecyclerPaginationListener
import com.abecerra.feature_characters.domain.interactor.CharactersInteractor
import com.abecerra.feature_characters.domain.interactor.CharactersInteractorOutput
import com.abecerra.feature_characters.domain.model.Character
import com.abecerra.feature_characters.presentation.model.CharacterModelMapper
import com.abecerra.feature_characters.presentation.router.CharactersRouter
import com.abecerra.feature_characters.presentation.view.CharactersView
import com.abecerra.feature_characters.presentation.view.adapter.CharactersAdapter
import com.abecerra.feature_characters.ui.characters.model.CharacterModel

class CharactersPresenterImpl(
    val router: CharactersRouter,
    private val interactor: CharactersInteractor
) : BasePresenterImpl<CharactersView>(), CharactersPresenter, CharactersInteractorOutput {

    private var pagination: RecyclerPaginationListener
    private var adapter: CharactersAdapter

    init {
        interactor.setInteractorOutput(this)
        pagination = RecyclerPaginationListener {
            getCharacters(it)
        }
        adapter = CharactersAdapter {
            router.onCharacterClick(it)
        }
    }

    override fun getRecyclerListener(): RecyclerPaginationListener = pagination
    override fun getCharactersAdapter(): CharactersAdapter = adapter

    override fun getCharacters(offset: Int) {
        getView()?.showLoading()
        if (offset == 0) adapter.clear()
        interactor.getCharacters(offset)
    }

    override fun searchCharactersByName(nameStartWith: String) {

    }

    override fun onCharacterClick(character: CharacterModel) {
        this.router.onCharacterClick(character)
    }

    override fun onCharactersReceived(characters: List<Character>) {
        handleCharactersResponse(characters)
    }

    private fun handleCharactersResponse(charactersList: List<Character>) {
        this.pagination.setEndLoading()
        this.adapter.addItems(CharacterModelMapper.map(charactersList))
        this.getView()?.hideLoading()
    }

    private fun handleSearchResponse(characters: List<Character>) {
        this.pagination.setEndLoading()
        this.adapter.addItems(CharacterModelMapper.map(characters))
    }
}