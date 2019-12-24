package com.itmoclimbing.presentationcommon.internal.di

import toothpick.Toothpick
import toothpick.config.Module

object DiScopes {
    val ROOT_SCOPE = Scope("ROOT_SCOPE")
    val APP_SCOPE = Scope("APP_SCOPE", ROOT_SCOPE)
    val USERS_SCOPE = Scope("USERS_SCOPE", APP_SCOPE)
    val ROUTES_SCOPE = Scope("ROUTES_SCOPE", APP_SCOPE)
    val ROUTES_INTERNAL_SCOPE = Scope("ROUTES_INTERNAL_SCOPE", ROUTES_SCOPE)
}

data class Scope(private val name: String, private val parent: Scope? = null) {

    private fun getScopesSequence(): List<String> = parent?.getScopesSequence().orEmpty() + name

    fun openWithModules(modulesFactory: () -> Array<Module>): toothpick.Scope =
            if (Toothpick.isScopeOpen(name)) {
                Toothpick.openScope(name)
            } else {
                Toothpick
                        .openScopes(*getScopesSequence().toTypedArray())
                        .installModules(*modulesFactory())
            }

    fun openScope(): toothpick.Scope = Toothpick.openScope(name)

    fun closeScope() = Toothpick.closeScope(name)

}