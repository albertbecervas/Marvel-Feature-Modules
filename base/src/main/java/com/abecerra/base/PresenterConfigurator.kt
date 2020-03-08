package com.abecerra.base

interface PresenterConfigurator<PRESENTER> {

    fun getPresenter(): PRESENTER?
}