package com.itmoclimbing.internal.di.app

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.internal.navigation.screens.users.UsersScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class UsersNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(UsersScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(UsersScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(UsersScreenNavigation::class.java).to(UsersScreenNavigation::class.java).singleton()
    }

}