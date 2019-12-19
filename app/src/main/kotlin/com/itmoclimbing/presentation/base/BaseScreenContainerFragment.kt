package com.itmoclimbing.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.itmoclimbing.R
import com.itmoclimbing.internal.navigation.ScreenNavigation
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

abstract class BaseScreenContainerFragment : Fragment(R.layout.fragment_container) {

    private lateinit var navigator: Navigator

    protected abstract val routesNavigation: ScreenNavigation

    protected abstract val navigatorHolder: NavigatorHolder

//    protected abstract fun provideScreenNavigation(): ScreenNavigation

    protected abstract fun executeFirstCommand()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator =
                SupportAppNavigator(
                        requireActivity(),
                        childFragmentManager,
                        R.id.screenContainer
                )
                        .apply { routesNavigation.register(this) }
    }

//    override fun cleanScreenStack() {
//        if (childFragmentManager.backStackEntryCount > 0) {
//            routesNavigation.openListAsRoot()
//        }
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.screenContainer) == null) {
            executeFirstCommand()
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

//    override fun onBackPressedInternal() = false

}