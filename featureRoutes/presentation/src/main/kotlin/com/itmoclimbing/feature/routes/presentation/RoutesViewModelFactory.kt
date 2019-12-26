package com.itmoclimbing.feature.routes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.feature.routes.di.DI
import toothpick.InjectConstructor

@InjectConstructor
class RoutesViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DI.getRoutesInternalScope().getInstance(modelClass)

}