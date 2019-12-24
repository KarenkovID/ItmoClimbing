package com.itmoclimbing.feature.users.di

import com.itmoclimbing.feature.users.di.modules.UserModule
import com.itmoclimbing.feature.users.di.modules.UsersNavigationModule
import com.itmoclimbing.presentationcommon.internal.di.DiScopes
import toothpick.Scope

internal object DI {

    fun getUsersScope(): Scope = synchronized(this) {
        DiScopes.USERS_SCOPE.openWithModules {
            arrayOf(
                    UserModule(),
                    UsersNavigationModule()
            )
        }
    }

}