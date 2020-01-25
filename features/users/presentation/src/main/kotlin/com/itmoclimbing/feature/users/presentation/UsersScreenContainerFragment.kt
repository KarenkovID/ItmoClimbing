package com.itmoclimbing.feature.users.presentation

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.users.di.DI
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import com.kommander.components.android_core.presentation.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class UsersScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance(): Fragment = UsersScreenContainerFragment()
    }

    init {
        DI.getUsersInternalScope()
    }

    override val routesNavigation: UsersScreenNavigation by lazy {
        DI
                .getUsersInternalScope()
                .getInstance(UsersScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getUsersInternalScope()
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