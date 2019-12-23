package com.itmoclimbing.feature.routes.di

import com.itmoclimbing.feature.routes.di.modules.RoutesNavigationModule
import com.itmoclimbing.feature.routes.di.modules.RoutesModule
import toothpick.Scope
import toothpick.Toothpick

internal object DI {

    fun getScopeRoutesScope(): Scope = synchronized(this) {
        Toothpick.openScope(Scopes.ROUTES_SCOPE.scopeName)
    }

    fun openRoutesScope(): Scope = synchronized(this) {
        if (!Toothpick.isScopeOpen(Scopes.ROUTES_SCOPE.scopeName)) {
            Toothpick
                    .openScopes(Scopes.APP_SCOPE.scopeName, Scopes.ROUTES_SCOPE.scopeName)
                    .installModules(
                            RoutesModule(),
                            RoutesNavigationModule()
                    )
        } else {
            getScopeRoutesScope()
        }
    }
}

enum class Scopes(val scopeName: String) {
    APP_SCOPE("APP_SCOPE"),
    ROUTES_SCOPE("ROUTES_SCOPE")
}