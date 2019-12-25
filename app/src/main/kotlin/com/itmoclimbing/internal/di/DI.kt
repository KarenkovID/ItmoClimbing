package com.itmoclimbing.internal.di

import com.itmoclimbing.features.common.di.DiScopes
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
                    MainNavigationModule()
            )
        }
    }

}