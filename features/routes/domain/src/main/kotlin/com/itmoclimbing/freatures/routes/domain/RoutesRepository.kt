package com.itmoclimbing.freatures.routes.domain

import com.itmoclimbing.domainCommon.model.Route
import io.reactivex.Observable
import io.reactivex.Single

interface RoutesRepository {

    fun observeRoutes(): Observable<Route>

    fun getRouteById(): Single<Route>

}