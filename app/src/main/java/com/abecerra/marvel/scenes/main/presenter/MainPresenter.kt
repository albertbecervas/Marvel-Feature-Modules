package com.abecerra.marvel.scenes.main.presenter

import androidx.annotation.IdRes
import com.abecerra.base.presentation.BasePresenter
import com.abecerra.marvel.R
import com.abecerra.marvel.scenes.main.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadDefaultFragment(@IdRes layout: Int = R.id.fl)
}