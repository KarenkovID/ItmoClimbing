package com.itmoclimbing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itmoclimbing.data.TestData
import com.itmoclimbing.di.DI
import com.itmoclimbing.di.Scopes
import com.itmoclimbing.domain.MyClass
import com.itmoclimbing.domain.repository.RoutesRepository
import com.itmoclimbing.navigation.RootNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class RootActivity : AppCompatActivity() {

    private val navigator: Navigator by lazy {
        SupportAppNavigator(this, R.id.rootContainer)
                .apply { rootScreenNavigation.register(this) }
    }

    private val rootScreenNavigation: RootNavigation by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(RootNavigation::class.java)
    }

    private val navigatorHolder: NavigatorHolder by lazy {
        DI
                .getScope(Scopes.APP_SCOPE)
                .getInstance(NavigatorHolder::class.java, RootNavigation.NAME)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}