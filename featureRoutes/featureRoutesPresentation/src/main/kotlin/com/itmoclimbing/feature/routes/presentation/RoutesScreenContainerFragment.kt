package com.itmoclimbing.feature.routes.presentation

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.itmoclimbing.presentationcommon.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class RoutesScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance(): Fragment =
                RoutesScreenContainerFragment()
    }

    init {
        DI.openRoutesScope()
    }

    override val routesNavigation: RoutesScreenNavigation by lazy {
        DI
                .getScopeRoutesScope()
                .getInstance(RoutesScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScopeRoutesScope()
                .getInstance(NavigatorHolder::class.java, RoutesScreenNavigation.NAME)
    }

    override fun openFirstScreen() {
        routesNavigation.openAndReplaceRoutesList()
    }

    override fun cleanScreenStack() {
        if (childFragmentManager.backStackEntryCount > 0) {
            routesNavigation.openRoutesListAsRoot()
        }
    }

    override fun performOnBackPressed(): Boolean = false

}