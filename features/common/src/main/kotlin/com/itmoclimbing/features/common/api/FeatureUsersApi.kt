package com.itmoclimbing.features.common.api

import androidx.fragment.app.Fragment

interface FeatureUsersApi {

    fun getUsersFragment(): Fragment

    fun getUsersPassedRouteFragment(routeId: Int): Fragment

}