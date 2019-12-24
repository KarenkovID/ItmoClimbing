package com.itmoclimbing.internal.di

import com.itmoclimbing.domain.navigation.AppRouter
import com.itmoclimbing.feature.routes.RoutesMediator
import com.itmoclimbing.internal.feature.AppMediator
import com.itmoclimbing.presentation.AppViewModelFactory
import com.itmoclimbing.presentation.main.MainViewModel
import com.kommander.components.domain_core.rx.RxSchedulersProvider
import com.kommander.components.android_core.rx.RxSchedulersProviderImpl
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation
import com.itmoclimbing.presentationcommon.features.FeatureMediator
import com.itmoclimbing.presentationcommon.features.MediatorManager
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
        bind(AppViewModelFactory::class.java).singleton()
        bind(MainViewModel::class.java).singleton()
    }

}