package com.itmoclimbing.presentationcommon.internal.navigation

import com.itmoclimbing.domain.navigation.AppRouter
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppScreen

abstract class NestedStackScreenNavigation(
        private val screenRouter: AppRouter
) {

    protected val specs = mutableListOf<SupportAppScreen>()

    fun register(navigator: NestedStackScreenNavigator) {
        specs.forEach(navigator::registerScreens)
    }

    fun back() {
        screenRouter.exit()
    }

    protected fun replace(screen: Screen) {
//        if (reset) {
//            screenRouter.replaceAndResetScreen(spec.arg())
//        } else {
            screenRouter.replaceScreen(screen)
//        }
    }

}