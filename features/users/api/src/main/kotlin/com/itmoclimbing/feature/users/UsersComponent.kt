package com.itmoclimbing.feature.users

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.users.presentation.UsersScreenContainerFragment
import com.itmoclimbing.feature.users.presentation.list.UsersListFragment
import com.itmoclimbing.features.common.FeatureComponent
import com.itmoclimbing.features.common.api.FeatureUsersApi
import com.itmoclimbing.features.common.dependencies.UsersDependencies
import com.itmoclimbing.features.common.di.DiScopes
import com.itmoclimbing.features.common.di.installSingleInstanceModule

class UsersComponent(usersDependencies: UsersDependencies) : FeatureComponent<FeatureUsersApi> {

    init {
        DiScopes.USERS_SCOPE.openScope().installSingleInstanceModule(usersDependencies)
    }

    fun destroyComponent() {
        DiScopes.USERS_SCOPE.closeScope()
    }

    override fun api(): FeatureUsersApi = object : FeatureUsersApi {

        override fun getUsersFragment(): Fragment = UsersScreenContainerFragment.newInstance()

        override fun getUsersPassedRouteFragment(routeId: Int): Fragment = UsersListFragment.newInstance(routeId)

    }

}
