package com.itmoclimbing.presentation.main

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.itmoclimbing.R
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation

class MainViewModel : ViewModel() {

    private val mainNavigation: MainScreenNavigation by lazy {
        DI.getScope(Scopes.APP_SCOPE).getInstance(MainScreenNavigation::class.java)
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

}