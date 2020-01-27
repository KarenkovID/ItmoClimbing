package com.itmoclimbing.feature.users.navigation

import com.itmoclimbing.feature.users.presentation.creation.CreateUserFragment
import com.itmoclimbing.feature.users.presentation.list.UsersListFragment
import com.kommander.components.android.navigation.AppRouter
import com.kommander.components.android.navigation.FragmentScreen
import com.kommander.components.android.navigation.ScreenNavigation
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class UsersScreenNavigation(
        @Named(NAME) appRouter: AppRouter
) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "USERS_NAVIGATION"
    }

    private val usersListScreen = FragmentScreen("USERS_LIST_FRAGMENT", UsersListFragment.Companion::newInstance)
    private val createUserListScreen = FragmentScreen("CREATE_USER_FRAGMENT", CreateUserFragment.Companion::newInstance)

    fun openUsersListAsRoot() {
        router.newRootScreen(usersListScreen)
    }

    fun openAndReplaceUsersList() {
        router.replaceScreen(usersListScreen)
    }

    fun openCreateUser() {
        router.addScreen(createUserListScreen)
    }

}