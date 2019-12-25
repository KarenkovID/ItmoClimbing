package com.itmoclimbing.feature.routes

import androidx.fragment.app.Fragment
import com.itmoclimbing.features.common.BaseMediator
import com.itmoclimbing.features.common.api.FeatureRoutesApi
import com.itmoclimbing.features.common.dependencies.RoutesDependencies

class RoutesMediator : BaseMediator<FeatureRoutesApi, RoutesComponent, RoutesDependencies>() {

    /**
     * По сути это прокси для ленивой инициализации реального компонента.
     * При обращении к api мы сможем его вернуть, а реальный компонент будет подставлен позднее
     */
    override val apiStub = object : FeatureRoutesApi {

        override fun getRoutesFragment(): Fragment = provideComponent().api().getRoutesFragment()

    }

    override fun provideComponent(dependencies: RoutesDependencies): RoutesComponent = RoutesComponent(dependencies)

    override fun provideDependencies(): RoutesDependencies = object : RoutesDependencies {

        override fun selectUsersTab() = mediatorManager.appMediator.apiStub.selectUsersTab()

        override fun getUsersFragment(): Fragment = mediatorManager.usersMediator.apiStub.getUsersFragment()

    }

}

//class RoutesMediator(mediatorManager: MediatorManager) : BaseMediator<FeatureRoutesApi>(mediatorManager) {
//
//    private val componentHolder = SingleComponentHolder(::RoutesComponent)
//
//    private fun provideComponent(): RoutesComponent {
//        if (!componentHolder.hasComponent()) {
//            componentHolder.initComponent(object : RoutesDependencies {
//
//                override fun openUsersIntMain() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//            })
//        }
//        return componentHolder.provideComponent()
//    }
//
//    /**
//     * По сути это прокси для ленивой инициализации реального компонента.
//     * При обращении к api мы сможем его вернуть, а реальный компонент будет подставлен позднее
//     */
//    override val apiStub = object : FeatureRoutesApi {
//
//        override fun getRoutesFragment(): Fragment = provideComponent().api().getRoutesFragment()
//
//    }
//
//}