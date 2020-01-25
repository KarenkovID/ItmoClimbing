package com.itmoclimbing.features.common

abstract class BaseMediator<TApi : Any, TComponent : FeatureComponent<TApi>, TDependencies : Any>
    : FeatureMediator<TApi> {

    protected val component: TComponent by lazy {
        provideComponent(provideDependencies())
    }

    protected abstract fun provideComponent(dependencies: TDependencies): TComponent

    protected abstract fun provideDependencies(): TDependencies

}