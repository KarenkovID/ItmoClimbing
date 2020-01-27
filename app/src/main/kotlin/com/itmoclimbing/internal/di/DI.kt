package com.itmoclimbing.internal.di

import com.itmoclimbing.features.common.di.DiScopes
import com.itmoclimbing.internal.di.modules.AppModule
import com.itmoclimbing.internal.di.modules.DataModule
import com.itmoclimbing.internal.di.modules.MainNavigationModule
import com.itmoclimbing.internal.di.modules.NetworkModule
import com.itmoclimbing.internal.di.modules.RootModule
import toothpick.Scope

internal object DI {

    fun openRootScope(): Scope = synchronized(this) {
        DiScopes.ROOT_SCOPE.openWithModules {
            arrayOf(RootModule())
        }
    }

    fun getAppScope(): Scope = synchronized(this) {
        DiScopes.APP_SCOPE.openWithModules {
            arrayOf(
                    AppModule(),
                    MainNavigationModule(),
                    NetworkModule(),
                    DataModule()
            )
        }
    }

}