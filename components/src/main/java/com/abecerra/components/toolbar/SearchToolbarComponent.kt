package com.abecerra.components.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.abecerra.base.utils.StringUtils
import com.abecerra.components.R
import kotlinx.android.synthetic.main.view_toolbar_search.view.*

class SearchToolbarComponent : LinearLayout,
    ToolbarListener {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    )

    init {
        View.inflate(this.context,
            R.layout.view_toolbar_search, this)
        getActivity()?.setSupportActionBar(toolbar_layout)
        getActivity()?.supportActionBar?.title = StringUtils.EMPTY_STRING
        iv_search?.setOnClickListener {
            showSearchToolbar()
        }
    }

    override fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        this.search_layout?.bindSearchOutput(searchComponentOutput)
    }

    private fun getActivity(): AppCompatActivity? {
        return context as? AppCompatActivity
    }

    private fun showSearchToolbar() {
        this.search_layout.visibility = View.VISIBLE
    }
}