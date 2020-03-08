package com.abecerra.marvel.di.component

import com.abecerra.marvel.di.module.presentation.NavigationModule
import com.abecerra.marvel.di.module.data.NetworkModule
import com.abecerra.marvel.di.module.data.RepositoryModule
import com.abecerra.marvel.di.module.domain.InteractorModule
import com.abecerra.marvel.di.module.presentation.PresenterModule
import com.abecerra.marvel.di.module.presentation.RouterModule
import com.abecerra.marvel.di.module.presentation.ViewModule
import com.abecerra.marvel.scenes.main.view.MainActivity
import dagger.Component

@Component(
    modules = [ViewModule::class, PresenterModule::class, RouterModule::class,
        NavigationModule::class, InteractorModule::class, RepositoryModule::class,
        NetworkModule::class]
)
interface ViewComponent {

    fun inject(mainActivity: MainActivity)
}