package com.itmoclimbing

import androidx.lifecycle.ViewModel
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.root.RootScreenNavigation

class RootViewModel : ViewModel() {

    private val rootScreenNavigation: RootScreenNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(RootScreenNavigation::class.java)
    }

    init {
        rootScreenNavigation.openMainAsRoot()
    }

}