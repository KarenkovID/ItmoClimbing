package com.itmoclimbing.presentation.main

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.itmoclimbing.R
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation
import com.kommander.components.android.viewmodel.livedata.SingleEventLiveData
import toothpick.InjectConstructor

@InjectConstructor
class MainViewModel : ViewModel() {

    val onTabSelectedLiveData = SingleEventLiveData<Int>()

    private val mainNavigation: MainScreenNavigation by lazy {
        DI.getAppScope().getInstance(MainScreenNavigation::class.java)
    }

    init {
        mainNavigation.selectRoutes()
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuItemRoutes -> mainNavigation.selectRoutes()
            R.id.menuItemUsers -> mainNavigation.selectUsers()
            else -> error("Unknown item id")
        }
        return true
    }

    fun selectUsers() {
        onTabSelectedLiveData.setValue(R.id.menuItemUsers)
    }

}