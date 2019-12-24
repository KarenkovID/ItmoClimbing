package com.itmoclimbing.feature.routes.di

import com.itmoclimbing.feature.routes.di.modules.RoutesModule
import com.itmoclimbing.feature.routes.di.modules.RoutesNavigationModule
import com.itmoclimbing.presentationcommon.internal.di.DiScopes
import toothpick.Scope

internal object DI {

    fun getRoutesInternalScope(): Scope = synchronized(this) {
        DiScopes.ROUTES_INTERNAL_SCOPE.openWithModules {
            arrayOf(
                    RoutesModule(),
                    RoutesNavigationModule()
            )
        }
    }

}