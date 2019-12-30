package com.itmoclimbing.internal.feature

import androidx.fragment.app.Fragment
import com.itmoclimbing.features.common.BaseMediator
import com.itmoclimbing.features.common.api.FeatureAppApi
import com.itmoclimbing.features.common.dependencies.AppDependencies
import com.itmoclimbing.features.common.di.DiScopes
import com.itmoclimbing.features.common.mediators.AppMediator
import com.itmoclimbing.features.common.mediators.RoutesMediator
import toothpick.InjectConstructor
import toothpick.ktp.extension.getInstance
import toothpick.ktp.extension.getLazy

@InjectConstructor
class AppMediatorImpl : BaseMediator<FeatureAppApi, AppComponent, AppDependencies>(), AppMediator {

    private val routesMediator = DiScopes.ROOT_SCOPE.openScope().getLazy<RoutesMediator>()

    override fun provideComponent(dependencies: AppDependencies): AppComponent = AppComponent(dependencies)

    override fun provideDependencies(): AppDependencies = object : AppDependencies {

        override fun getRoutesFragment(): Fragment = routesMediator.get().apiStub.getRoutesFragment()

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