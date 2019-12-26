package com.itmoclimbing.features.common.di

import toothpick.Scope
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

inline fun <reified T : Any> Scope.installSingleInstanceModule(instance: T): Scope = this.installModules(
        module {
            bind<T>().toInstance(instance)
        }
)