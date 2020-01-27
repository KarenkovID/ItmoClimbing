package com.itmoclimbing.features.common.dependencies

import androidx.fragment.app.Fragment

interface RoutesDependencies {

    fun getUsersSolvedRouteFragment(routeId: Int): Fragment

}