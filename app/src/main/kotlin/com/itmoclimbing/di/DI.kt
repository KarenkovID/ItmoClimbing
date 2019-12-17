package com.itmoclimbing.di

import toothpick.Toothpick

object DI {

    fun getScope(scope: Scopes) = synchronized(this) {
        Toothpick.openScope(scope.scopeName)
    }

    fun openAppScope() = synchronized(this) {
        Toothpick
            .openScope(Scopes.APP_SCOPE.scopeName)
            .installModules(
                RoutesModule(),
                UserModule()
            )
    }
}

enum class Scopes(val scopeName: String) {
    APP_SCOPE("APP_SCOPE")
}