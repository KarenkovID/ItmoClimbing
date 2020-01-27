package com.itmoclimbing.feature.routes.di.modules

import com.kommander.components.android.navigation.AppRouter
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.itmoclimbing.feature.routes.presentation.RouteCreatedCallback
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class RoutesNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind<AppRouter>().withName(RoutesScreenNavigation.NAME).toInstance(cicerone.router)
        bind<NavigatorHolder>().withName(RoutesScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind<RoutesScreenNavigation>().singleton()
        bind<RouteCreatedCallback>().singleton()
    }

}