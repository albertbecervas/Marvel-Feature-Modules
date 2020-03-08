package com.abecerra.components.toolbar

import com.abecerra.components.toolbar.SearchComponentOutput

interface ToolbarListener {
    fun bindSearchOutput(searchComponentOutput: SearchComponentOutput)
}