package com.itmoclimbing

import androidx.lifecycle.ViewModel
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation
import toothpick.InjectConstructor

@InjectConstructor
class RootViewModel(rootScreenNavigation: RootScreenNavigation) : ViewModel() {

    init {
        rootScreenNavigation.openMainAsRoot()
    }

}