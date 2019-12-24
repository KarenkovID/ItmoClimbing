package com.itmoclimbing.feature.routes

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.routes.presentation.RoutesScreenContainerFragment
import com.itmoclimbing.presentationcommon.features.api.FeatureRoutesApi

class FeatureRoutesApiImpl : FeatureRoutesApi {

    override fun getRoutesFragment(): Fragment = RoutesScreenContainerFragment.newInstance()

}