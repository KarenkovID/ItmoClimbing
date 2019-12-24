package com.itmoclimbing.presentationcommon.internal.di

import toothpick.Toothpick
import toothpick.config.Module

object DiScopes {
    val APP_SCOPE = Scope("APP_SCOPE")
    val USERS_SCOPE = Scope("USERS_SCOPE", APP_SCOPE)
    val ROUTES_SCOPE = Scope("ROUTES_SCOPE", APP_SCOPE)
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

}