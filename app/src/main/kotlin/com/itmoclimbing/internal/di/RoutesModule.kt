package com.itmoclimbing.internal.di

import com.itmoclimbing.data.repository.RoutesRepositoryStub
import com.itmoclimbing.domain.repository.RoutesRepository
import toothpick.config.Module

class RoutesModule : Module() {

    init {
        bind(RoutesRepository::class.java).to(RoutesRepositoryStub::class.java).singleton()
    }

}