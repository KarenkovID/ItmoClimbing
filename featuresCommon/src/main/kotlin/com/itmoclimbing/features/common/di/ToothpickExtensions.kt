package com.itmoclimbing.features.common.di

import toothpick.Scope
import toothpick.config.Module

inline fun <reified T : Any> Scope.installSingleInstanceModule(instance: T) = this.installModules(
        object : Module() {
            init {
                bind(T::class.java).toInstance(instance)
            }
        }
)