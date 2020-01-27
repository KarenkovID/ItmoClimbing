package com.itmoclimbing.domainCommon.repository

import com.itmoclimbing.domainCommon.model.Route
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface RoutesRepository {

    fun getRoutes(): Single<List<Route>>

    fun addRoute(name: String, grade: String, description: String): Completable

    fun removeRoute(routeId: String): Completable

}