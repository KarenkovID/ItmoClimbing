package com.itmoclimbing.internal.di

import com.itmoclimbing.feature.routes.RoutesMediatorImpl
import com.itmoclimbing.feature.users.UsersMediatorImpl
import com.itmoclimbing.features.common.mediators.AppMediator
import com.itmoclimbing.features.common.mediators.RoutesMediator
import com.itmoclimbing.features.common.mediators.UsersMediator
import com.itmoclimbing.internal.feature.AppMediatorImpl
import toothpick.config.Module
import toothpick.ktp.binding.bind

class RootModule : Module() {

    init {
        bind<AppMediator>().toClass<AppMediatorImpl>().singleton()
        bind<UsersMediator>().toClass<UsersMediatorImpl>().singleton()
        bind<RoutesMediator>().toClass<RoutesMediatorImpl>().singleton()
    }

}