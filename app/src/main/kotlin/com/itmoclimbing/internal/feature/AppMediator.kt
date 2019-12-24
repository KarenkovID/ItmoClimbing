package com.itmoclimbing.internal.feature

import androidx.fragment.app.Fragment
import com.itmoclimbing.presentationcommon.features.BaseMediator
import com.itmoclimbing.presentationcommon.features.api.FeatureAppApi

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