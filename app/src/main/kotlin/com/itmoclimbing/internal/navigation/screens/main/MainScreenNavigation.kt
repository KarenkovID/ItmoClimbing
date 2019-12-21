package com.itmoclimbing.internal.navigation.screens.main

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.cicerone.FragmentScreen
import com.itmoclimbing.internal.navigation.NestedStackScreenNavigation
import com.itmoclimbing.presentation.routes.RoutesScreenContainerFragment
import com.itmoclimbing.presentation.users.UsersListFragment
import com.itmoclimbing.presentation.users.UsersScreenContainerFragment
import javax.inject.Inject
import javax.inject.Named

class MainScreenNavigation @Inject constructor(
        @Named(NAME) router: AppRouter
) : NestedStackScreenNavigation(router) {

    companion object {
        const val NAME = "MAIN_NAVIGATION"
    }

    private val routesContainerScreen = FragmentScreen("ROUTES_CONTAINER_SCREEN", RoutesScreenContainerFragment.Companion::newInstance)
    private val usersContainerScreen = FragmentScreen("USERS_CONTAINER_SCREEN", UsersScreenContainerFragment.Companion::newInstance)

    init {
        specs.add(routesContainerScreen)
        specs.add(usersContainerScreen)
    }

    fun selectRoutes() {
        replace(routesContainerScreen)
    }

    fun selectUsers() {
        replace(usersContainerScreen)
    }

}