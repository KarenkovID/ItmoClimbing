package com.itmoclimbing.features.routes.data

import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.freatures.routes.domain.RoutesRepository
import io.reactivex.Observable
import io.reactivex.Single

class RoutesRepositoryImpl : RoutesRepository {

    override fun observeRoutes(): Observable<Route> = TODO()

    override fun getRouteById(): Single<Route> = TODO()

}