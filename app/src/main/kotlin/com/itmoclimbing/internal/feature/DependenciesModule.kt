package com.itmoclimbing.internal.feature

import com.itmoclimbing.features.common.dependencies.AppDependencies
import toothpick.config.Module

class DependenciesModule(appDependencies: AppDependencies) : Module() {

    init {
        bind(AppDependencies::class.java).toInstance(appDependencies)
    }

}