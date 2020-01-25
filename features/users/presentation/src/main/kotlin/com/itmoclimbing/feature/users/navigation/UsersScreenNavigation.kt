package com.itmoclimbing.feature.users.navigation

import com.kommander.components.android_core.navigation.AppRouter
import com.itmoclimbing.feature.users.presentation.users.UsersListFragment
import com.kommander.components.android_core.navigation.FragmentScreen
import com.kommander.components.android_core.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class UsersScreenNavigation(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "USERS_NAVIGATION"
    }

    private fun getUsersListScreen(screenPos: Int) =
            FragmentScreen("USERS_LIST_FRAGMENT") {
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