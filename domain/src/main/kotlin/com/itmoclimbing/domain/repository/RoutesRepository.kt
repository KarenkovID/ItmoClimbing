package com.itmoclimbing.domain.repository

import com.itmoclimbing.domain.model.Route
import com.itmoclimbing.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface RoutesRepository {

    fun getAllRoutes(): Single<List<Route>>

    fun addRoute(route: Route): Completable

    fun removeRoute(routeId: String): Completable

}