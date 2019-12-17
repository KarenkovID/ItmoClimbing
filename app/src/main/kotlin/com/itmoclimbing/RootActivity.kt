package com.itmoclimbing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itmoclimbing.data.TestData
import com.itmoclimbing.di.DI
import com.itmoclimbing.di.Scopes
import com.itmoclimbing.domain.MyClass
import com.itmoclimbing.domain.repository.RoutesRepository
import com.itmoclimbing.navigation.RootNavigator
import ru.terrakok.cicerone.Navigator

class RootActivity : AppCompatActivity() {

    val routesRepository =
        DI
            .getScope(Scopes.APP_SCOPE)
            .getInstance(RoutesRepository::class.java)

//    private val navigator: Navigator by lazy {
//        RootNavigator(this, R.id.activity_main_container)
//            .apply { rootScreenNavigation.register(this) }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyClass.test()
        TestData.testData()
        routesRepository.getAllRoutes()
    }

}