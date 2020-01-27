package com.itmoclimbing.dataCommon.network.api

import com.itmoclimbing.dataCommon.network.request.AddRouteRequestBody
import com.itmoclimbing.domainCommon.model.Route
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RoutesApi {

    companion object {
        private const val ROUTE_ID = "ROUTE_ID"
    }

    @GET("routes")
    fun getRoutes(): Single<List<Route>>

    @POST("routes")
    fun addRoute(
            @Body body: AddRouteRequestBody
    ): Completable

    @GET("routes/{$ROUTE_ID}")
    fun getRoute(
            @Path(ROUTE_ID) routeId: Int
    ): Single<Route>

    @PUT("routes/{$ROUTE_ID}")
    fun updateRoute(
            @Path(ROUTE_ID) routeId: Int
    ): Completable

    @DELETE("routes/{$ROUTE_ID}")
    fun removeRoute(
            @Path(ROUTE_ID) routeId: Int
    ): Completable

}