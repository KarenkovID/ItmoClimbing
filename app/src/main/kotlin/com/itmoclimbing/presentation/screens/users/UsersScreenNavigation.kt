package com.itmoclimbing.internal.navigation.screens.users

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.presentationcommon.internal.cicerone.FragmentScreen
import com.itmoclimbing.presentationcommon.internal.navigation.ScreenNavigation
import com.itmoclimbing.presentation.users.UsersListFragment
import javax.inject.Inject
import javax.inject.Named

class UsersScreenNavigation @Inject constructor(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "USERS_NAVIGATION"
    }

    private fun getUsersListScreen(screenPos: Int) = FragmentScreen("USERS_LIST_FRAGMENT") {
        UsersListFragment.newInstance(screenPos)
    }

    fun openUsersListAsRoot() {
        router.newRootScreen(getUsersListScreen(1))
    }

    fun openAndReplaceUsersList() {
        router.replaceScreen(getUsersListScreen(1))
    }

    fun openUsersList(screenPos: Int) {
        router.addScreen(getUsersListScreen(screenPos))
    }

}