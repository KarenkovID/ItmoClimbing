package com.itmoclimbing.feature.routes.navigation

import android.util.Log
import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.feature.routes.presentation.RoutesListFragment
import com.itmoclimbing.presentationcommon.internal.cicerone.FragmentScreen
import com.itmoclimbing.presentationcommon.internal.navigation.ScreenNavigation
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

    private val routesListScreen = FragmentScreen("ROUTES_LIST_SCREEN", RoutesListFragment.Companion::newInstance)

    fun openRoutesListAsRoot() {
        router.newRootScreen(routesListScreen)
    }

    fun openAndReplaceRoutesList() {
        router.replaceScreen(routesListScreen)
    }

}