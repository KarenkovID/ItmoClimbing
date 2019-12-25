package com.itmoclimbing.presentation.screens.main

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.feature.users.api.FeatureUsersApi
import com.itmoclimbing.features.common.MediatorManager
import com.itmoclimbing.presentationcommon.internal.cicerone.FragmentScreen
import com.itmoclimbing.presentationcommon.internal.navigation.NestedStackScreenNavigation
import javax.inject.Inject
import javax.inject.Named

class MainScreenNavigation @Inject constructor(
        @Named(NAME) router: AppRouter,
        mediatorManager: MediatorManager
) : NestedStackScreenNavigation(router) {

    companion object {
        const val NAME = "MAIN_NAVIGATION"
    }

    private val routesContainerScreen = FragmentScreen("ROUTES_CONTAINER_SCREEN", mediatorManager.routesMediator.apiStub::getRoutesFragment)
    private val usersContainerScreen = FragmentScreen("USERS_CONTAINER_SCREEN", FeatureUsersApi::getUsersMainFragment)

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