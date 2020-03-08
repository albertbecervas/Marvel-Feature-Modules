package com.abecerra.marvel.scenes.main.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.marvel.scenes.main.router.MainRouter
import com.abecerra.marvel.scenes.main.view.MainView

class MainPresenterImpl(private val router: MainRouter) : BasePresenterImpl<MainView>(),
    MainPresenter {

    override fun loadDefaultFragment(layout: Int) {
        router.loadDefaultFragment(layout)
    }
}