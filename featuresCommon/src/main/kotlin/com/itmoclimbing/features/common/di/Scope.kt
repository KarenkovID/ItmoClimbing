package com.itmoclimbing.features.common.di

import toothpick.Toothpick
import toothpick.config.Module

class Scope(
        private val name: String,
        private val parent: Scope? = null
) {

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