package com.abecerra.marvel.di.module.presentation

import android.content.Context
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import com.abecerra.feature_characters.presentation.view.CharactersFragment
import dagger.Module
import dagger.Provides

@Module
class ViewModule(private val context: Context?) {

    @Provides
    fun provideContext(): Context? = context

    @Provides
    fun provideListFragment(presenter: CharactersPresenter): CharactersFragment {
        val fragment = CharactersFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}