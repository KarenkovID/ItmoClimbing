package com.itmoclimbing.presentation.screens.root

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.presentation.main.MainFragment
import com.itmoclimbing.presentationcommon.internal.cicerone.FragmentScreen
import com.itmoclimbing.presentationcommon.internal.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class RootScreenNavigation(
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