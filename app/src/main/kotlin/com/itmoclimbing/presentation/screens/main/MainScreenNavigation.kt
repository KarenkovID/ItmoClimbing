package com.itmoclimbing.presentation.screens.main

import com.itmoclimbing.features.common.mediators.RoutesMediator
import com.itmoclimbing.features.common.mediators.UsersMediator
import com.kommander.components.android_core.navigation.AppRouter
import com.kommander.components.android_core.navigation.FragmentScreen
import com.kommander.components.android_core.navigation.NestedStackScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class MainScreenNavigation(
        @Named(NAME) router: AppRouter,
        usersMediator: UsersMediator,
        routesMediator: RoutesMediator
) : NestedStackScreenNavigation(router) {

    companion object {
        const val NAME = "MAIN_NAVIGATION"
    }

    private val routesContainerScreen = FragmentScreen(
            "ROUTES_CONTAINER_SCREEN",
            routesMediator.apiStub::getRoutesFragment
    )
    private val usersContainerScreen = FragmentScreen(
            "USERS_CONTAINER_SCREEN",
            usersMediator.apiStub::getUsersFragment
    )

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