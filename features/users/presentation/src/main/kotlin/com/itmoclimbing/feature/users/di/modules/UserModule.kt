package com.itmoclimbing.feature.users.di.modules

import com.itmoclimbing.dataCommon.repository.UsersRepositoryStub
import com.itmoclimbing.domainCommon.repository.UsersRepository
import toothpick.config.Module
import toothpick.ktp.binding.bind

class UserModule: Module() {

    init {
        bind<UsersRepository>().toClass<UsersRepositoryStub>().singleton()
    }

}