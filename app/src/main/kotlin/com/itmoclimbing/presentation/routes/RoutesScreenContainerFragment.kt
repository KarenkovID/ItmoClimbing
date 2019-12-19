package com.itmoclimbing.presentation.routes

import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.routes.RoutesScreenNavigation
import com.itmoclimbing.presentation.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class RoutesScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance() = RoutesScreenContainerFragment()
    }

    override val routesNavigation: RoutesScreenNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(RoutesScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(NavigatorHolder::class.java, RoutesScreenNavigation.NAME)
    }

    override fun executeFirstCommand() {
        routesNavigation.openAndReplaceRoutesList()
    }

//    override fun cleanScreenStack() {
//        if (childFragmentManager.backStackEntryCount > 0) {
//            routesNavigation.openListAsRoot()
//        }
//    }

//    override fun onBackPressedInternal() = false

}