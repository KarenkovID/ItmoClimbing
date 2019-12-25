package com.itmoclimbing.feature.users

import androidx.fragment.app.Fragment
import com.itmoclimbing.features.common.BaseMediator
import com.itmoclimbing.features.common.api.FeatureUsersApi
import com.itmoclimbing.features.common.dependencies.UsersDependencies

class UsersMediator : BaseMediator<FeatureUsersApi, UsersComponent, UsersDependencies>() {

    /**
     * По сути это прокси для ленивой инициализации реального компонента.
     * При обращении к api мы сможем его вернуть, а реальный компонент будет подставлен позднее
     */
    override val apiStub = object : FeatureUsersApi {

        override fun getUsersFragment(): Fragment = provideComponent().api().getUsersFragment()

    }

    override fun provideComponent(dependencies: UsersDependencies): UsersComponent = UsersComponent(dependencies)

    override fun provideDependencies(): UsersDependencies = object : UsersDependencies {

    }

}