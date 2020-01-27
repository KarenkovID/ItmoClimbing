package com.itmoclimbing.feature.routes.di.modules

import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.dataCommon.repository.RoutesRepositoryImpl
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.feature.routes.presentation.list.RoutesListViewModel
import com.itmoclimbing.feature.routes.presentation.RoutesViewModelFactory
import com.itmoclimbing.feature.routes.presentation.creation.CreateRouteViewModel
import com.itmoclimbing.feature.routes.presentation.details.RouteDetailsViewModel
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class RoutesModule : Module() {

    init {
        bind<RoutesRepository>().toClass<RoutesRepositoryImpl>().singleton()
        bind<ViewModelProvider.Factory>().toClass<RoutesViewModelFactory>().singleton()
        bind<RoutesListViewModel>()
        bind<CreateRouteViewModel>()
        bind<RouteDetailsViewModel>()
    }

}