package com.itmoclimbing.internal.di

import com.itmoclimbing.internal.di.app.MainNavigationModule
import com.itmoclimbing.internal.di.app.UsersNavigationModule
import toothpick.Scope
import toothpick.Toothpick

internal object DI {

    fun getScope(scope: Scopes): Scope = synchronized(this) {
        Toothpick.openScope(scope.scopeName)
    }

    fun openAppScope(): Scope = synchronized(this) {
        Toothpick
                .openScopes(Scopes.APP_SCOPE.scopeName)
                .installModules(
                        AppModule(),
                        MainNavigationModule(),
                        UsersNavigationModule()
                )
    }
}

enum class Scopes(val scopeName: String) {
    APP_SCOPE("APP_SCOPE"),
    ROUTES_SCOPE("ROUTES_SCOPE")
}