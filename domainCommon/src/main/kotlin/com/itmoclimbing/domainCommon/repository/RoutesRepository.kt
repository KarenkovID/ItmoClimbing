package com.itmoclimbing.domainCommon.repository

import com.itmoclimbing.domainCommon.model.Route
import io.reactivex.Completable
import io.reactivex.Single

interface RoutesRepository {

    fun getAllRoutes(): Single<List<Route>>

    fun addRoute(route: Route): Completable

    fun removeRoute(routeId: String): Completable

}