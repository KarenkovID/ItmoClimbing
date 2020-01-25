package com.itmoclimbing.feature.routes.navigation

import android.util.Log
import com.kommander.components.android.navigation.AppRouter
import com.itmoclimbing.feature.routes.presentation.RoutesListFragment
import com.kommander.components.android.navigation.FragmentScreen
import com.kommander.components.android.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class RoutesScreenNavigation(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "ROUTES_NAVIGATION"
    }

    init {
        Log.e("TAT", "RoutesScreenNavigation created")
    }

    private val routesListScreen =
            FragmentScreen(
                    "ROUTES_LIST_SCREEN",
                    RoutesListFragment.Companion::newInstance
            )

    fun openRoutesListAsRoot() {
        router.newRootScreen(routesListScreen)
    }

    fun openAndReplaceRoutesList() {
        router.replaceScreen(routesListScreen)
    }

}