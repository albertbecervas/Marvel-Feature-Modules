package com.abecerra.marvel.di.module.data

import com.abecerra.feature_characters.CharactersConfigurator
import com.abecerra.feature_characters.domain.repository.CharactersRepository
import com.abecerra.network.services.CharactersService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideCharactersRepository(charactersService: CharactersService): CharactersRepository {
        return CharactersConfigurator.configureRepository(charactersService)
    }
}