package com.itmoclimbing.internal.di

import com.itmoclimbing.domainCommon.navigation.AppRouter
import com.itmoclimbing.presentation.AppViewModelFactory
import com.itmoclimbing.presentation.main.MainViewModel
import com.kommander.components.domain_core.rx.RxSchedulersProvider
import com.kommander.components.android_core.rx.RxSchedulersProviderImpl
import com.itmoclimbing.presentation.screens.root.RootScreenNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.config.Module
import toothpick.ktp.binding.bind

class AppModule : Module() {

    init {
        val cicerone = Cicerone.create(AppRouter())
        bind<AppRouter>().withName(RootScreenNavigation.NAME).toInstance(cicerone.router)
        bind<NavigatorHolder>().withName(RootScreenNavigation.NAME).toInstance(cicerone.navigatorHolder)
        bind<RootScreenNavigation>().singleton()
        bind<RxSchedulersProvider>().toClass<RxSchedulersProviderImpl>().singleton()
        bind<AppViewModelFactory>().singleton().releasable()
        bind<MainViewModel>().singleton().releasable()
    }

}