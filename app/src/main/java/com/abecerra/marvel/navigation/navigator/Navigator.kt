package com.abecerra.marvel.navigation.navigator

import androidx.fragment.app.Fragment

interface Navigator {

    fun replaceFragment(fragment: Fragment, layout: Int)
}