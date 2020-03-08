package com.abecerra.marvel.scenes.main.view

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.components.toolbar.SearchComponentOutput
import com.abecerra.components.toolbar.ToolbarActivityListener
import com.abecerra.marvel.R
import com.abecerra.marvel.di.component.DaggerViewComponent
import com.abecerra.marvel.di.module.presentation.ViewModule
import com.abecerra.marvel.scenes.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView,
    ToolbarActivityListener {

    @Inject
    lateinit var presenter: MainPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this)).build().inject(this)

        presenter.setView(this)
        presenter.loadDefaultFragment()
    }

    override fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        toolbar?.bindSearchOutput(searchComponentOutput)
    }
}
