package com.itmoclimbing.internal.di.modules

import com.kommander.components.android.navigation.AppRouter
import com.itmoclimbing.presentation.AppViewModelFactory
import com.itmoclimbing.presentation.main.MainViewModel
import com.kommander.components.domain.rx.RxSchedulersProvider
import com.kommander.components.android.rx.RxSchedulersProviderImpl
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
        bind<MainViewModel>()
    }

}