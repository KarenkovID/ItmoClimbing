package com.itmoclimbing.internal.di

import com.itmoclimbing.feature.routes.RoutesMediator
import com.itmoclimbing.internal.feature.AppMediator
import com.itmoclimbing.presentationcommon.features.MediatorManager
import toothpick.config.Module

class RootModule : Module() {

    init {
        val appMediator = AppMediator()
        val routesMediator = RoutesMediator()
        val mediatorManager = MediatorManager(routesMediator = routesMediator, appMediator = appMediator)
        appMediator.mediatorManager = mediatorManager
        routesMediator.mediatorManager = mediatorManager
        bind(MediatorManager::class.java).toInstance(mediatorManager)
    }

}