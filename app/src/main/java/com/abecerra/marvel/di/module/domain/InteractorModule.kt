package com.abecerra.marvel.di.module.domain

import com.abecerra.feature_characters.CharactersConfigurator
import com.abecerra.feature_characters.domain.interactor.CharactersInteractor
import com.abecerra.feature_characters.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideCharactersListInteractor(charactersRepository: CharactersRepository): CharactersInteractor {
        return CharactersConfigurator.configureInteractor(charactersRepository)
    }
}