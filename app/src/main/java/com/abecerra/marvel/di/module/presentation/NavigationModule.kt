package com.abecerra.marvel.di.module.presentation

import android.content.Context
import com.abecerra.marvel.navigation.navigator.Navigator
import com.abecerra.marvel.navigation.navigator.NavigatorImpl
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

@Module
class NavigationModule {

    @Provides
    fun provideCoordinator(context: Context?): Navigator {
        return NavigatorImpl(WeakReference(context))
    }
}