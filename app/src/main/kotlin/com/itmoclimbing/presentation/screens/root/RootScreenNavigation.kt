package com.itmoclimbing.presentation.screens.root

import com.kommander.components.android.navigation.AppRouter
import com.itmoclimbing.presentation.main.MainFragment
import com.kommander.components.android.navigation.FragmentScreen
import com.kommander.components.android.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class RootScreenNavigation(
        @Named(NAME) router: AppRouter
) : ScreenNavigation(router) {

    companion object {
        const val NAME = "ROOT_NAVIGATION"
    }

    private val mainScreen =
            FragmentScreen("MAIN_SCREEN", MainFragment.Companion::newInstance)

    fun openMainAsRoot() {
        router.newRootScreen(mainScreen)
    }

    fun backToMain() {
        router.backTo(mainScreen)
    }

}