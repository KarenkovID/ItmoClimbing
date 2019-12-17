package com.itmoclimbing.data.repository

import com.itmoclimbing.domain.model.Route
import com.itmoclimbing.domain.model.User
import com.itmoclimbing.domain.repository.RoutesRepository
import javax.inject.Inject


class RoutesRepositoryStub @Inject constructor() : RoutesRepository {

    override fun getAllRoutes(): List<Route> = emptyList()

    override fun getRoutesSolvedByUser(user: User): List<Route> = emptyList()

    override fun getRoutesSettedByUser(user: User): List<Route> = emptyList()

}