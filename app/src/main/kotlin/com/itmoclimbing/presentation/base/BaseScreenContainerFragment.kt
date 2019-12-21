package com.itmoclimbing.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.itmoclimbing.R
import com.itmoclimbing.internal.navigation.ScreenNavigation
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

abstract class BaseScreenContainerFragment : BaseFragment(R.layout.fragment_container), InnerScreensStack {

    private lateinit var navigator: Navigator

    protected abstract val routesNavigation: ScreenNavigation

    protected abstract val navigatorHolder: NavigatorHolder

    protected abstract fun openFirstScreen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator =
                SupportAppNavigator(
                        requireActivity(),
                        childFragmentManager,
                        R.id.screenContainer
                )
//                        .apply { routesNavigation.register(this) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.screenContainer) == null) {
            openFirstScreen()
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