package com.itmoclimbing.feature.routes

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.routes.presentation.RoutesScreenContainerFragment
import com.itmoclimbing.features.common.FeatureComponent
import com.itmoclimbing.features.common.api.FeatureRoutesApi
import com.itmoclimbing.features.common.dependencies.RoutesDependencies
import com.itmoclimbing.features.common.di.DiScopes

class RoutesComponent(routesDependencies: RoutesDependencies): FeatureComponent<FeatureRoutesApi> {

    init {
        DiScopes.ROUTES_SCOPE.openScope().installModules(DependenciesModule(routesDependencies))
    }

    fun destroyComponent() {
        DiScopes.ROUTES_SCOPE.closeScope()
    }

    override fun api(): FeatureRoutesApi = object : FeatureRoutesApi {

        override fun getRoutesFragment(): Fragment = RoutesScreenContainerFragment.newInstance()

    }

}