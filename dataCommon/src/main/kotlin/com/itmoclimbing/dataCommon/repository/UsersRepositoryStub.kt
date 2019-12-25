package com.itmoclimbing.dataCommon.repository

import com.itmoclimbing.domainCommon.model.User
import com.itmoclimbing.domainCommon.repository.UsersRepository
import io.reactivex.Completable
import io.reactivex.Single

class UsersRepositoryStub : UsersRepository {

    override fun getAllUsers(): Single<List<User>> = Single.just(listOf())

    override fun addUser(user: User): Completable = Completable.complete()

}