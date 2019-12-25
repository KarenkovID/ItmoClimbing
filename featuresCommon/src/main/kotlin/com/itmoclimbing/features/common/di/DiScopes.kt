package com.itmoclimbing.features.common.di

object DiScopes {

    val ROOT_SCOPE = Scope("ROOT_SCOPE")
    val APP_SCOPE = Scope("APP_SCOPE", ROOT_SCOPE)
    val USERS_SCOPE = Scope("USERS_SCOPE", APP_SCOPE)
    val USERS_INTERNAL_SCOPE = Scope("USERS_INTERNAL_SCOPE", USERS_SCOPE)
    val ROUTES_SCOPE = Scope("ROUTES_SCOPE", APP_SCOPE)
    val ROUTES_INTERNAL_SCOPE = Scope("ROUTES_INTERNAL_SCOPE", ROUTES_SCOPE)

}