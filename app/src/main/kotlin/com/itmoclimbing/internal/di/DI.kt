package com.itmoclimbing.internal.di

import com.itmoclimbing.presentationcommon.internal.di.DiScopes
import toothpick.Scope

internal object DI {

    fun getAppScope(): Scope = synchronized(this) {
        DiScopes.APP_SCOPE.openWithModules {
            arrayOf(
                    AppModule(),
                    MainNavigationModule()
            )
        }
    }

}