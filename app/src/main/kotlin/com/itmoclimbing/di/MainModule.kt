package com.itmoclimbing.di

import com.itmoclimbing.navigation.RootNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class MainModule() : Module() {

    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java).withName(RootNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RootNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RootNavigation::class.java).to(RootNavigation::class.java).singleton()
    }

}