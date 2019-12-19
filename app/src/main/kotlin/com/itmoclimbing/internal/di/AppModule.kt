package com.itmoclimbing.internal.di

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.navigation.screens.root.RootScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class AppModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RootScreenNavigation::class.java).to(RootScreenNavigation::class.java).singleton()
    }

}