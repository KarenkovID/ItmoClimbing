package com.itmoclimbing.feature.routes

import com.itmoclimbing.presentationcommon.features.FeatureComponent
import com.itmoclimbing.presentationcommon.features.api.FeatureRoutesApi
import com.itmoclimbing.presentationcommon.features.dependencies.RoutesDependencies
import com.itmoclimbing.presentationcommon.internal.di.DiScopes

class RoutesComponent(routesDependencies: RoutesDependencies): FeatureComponent<FeatureRoutesApi> {

    init {
        DiScopes.ROUTES_SCOPE.openScope().installModules(DependenciesModule(routesDependencies))
    }

    fun destroyComponent() {
        DiScopes.ROUTES_SCOPE.closeScope()
    }

    override fun api(): FeatureRoutesApi = FeatureRoutesApiImpl()

}