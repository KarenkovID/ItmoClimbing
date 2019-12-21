package com.itmoclimbing.internal.di.app

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.navigation.screens.routes.RoutesScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class RoutesNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(RoutesScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RoutesScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RoutesScreenNavigation::class.java).to(RoutesScreenNavigation::class.java).singleton()
    }

}