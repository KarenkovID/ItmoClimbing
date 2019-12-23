package com.itmoclimbing.internal.di

import com.itmoclimbing.domain.navigation.AppRouter
import com.kommander.components.domain_core.rx.RxSchedulersProvider
import com.kommander.components.android_core.rx.RxSchedulersProviderImpl
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module

class AppModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind(AppRouter::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).withName(RootScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind(RootScreenNavigation::class.java).to(RootScreenNavigation::class.java).singleton()
        bind(RxSchedulersProvider::class.java).to(RxSchedulersProviderImpl::class.java).singleton()
    }

}