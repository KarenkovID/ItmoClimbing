package com.itmoclimbing.internal.feature

import com.itmoclimbing.presentation.main.MainViewModel
import com.itmoclimbing.features.common.FeatureComponent
import com.itmoclimbing.features.common.api.FeatureAppApi
import com.itmoclimbing.features.common.dependencies.AppDependencies
import com.itmoclimbing.features.common.di.DiScopes
import com.itmoclimbing.features.common.di.installSingleInstanceModule

class AppComponent(dependencies: AppDependencies) : FeatureComponent<FeatureAppApi> {

    init {
        DiScopes.APP_SCOPE.openScope().installSingleInstanceModule(dependencies)
    }

    override fun api(): FeatureAppApi = object : FeatureAppApi {

        val mainViewModel by lazy {
            DiScopes.APP_SCOPE.openScope().getInstance(MainViewModel::class.java)
        }

        override fun selectRoutesTab() {
//            mainScreenNavigation.selectRoutes()
        }

        override fun selectUsersTab() {
            mainViewModel.selectUsers()
        }

    }

}