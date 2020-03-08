package com.abecerra.components.loading

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar

class LoadingComponent : ProgressBar {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context, attrs, defStyle
    )

    fun showLoading() {
        this.visibility = View.VISIBLE
    }

    fun hideLoading() {
        this.visibility = View.GONE
    }
}