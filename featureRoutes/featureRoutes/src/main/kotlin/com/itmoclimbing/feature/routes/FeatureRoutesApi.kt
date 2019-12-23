package com.itmoclimbing.feature.routes

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.routes.presentation.RoutesScreenContainerFragment

object FeatureRoutesApi {

    fun getMainRoutesFragment(): Fragment = RoutesScreenContainerFragment.newInstance()

}