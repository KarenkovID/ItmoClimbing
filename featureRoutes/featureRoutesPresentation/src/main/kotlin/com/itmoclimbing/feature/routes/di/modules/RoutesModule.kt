package com.itmoclimbing.feature.routes.di.modules

import com.itmoclimbing.data.repository.RoutesRepositoryStub
import com.itmoclimbing.domain.repository.RoutesRepository
import com.itmoclimbing.feature.routes.presentation.RoutesListViewModel
import com.itmoclimbing.feature.routes.presentation.RoutesViewModelFactory
import toothpick.config.Module

internal class RoutesModule : Module() {

    init {
        bind(RoutesRepository::class.java).to(RoutesRepositoryStub::class.java).singleton()
        bind(RoutesViewModelFactory::class.java).singleton()
        bind(RoutesListViewModel::class.java).to(RoutesListViewModel::class.java)
    }

}