package com.abecerra.feature_characters.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.abecerra.base.presentation.BasePresenterFragment
import com.abecerra.components.toolbar.SearchComponentOutput
import com.abecerra.components.toolbar.ToolbarActivityListener
import com.abecerra.feature_characters.R
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : BasePresenterFragment<CharactersPresenter>(),
    CharactersView, SearchComponentOutput {

    override fun getLayout(): Int = R.layout.fragment_characters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter?.setView(this)
        presenter?.getCharacters()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? ToolbarActivityListener)?.bindSearchOutput(this)
    }

    private fun initViews() {
        presenter?.let {
            rv_characters.layoutManager = GridLayoutManager(context, SPAN_COUNT)
            rv_characters.adapter = it.getCharactersAdapter()
            rv_characters.addOnScrollListener(it.getRecyclerListener())
        }

        refresh_layout?.setOnRefreshListener {
            presenter?.getCharacters()
            refresh_layout?.isRefreshing = false
        }
    }

    override fun onSearch(text: String) {
        presenter?.searchCharactersByName(text)
    }

    override fun emptySearch() {
        presenter?.getCharacters()
    }

    override fun showLoading() {
        loading.showLoading()
    }

    override fun hideLoading() {
        loading.hideLoading()
    }

    companion object {
        const val SPAN_COUNT = 3
    }
}