package com.itmoclimbing.presentation.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.R
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation
import com.itmoclimbing.presentationcommon.base.BaseFragment
import com.itmoclimbing.presentationcommon.internal.navigation.NestedStackScreenNavigator
import kotlinx.android.synthetic.main.fragment_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder

class MainFragment : BaseFragment(R.layout.fragment_main) {

    companion object {

        fun newInstance() = MainFragment()

    }

    private val navigator: Navigator by lazy {
        NestedStackScreenNavigator(requireActivity(), childFragmentManager, R.id.mainContainer)
                .apply { mainNavigation.register(this) }
    }

    private val mainNavigation: MainScreenNavigation by lazy {
        DI.getAppScope().getInstance(MainScreenNavigation::class.java)
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getAppScope()
                .getInstance(NavigatorHolder::class.java, MainScreenNavigation.NAME)
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("ConvertLambdaToReference")
        mainBottomNavigation.setOnNavigationItemSelectedListener { viewModel.onNavigationItemSelected(it) }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun performOnBackPressed(): Boolean = false

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}