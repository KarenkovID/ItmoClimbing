package com.itmoclimbing.internal.di

import com.kommander.components.android.navigation.AppRouter
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module
import toothpick.ktp.binding.bind

class MainNavigationModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind<AppRouter>().withName(MainScreenNavigation.NAME).toInstance(cicerone.router)
        bind<NavigatorHolder>().withName(MainScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind<MainScreenNavigation>().singleton()
    }

}