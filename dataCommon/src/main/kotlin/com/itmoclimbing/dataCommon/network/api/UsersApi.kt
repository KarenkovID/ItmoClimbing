package com.itmoclimbing.dataCommon.network.api

import com.itmoclimbing.dataCommon.network.request.AddUserRequestBody
import com.itmoclimbing.domainCommon.model.User
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsersApi {

    companion object {
        private const val USER_ID = "USER_ID"
        private const val ROUTE_ID = "ROUTE_ID"
    }

    @GET("users")
    fun getUsers(): Single<List<User>>

    @POST("users")
    fun addUser(
            @Body body: AddUserRequestBody
    ): Completable

    @GET("routes/passed/route/{$ROUTE_ID}")
    fun getUsersByRouteId(
            @Path(ROUTE_ID) routeId: Int
    ): Single<List<User>>

    @GET("users/{$USER_ID}")
    fun getUser(
            @Path(USER_ID) userId: Int
    ): Single<User>

    @PUT("users/{$USER_ID}")
    fun updateUser(
            @Path(USER_ID) userId: Int
    ): Completable

    @DELETE("users/{$USER_ID}")
    fun removeUser(
            @Path(USER_ID) userId: Int
    ): Completable

}