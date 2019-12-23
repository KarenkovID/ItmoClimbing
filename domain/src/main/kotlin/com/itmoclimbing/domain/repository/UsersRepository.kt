package com.itmoclimbing.domain.repository

import com.itmoclimbing.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UsersRepository {

    fun getAllUsers(): Single<List<User>>

    fun addUser(user: User): Completable

}