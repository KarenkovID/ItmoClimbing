package com.itmoclimbing.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itmoclimbing.internal.di.DI
import javax.inject.Inject

class AppViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = DI.getAppScope().getInstance(modelClass)

}