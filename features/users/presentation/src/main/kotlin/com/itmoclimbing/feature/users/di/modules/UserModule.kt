package com.itmoclimbing.feature.users.di.modules

import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.dataCommon.repository.UsersRepositoryImpl
import com.itmoclimbing.domainCommon.repository.UsersRepository
import com.itmoclimbing.feature.users.presentation.UsersViewModelFactory
import com.itmoclimbing.feature.users.presentation.creation.CreateUserViewModel
import com.itmoclimbing.feature.users.presentation.list.UsersListViewModel
import toothpick.config.Module
import toothpick.ktp.binding.bind

class UserModule : Module() {

    init {
        bind<UsersRepository>().toClass<UsersRepositoryImpl>().singleton()
        bind<ViewModelProvider.Factory>().toClass<UsersViewModelFactory>().singleton()
        bind<UsersListViewModel>()
        bind<CreateUserViewModel>()
    }

}