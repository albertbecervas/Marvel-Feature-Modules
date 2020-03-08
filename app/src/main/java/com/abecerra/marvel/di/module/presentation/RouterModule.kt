package com.abecerra.marvel.di.module.presentation

import com.abecerra.feature_characters.presentation.router.CharactersRouter
import com.abecerra.feature_characters.presentation.view.CharactersFragment
import com.abecerra.marvel.navigation.navigator.Navigator
import com.abecerra.marvel.navigation.routers.CharactersRouterImpl
import com.abecerra.marvel.navigation.routers.MainRouterImpl
import com.abecerra.marvel.scenes.main.router.MainRouter
import dagger.Module
import dagger.Provides

@Module
open class RouterModule {

    @Provides
    open fun provideMainRouter(charactersFragment: CharactersFragment, navigator: Navigator): MainRouter {
        return MainRouterImpl(charactersFragment, navigator)
    }

    @Provides
    open fun provideCharactersListRouter(): CharactersRouter {
        return CharactersRouterImpl()
    }
}