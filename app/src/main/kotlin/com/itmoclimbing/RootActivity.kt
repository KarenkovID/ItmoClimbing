package com.itmoclimbing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itmoclimbing.data.TestData
import com.itmoclimbing.di.DI
import com.itmoclimbing.di.Scopes
import com.itmoclimbing.domain.MyClass
import com.itmoclimbing.domain.repository.RoutesRepository
import com.itmoclimbing.navigation.RootNavigator
import kotlinx.android.synthetic.main.activity_main.mainBottomNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router

class RootActivity : AppCompatActivity() {

    private val routesRepository =
            DI
                    .getScope(Scopes.APP_SCOPE)
                    .getInstance(RoutesRepository::class.java)

    private val navigator: Navigator by lazy {
        RootNavigator(this, R.id.bottomNavigationContainer)
    }

    private val router: Router by lazy {
        Router()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyClass.test()
        TestData.testData()
        routesRepository.getAllRoutes()
        val cicerone = Cicerone.create().also {
            it.navigatorHolder.setNavigator(navigator)
        }

        mainBottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuItemRoutes -> {
                    cicerone.router.navigateTo()
                    true
                }
                R.id.menuItemUsers -> {
                    true
                }
                else -> false
            }
        }
    }

}