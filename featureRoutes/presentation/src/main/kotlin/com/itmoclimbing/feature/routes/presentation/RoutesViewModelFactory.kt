package com.itmoclimbing.feature.routes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.feature.routes.di.DI
import javax.inject.Inject

class RoutesViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DI.getScopeRoutesScope().getInstance(modelClass)

}