package com.abecerra.marvel.navigation.routers

import com.abecerra.feature_characters.presentation.view.CharactersFragment
import com.abecerra.marvel.navigation.navigator.Navigator
import com.abecerra.marvel.scenes.main.router.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val fragment: CharactersFragment,
    private val navigator: Navigator
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
        navigator.replaceFragment(fragment, layout)
    }
}