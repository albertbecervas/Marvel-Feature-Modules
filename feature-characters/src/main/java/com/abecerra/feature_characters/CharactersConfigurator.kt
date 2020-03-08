package com.abecerra.feature_characters

import com.abecerra.feature_characters.data.CharactersRepositoryImpl
import com.abecerra.feature_characters.domain.interactor.CharactersInteractor
import com.abecerra.feature_characters.domain.interactor.CharactersInteractorImpl
import com.abecerra.feature_characters.domain.repository.CharactersRepository
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenterImpl
import com.abecerra.feature_characters.presentation.router.CharactersRouter
import com.abecerra.network.services.CharactersService

object CharactersConfigurator {

    fun configurePresenter(charactersRouter: CharactersRouter, charactersInteractor: CharactersInteractor): CharactersPresenter {
        return CharactersPresenterImpl(charactersRouter, charactersInteractor)
    }

    fun configureInteractor(charactersRepository: CharactersRepository): CharactersInteractor {
        return CharactersInteractorImpl(charactersRepository)
    }

    fun configureRepository(charactersService: CharactersService): CharactersRepository {
        return CharactersRepositoryImpl(charactersService)
    }
}