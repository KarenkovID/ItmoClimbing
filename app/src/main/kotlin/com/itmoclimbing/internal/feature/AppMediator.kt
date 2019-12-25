package com.itmoclimbing.internal.feature

import androidx.fragment.app.Fragment
import com.itmoclimbing.features.common.BaseMediator
import com.itmoclimbing.features.common.api.FeatureAppApi
import com.itmoclimbing.features.common.dependencies.AppDependencies

class AppMediator : BaseMediator<FeatureAppApi, AppComponent, AppDependencies>() {

    override fun provideComponent(dependencies: AppDependencies): AppComponent = AppComponent(dependencies)

    override fun provideDependencies(): AppDependencies = object : AppDependencies {

        override fun getRoutesFragment(): Fragment = mediatorManager.routesMediator.apiStub.getRoutesFragment()

    }

    override val apiStub: FeatureAppApi = object : FeatureAppApi {

        override fun selectRoutesTab() {
            provideComponent().api().selectRoutesTab()
        }

        override fun selectUsersTab() {
            provideComponent().api().selectUsersTab()
        }

    }

}