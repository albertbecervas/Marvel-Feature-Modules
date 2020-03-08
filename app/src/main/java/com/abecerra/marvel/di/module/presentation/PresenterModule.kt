package com.abecerra.marvel.di.module.presentation

import com.abecerra.feature_characters.CharactersConfigurator
import com.abecerra.feature_characters.domain.interactor.CharactersInteractor
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import com.abecerra.feature_characters.presentation.router.CharactersRouter
import com.abecerra.marvel.scenes.main.presenter.MainPresenter
import com.abecerra.marvel.scenes.main.presenter.MainPresenterImpl
import com.abecerra.marvel.scenes.main.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
open class PresenterModule {

    @Provides
    fun provideMainPresenter(mainRouter: MainRouter): MainPresenter {
        return MainPresenterImpl(mainRouter)
    }

    @Provides
    fun provideCharactersPresenter(
        charactersRouter: CharactersRouter,
        charactersInteractor: CharactersInteractor
    ): CharactersPresenter {
        return CharactersConfigurator.configurePresenter(charactersRouter, charactersInteractor)
    }
}