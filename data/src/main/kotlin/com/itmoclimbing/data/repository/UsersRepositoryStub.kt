package com.itmoclimbing.data.repository

import com.itmoclimbing.domain.model.User
import com.itmoclimbing.domain.repository.UsersRepository
import io.reactivex.Completable
import io.reactivex.Single

class UsersRepositoryStub : UsersRepository {

    override fun getAllUsers(): Single<List<User>> = Single.just(listOf())

    override fun addUser(user: User): Completable = Completable.complete()

}