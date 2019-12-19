package com.itmoclimbing.internal.navigation.screens.users

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.cicerone.FragmentScreen
import com.itmoclimbing.internal.navigation.ScreenNavigation
import com.itmoclimbing.presentation.users.UsersListFragment
import javax.inject.Inject
import javax.inject.Named

class UsersScreenNavigation @Inject constructor(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "USERS_NAVIGATION"
    }

    private val usersListScreen = FragmentScreen("USERS_LIST_FRAGMENT", UsersListFragment.Companion::newInstance)

    fun openUsersListAsRoot() {
        router.newRootScreen(usersListScreen)
    }

    fun openAndReplaceUsersList() {
        router.replaceScreen(usersListScreen)
    }

}