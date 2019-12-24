package com.itmoclimbing.feature.routes

import androidx.fragment.app.Fragment
import com.itmoclimbing.presentationcommon.features.BaseMediator
import com.itmoclimbing.presentationcommon.features.api.FeatureRoutesApi
import com.itmoclimbing.presentationcommon.features.dependencies.RoutesDependencies

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