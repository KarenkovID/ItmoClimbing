package com.itmoclimbing.domainCommon.repository

import com.itmoclimbing.domainCommon.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UsersRepository {

    fun getAllUsers(): Single<List<User>>

    fun addUser(firstName: String, lastName: String): Completable

}