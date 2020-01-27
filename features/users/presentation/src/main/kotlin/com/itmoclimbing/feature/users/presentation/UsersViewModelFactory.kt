package com.itmoclimbing.feature.users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.feature.users.di.DI
import toothpick.InjectConstructor

@InjectConstructor
class UsersViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DI.getUsersInternalScope().getInstance(modelClass)

}