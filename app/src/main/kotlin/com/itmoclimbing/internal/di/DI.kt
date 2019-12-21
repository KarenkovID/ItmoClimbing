package com.itmoclimbing.internal.di

import com.itmoclimbing.internal.di.app.AppModule
import com.itmoclimbing.internal.di.app.MainNavigationModule
import com.itmoclimbing.internal.di.app.RoutesNavigationModule
import com.itmoclimbing.internal.di.app.UsersNavigationModule
import com.itmoclimbing.internal.di.app.routes.RoutesModule
import com.itmoclimbing.internal.di.app.users.UserModule
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