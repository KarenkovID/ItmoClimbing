package com.itmoclimbing.presentation.screens.main

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.features.common.MediatorManager
import com.itmoclimbing.presentationcommon.internal.cicerone.FragmentScreen
import com.itmoclimbing.presentationcommon.internal.navigation.NestedStackScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class MainScreenNavigation(
        @Named(NAME) router: AppRouter,
        mediatorManager: MediatorManager
) : NestedStackScreenNavigation(router) {

    companion object {
        const val NAME = "MAIN_NAVIGATION"
    }

    private val routesContainerScreen = FragmentScreen(
            "ROUTES_CONTAINER_SCREEN",
            mediatorManager.routesMediator.apiStub::getRoutesFragment
    )
    private val usersContainerScreen = FragmentScreen(
            "USERS_CONTAINER_SCREEN",
            mediatorManager.usersMediator.apiStub::getUsersFragment
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