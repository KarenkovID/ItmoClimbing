package com.itmoclimbing.features.common

abstract class BaseMediator<TApi : Any, TComponent : FeatureComponent<TApi>, TDependencies : Any>
    : FeatureMediator<TApi> {

    private val componentHolder =
            SingleComponentHolder<TComponent, TDependencies>(::provideComponent)

    protected abstract fun provideComponent(dependencies: TDependencies): TComponent

    protected abstract fun provideDependencies(): TDependencies

    protected fun provideComponent(): TComponent {
        if (!componentHolder.hasComponent()) {
            componentHolder.initComponent(provideDependencies())
        }
        return componentHolder.provideComponent()
    }

    private class SingleComponentHolder<TComponent : Any, TDependencies : Any>(
            private val componentFactory: (TDependencies) -> TComponent
    ) {

        private var component: TComponent? = null

        fun hasComponent(): Boolean = component != null

        fun initComponent(dependencies: TDependencies) {
            if (component != null) {
                throw error("Component $component is already initialized")
            }
            component = componentFactory(dependencies)
        }

        fun provideComponent(): TComponent = component!!

    }

}