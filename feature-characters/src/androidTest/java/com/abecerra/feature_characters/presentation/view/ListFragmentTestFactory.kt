package com.abecerra.feature_characters.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter

class ListFragmentTestFactory(private val listPresenter: CharactersPresenter) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == CharactersFragment::class.java.name) {
            val listFragment = CharactersFragment()
            listFragment.injectPresenter(listPresenter)
            return listFragment
        }
        return super.instantiate(classLoader, className)
    }
}