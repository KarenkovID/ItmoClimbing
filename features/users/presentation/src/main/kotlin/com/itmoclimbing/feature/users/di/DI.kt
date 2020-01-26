package com.itmoclimbing.feature.users.di

import com.itmoclimbing.feature.users.di.modules.UserModule
import com.itmoclimbing.feature.users.di.modules.UsersNavigationModule
import com.itmoclimbing.features.common.di.DiScopes
import toothpick.Scope

internal object DI {

    fun getUsersInternalScope(): Scope = synchronized(this) {
        DiScopes.USERS_INTERNAL_SCOPE.openWithModules {
            arrayOf(
                    UserModule(),
                    UsersNavigationModule()
            )
        }
    }

}