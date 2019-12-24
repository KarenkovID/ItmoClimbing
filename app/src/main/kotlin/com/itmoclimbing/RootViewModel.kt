package com.itmoclimbing

import androidx.lifecycle.ViewModel
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation

class RootViewModel : ViewModel() {

    private val rootScreenNavigation: RootScreenNavigation by lazy {
        DI
                .getAppScope()
                .getInstance(RootScreenNavigation::class.java)
    }

    init {
        rootScreenNavigation.openMainAsRoot()
    }

}