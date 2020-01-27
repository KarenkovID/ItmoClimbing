package com.itmoclimbing.dataCommon.repository

import com.itmoclimbing.dataCommon.network.api.UsersApi
import com.itmoclimbing.dataCommon.network.request.AddUserRequestBody
import com.itmoclimbing.domainCommon.model.User
import com.itmoclimbing.domainCommon.repository.UsersRepository
import com.kommander.components.android.extensions.schedulersIoToMain
import io.reactivex.Completable
import io.reactivex.Single
import toothpick.InjectConstructor

@InjectConstructor
class UsersRepositoryImpl(
        private val usersApi: UsersApi
) : UsersRepository {

    override fun getAllUsers(): Single<List<User>> = usersApi.getUsers()

    override fun addUser(
            firstName: String,
            lastName: String
    ): Completable = usersApi.addUser(AddUserRequestBody(firstName, lastName)).schedulersIoToMain()

}