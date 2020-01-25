package com.itmoclimbing.feature.routes.di.modules

import com.itmoclimbing.dataCommon.repository.RoutesRepositoryStub
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.feature.routes.presentation.RoutesListViewModel
import com.itmoclimbing.feature.routes.presentation.RoutesViewModelFactory
import toothpick.config.Module
import toothpick.ktp.binding.bind

internal class RoutesModule : Module() {

    init {
        bind<RoutesRepository>().toClass<RoutesRepositoryStub>().singleton()
        bind<RoutesViewModelFactory>().singleton().releasable()
        bind<RoutesListViewModel>().singleton().releasable()
    }

}