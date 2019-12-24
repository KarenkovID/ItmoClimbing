package com.itmoclimbing.internal.feature

import com.itmoclimbing.presentation.main.MainViewModel
import com.itmoclimbing.presentation.screens.main.MainScreenNavigation
import com.itmoclimbing.presentationcommon.features.FeatureComponent
import com.itmoclimbing.presentationcommon.features.api.FeatureAppApi
import com.itmoclimbing.presentationcommon.internal.di.DiScopes

class AppComponent(dependencies: AppDependencies) : FeatureComponent<FeatureAppApi> {

    init {
        DiScopes.APP_SCOPE.openScope().installModules(DependenciesModule(dependencies))
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