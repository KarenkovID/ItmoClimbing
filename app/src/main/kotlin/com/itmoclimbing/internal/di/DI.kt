package com.itmoclimbing.internal.di

import toothpick.Scope
import toothpick.Toothpick

object DI {

    fun getScope(scope: Scopes): Scope = synchronized(this) {
        Toothpick.openScope(scope.scopeName)
    }

    fun openAppScope(): Scope = synchronized(this) {
        Toothpick
                .openScope(Scopes.APP_SCOPE.scopeName)
                .installModules(
                        AppModule(),
                        RoutesModule(),
                        MainNavigationModule(),
                        RoutesNavigationModule(),
                        UsersNavigationModule(),
                        UserModule()
                )
    }
}

enum class Scopes(val scopeName: String) {
    APP_SCOPE("APP_SCOPE")
}