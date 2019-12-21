package com.itmoclimbing.internal.navigation.screens.root

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.cicerone.FragmentScreen
import com.itmoclimbing.internal.navigation.ScreenNavigation
import com.itmoclimbing.presentation.main.MainFragment
import javax.inject.Inject
import javax.inject.Named

class RootScreenNavigation @Inject constructor(
        @Named(NAME) router: AppRouter
) : ScreenNavigation(router) {

    companion object {
        const val NAME = "ROOT_NAVIGATION"
    }

    private val mainScreen = FragmentScreen("MAIN_SCREEN", MainFragment.Companion::newInstance)

    fun openMainAsRoot() {
        router.newRootScreen(mainScreen)
    }

    fun backToMain() {
        router.backTo(mainScreen)
    }

}