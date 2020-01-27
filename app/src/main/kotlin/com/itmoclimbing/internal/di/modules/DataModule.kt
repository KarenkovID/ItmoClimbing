package com.itmoclimbing.internal.di.modules

import com.itmoclimbing.dataCommon.repository.RoutesRepositoryImpl
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

class DataModule : Module() {

    init {
        bind<RoutesRepository>().toClass<RoutesRepositoryImpl>().singleton()
    }

}