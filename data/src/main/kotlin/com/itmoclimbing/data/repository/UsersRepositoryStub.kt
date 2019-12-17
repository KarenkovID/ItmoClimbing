package com.itmoclimbing.data.repository

import com.itmoclimbing.domain.model.User
import com.itmoclimbing.domain.repository.UsersRepository

class UsersRepositoryStub: UsersRepository {

    override fun getAllUsers(): List<User> = listOf()

}