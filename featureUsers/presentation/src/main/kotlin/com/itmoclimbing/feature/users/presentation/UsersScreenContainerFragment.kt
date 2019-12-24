package com.itmoclimbing.feature.users.presentation

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.users.di.DI
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import com.itmoclimbing.presentationcommon.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class UsersScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance(): Fragment = UsersScreenContainerFragment()
    }

    init {
        DI.getUsersScope()
    }

    override val routesNavigation: UsersScreenNavigation by lazy {
        DI
                .getUsersScope()
                .getInstance(UsersScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getUsersScope()
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