package com.itmoclimbing.dataCommon.repository

import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RoutesRepositoryStub @Inject constructor() : RoutesRepository {

    override fun getAllRoutes(): Single<List<Route>> = Single.just(emptyList())

    override fun addRoute(route: Route): Completable = Completable.complete()

    override fun removeRoute(routeId: String): Completable = Completable.complete()

}