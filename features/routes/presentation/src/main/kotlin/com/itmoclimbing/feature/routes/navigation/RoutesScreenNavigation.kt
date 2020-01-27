package com.itmoclimbing.feature.routes.navigation

import android.util.Log
import com.itmoclimbing.feature.routes.presentation.creation.CreateRouteFragment
import com.itmoclimbing.feature.routes.presentation.details.RouteDetailsFragment
import com.itmoclimbing.feature.routes.presentation.list.RoutesListFragment
import com.itmoclimbing.features.common.dependencies.RoutesDependencies
import com.kommander.components.android.navigation.AppRouter
import com.kommander.components.android.navigation.FragmentScreen
import com.kommander.components.android.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class RoutesScreenNavigation(
        @Named(NAME) appRouter: AppRouter,
        private val routesDependencies: RoutesDependencies
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

    private val createRouteScreen =
            FragmentScreen(
                    "CREATE_ROUTE_SCREEN",
                    CreateRouteFragment.Companion::newInstance
            )

    private fun getRouteDetailsScreen(routeId: Int) =
            FragmentScreen("ROUTE_DETAILS_SCREEN") { RouteDetailsFragment.newInstance(routeId) }

    private fun getUsersPassedRouteScreen(routeId: Int) =
            FragmentScreen("USERS_PASSED_ROUTE_SCREEN") { routesDependencies.getUsersSolvedRouteFragment(routeId) }

    fun openRoutesListAsRoot() {
        router.newRootScreen(routesListScreen)
    }

    fun openAndReplaceRoutesList() {
        router.replaceScreen(routesListScreen)
    }

    fun openCreateRouter() {
        router.addScreen(createRouteScreen)
    }

    fun openRouteDetails(routeId: Int) {
        router.addScreen(getRouteDetailsScreen(routeId))
    }

    fun openUsersPassedRoute(routeId: Int) {
        router.addScreen(getUsersPassedRouteScreen(routeId))
    }

}