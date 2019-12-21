package com.itmoclimbing.internal.navigation.screens.routes

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.cicerone.FragmentScreen
import com.itmoclimbing.internal.navigation.ScreenNavigation
import com.itmoclimbing.presentation.routes.RoutesListFragment
import javax.inject.Inject
import javax.inject.Named

class RoutesScreenNavigation @Inject constructor(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "ROUTES_NAVIGATION"
    }

    private val routesListScreen = FragmentScreen("ROUTES_LIST_SCREEN", RoutesListFragment.Companion::newInstance)

    fun openRoutesListAsRoot() {
        router.newRootScreen(routesListScreen)
    }

    fun openAndReplaceRoutesList() {
        router.replaceScreen(routesListScreen)
    }

}