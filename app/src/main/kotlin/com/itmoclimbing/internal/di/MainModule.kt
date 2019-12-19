package com.itmoclimbing.internal.di

import com.itmoclimbing.internal.navigation.screens.root.RootScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class MainModule() : Module() {

    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RootScreenNavigation::class.java).to(
            RootScreenNavigation::class.java).singleton()
    }

}