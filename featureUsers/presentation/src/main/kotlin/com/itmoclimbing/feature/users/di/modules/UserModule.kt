package com.itmoclimbing.feature.users.di.modules

import com.itmoclimbing.dataCommon.repository.UsersRepositoryStub
import com.itmoclimbing.domainCommon.repository.UsersRepository
import toothpick.config.Module

class UserModule: Module() {

    init {
        bind(UsersRepository::class.java).to(UsersRepositoryStub::class.java).singleton()
    }

}