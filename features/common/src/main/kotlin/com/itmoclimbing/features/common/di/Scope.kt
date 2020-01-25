package com.itmoclimbing.features.common.di

import toothpick.config.Module
import toothpick.ktp.KTP

class Scope(
        private val name: String,
        private val parent: Scope? = null
) {

    private fun getScopesSequence(): List<String> = parent?.getScopesSequence().orEmpty() + name

    fun openWithModules(modulesFactory: () -> Array<Module>): toothpick.Scope =
            if (KTP.isScopeOpen(name)) {
                KTP.openScope(name)
            } else {
                KTP
                        .openScopes(*getScopesSequence().toTypedArray())
                        .installModules(*modulesFactory())
            }

    fun openScope(): toothpick.Scope = KTP.openScopes(*getScopesSequence().toTypedArray())

    fun closeScope() = KTP.closeScope(name)

}