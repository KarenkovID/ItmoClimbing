package com.itmoclimbing.feature.routes.di

import com.itmoclimbing.feature.routes.di.modules.RoutesModule
import com.itmoclimbing.feature.routes.di.modules.RoutesNavigationModule
import com.itmoclimbing.presentationcommon.internal.di.DiScopes
import toothpick.Scope

internal object DI {

    fun getScopeRoutesScope(): Scope = synchronized(this) {
        DiScopes.ROUTES_SCOPE.openWithModules {
            arrayOf(
                    RoutesModule(),
                    RoutesNavigationModule()
            )
        }
    }

}