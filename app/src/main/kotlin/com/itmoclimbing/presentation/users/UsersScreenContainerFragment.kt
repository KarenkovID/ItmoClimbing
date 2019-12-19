package com.itmoclimbing.presentation.users

import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.routes.RoutesScreenNavigation
import com.itmoclimbing.internal.navigation.screens.users.UsersScreenNavigation
import com.itmoclimbing.presentation.base.BaseScreenContainerFragment
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

    override fun executeFirstCommand() {
        routesNavigation.openAndReplaceUsersList()
    }

//    override fun cleanScreenStack() {
//        if (childFragmentManager.backStackEntryCount > 0) {
//            routesNavigation.openListAsRoot()
//        }
//    }

//    override fun onBackPressedInternal() = false

}