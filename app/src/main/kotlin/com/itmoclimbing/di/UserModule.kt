package com.itmoclimbing.di

import com.itmoclimbing.data.repository.UsersRepositoryStub
import com.itmoclimbing.domain.repository.UsersRepository
import toothpick.config.Module

class UserModule: Module() {

    init {
        bind(UsersRepository::class.java).to(UsersRepositoryStub::class.java).singleton()
    }

}