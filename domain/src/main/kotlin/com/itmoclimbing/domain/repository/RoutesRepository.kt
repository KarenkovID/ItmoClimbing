package com.itmoclimbing.domain.repository

import com.itmoclimbing.domain.model.Route
import com.itmoclimbing.domain.model.User

interface RoutesRepository {

    fun getAllRoutes(): List<Route>

    fun getRoutesSolvedByUser(user: User): List<Route>

    fun getRoutesSettedByUser(user: User): List<Route>

}