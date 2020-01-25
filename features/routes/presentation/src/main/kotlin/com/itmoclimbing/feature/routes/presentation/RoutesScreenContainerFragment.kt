package com.itmoclimbing.feature.routes.presentation

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.kommander.components.android.presentation.base.BaseScreenContainerFragment
import ru.terrakok.cicerone.NavigatorHolder

class RoutesScreenContainerFragment : BaseScreenContainerFragment() {

    companion object {
        fun newInstance(): Fragment =
                RoutesScreenContainerFragment()
    }

    init {
        DI.getRoutesInternalScope()
    }

    override val navigation: RoutesScreenNavigation by lazy {
        DI
                .getRoutesInternalScope()
                .getInstance(RoutesScreenNavigation::class.java)
    }

    override val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getRoutesInternalScope()
                .getInstance(NavigatorHolder::class.java, RoutesScreenNavigation.NAME)
    }

    override fun openFirstScreen() {
        navigation.openAndReplaceRoutesList()
    }

    override fun cleanScreenStack() {
        if (childFragmentManager.backStackEntryCount > 0) {
            navigation.openRoutesListAsRoot()
        }
    }

    override fun performOnBackPressed(): Boolean = false

}