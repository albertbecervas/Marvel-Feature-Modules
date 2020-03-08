package com.abecerra.marvel.scenes.main.router

import androidx.annotation.IdRes

interface MainRouter {
    fun loadDefaultFragment(@IdRes layout: Int)
}