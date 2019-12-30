package com.itmoclimbing.internal.di

import com.itmoclimbing.feature.routes.RoutesMediatorImpl
import com.itmoclimbing.feature.users.UsersMediatorImpl
import com.itmoclimbing.features.common.FeatureMediator
import com.itmoclimbing.features.common.api.FeatureRoutesApi
import com.itmoclimbing.features.common.api.FeatureUsersApi
import com.itmoclimbing.features.common.mediators.AppMediator
import com.itmoclimbing.features.common.mediators.RoutesMediator
import com.itmoclimbing.features.common.mediators.UsersMediator
import com.itmoclimbing.internal.feature.AppMediatorImpl
import toothpick.config.Module
import toothpick.ktp.binding.bind

class RootModule : Module() {

    init {
//        val appMediator = AppMediator()
//        val routesMediator = RoutesMediator()
//        val userMediator = UsersMediator()
//        val mediatorManager = MediatorManager(
//                routesMediator = routesMediator,
//                appMediator = appMediator,
//                usersMediator = userMediator
//        )
//        appMediator.mediatorManager = mediatorManager
//        routesMediator.mediatorManager = mediatorManager
//        userMediator.mediatorManager = mediatorManager
        bind<AppMediator>().toClass<AppMediatorImpl>().singleton()
        bind<UsersMediator>().toClass<UsersMediatorImpl>().singleton()
        bind<RoutesMediator>().toClass<RoutesMediatorImpl>().singleton()
    }

}