package com.itmoclimbing.internal.di

import com.itmoclimbing.feature.routes.RoutesMediator
import com.itmoclimbing.feature.users.UsersMediator
import com.itmoclimbing.features.common.MediatorManager
import com.itmoclimbing.internal.feature.AppMediator
import toothpick.config.Module

class RootModule : Module() {

    init {
        val appMediator = AppMediator()
        val routesMediator = RoutesMediator()
        val userMediator = UsersMediator()
        val mediatorManager = MediatorManager(
                routesMediator = routesMediator,
                appMediator = appMediator,
                usersMediator = userMediator
        )
        appMediator.mediatorManager = mediatorManager
        routesMediator.mediatorManager = mediatorManager
        userMediator.mediatorManager = mediatorManager
        bind(MediatorManager::class.java).toInstance(mediatorManager)
    }

}