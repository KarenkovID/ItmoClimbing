package com.itmoclimbing.feature.routes

import com.itmoclimbing.presentationcommon.features.dependencies.RoutesDependencies
import toothpick.config.Module

class DependenciesModule(routesDependencies: RoutesDependencies) : Module() {

    init {
        bind(RoutesDependencies::class.java).toInstance(routesDependencies)
    }

}