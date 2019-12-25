package com.itmoclimbing.feature.routes.di.modules

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

internal class RoutesNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(RoutesScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RoutesScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RoutesScreenNavigation::class.java).to(RoutesScreenNavigation::class.java).singleton()
    }

}