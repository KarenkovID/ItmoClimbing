package com.itmoclimbing.presentation.users

import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.users.UsersScreenNavigation
import com.itmoclimbing.presentationcommon.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class UsersScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance() = UsersScreenContainerFragment()
    }

    override val routesNavigation: UsersScreenNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(UsersScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(NavigatorHolder::class.java, UsersScreenNavigation.NAME)
    }

    override fun openFirstScreen() {
        routesNavigation.openAndReplaceUsersList()
    }

    override fun cleanScreenStack() {
        if (childFragmentManager.backStackEntryCount > 0) {
            routesNavigation.openUsersListAsRoot()
        }
    }

    override fun performOnBackPressed(): Boolean = false

}