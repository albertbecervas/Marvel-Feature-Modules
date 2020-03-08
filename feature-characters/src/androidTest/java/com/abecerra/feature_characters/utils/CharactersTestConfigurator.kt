package com.abecerra.feature_characters.utils

import com.abecerra.feature_characters.CharactersConfigurator.configureInteractor
import com.abecerra.feature_characters.CharactersConfigurator.configurePresenter
import com.abecerra.feature_characters.CharactersConfigurator.configureRepository
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import com.abecerra.feature_characters.presentation.router.CharactersRouter
import com.abecerra.feature_characters.ui.characters.model.CharacterModel
import com.abecerra.network.services.CharactersService

object CharactersTestConfigurator {

    fun configurePresenter(service: CharactersService): CharactersPresenter {
        return configurePresenter(
            object : CharactersRouter {
                override fun onCharacterClick(characterModel: CharacterModel) {

                }
            }, configureInteractor(configureRepository(service))
        )
    }
}