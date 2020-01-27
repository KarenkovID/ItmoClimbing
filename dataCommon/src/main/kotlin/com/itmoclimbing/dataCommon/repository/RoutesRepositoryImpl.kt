package com.itmoclimbing.dataCommon.repository

import com.itmoclimbing.dataCommon.network.api.RoutesApi
import com.itmoclimbing.dataCommon.network.request.AddRouteRequestBody
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.kommander.components.android.extensions.schedulersIoToMain
import io.reactivex.Completable
import io.reactivex.Single
import toothpick.InjectConstructor

@InjectConstructor
class RoutesRepositoryImpl(
        private val routesApi: RoutesApi
): RoutesRepository {

    override fun getRoutes(): Single<List<Route>> = routesApi.getRoutes()

    override fun addRoute(name: String, grade: String, description: String): Completable =
            routesApi.addRoute(AddRouteRequestBody(name, grade, description)).schedulersIoToMain()

    override fun removeRoute(routeId: String): Completable = routesApi.removeRoute(routeId)
}