package com.itmoclimbing

import android.os.Bundle
import androidx.annotation.Keep
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.presentation.AppViewModelFactory
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation
import com.kommander.components.android_core.presentation.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.ktp.extension.getInstance

class RootActivity : BaseActivity(R.layout.activity_root) {

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, R.id.rootContainer)
//                .apply { rootScreenNavigation.register(this) }
    }

    private val rootScreenNavigation: RootScreenNavigation by lazy {
        DI
                .getAppScope()
                .getInstance(RootScreenNavigation::class.java)
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getAppScope()
                .getInstance(NavigatorHolder::class.java, RootScreenNavigation.NAME)
    }

    @Keep
    private lateinit var model: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this, DI.getAppScope().getInstance<AppViewModelFactory>()).get(RootViewModel::class.java)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun performOnBackPressed(): Boolean {
        finish()
        return true
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}