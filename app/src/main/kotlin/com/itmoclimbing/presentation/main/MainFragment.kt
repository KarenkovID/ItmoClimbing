package com.itmoclimbing.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.R
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.main.MainScreenNavigation
import com.itmoclimbing.internal.navigation.screens.root.RootScreenNavigation
import kotlinx.android.synthetic.main.fragment_main.mainBottomNavigation
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {

        fun newInstance() = MainFragment()

    }

    private val navigator: Navigator by lazy {
        SupportAppNavigator(requireActivity(), childFragmentManager, R.id.mainContainer)
                .apply { mainScreenNavigation.register(this) }
    }

    private val mainScreenNavigation: RootScreenNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(RootScreenNavigation::class.java)
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
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

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}