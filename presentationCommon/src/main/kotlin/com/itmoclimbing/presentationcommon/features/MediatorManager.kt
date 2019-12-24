package com.itmoclimbing.presentationcommon.features

import com.itmoclimbing.presentationcommon.features.api.FeatureAppApi
import com.itmoclimbing.presentationcommon.features.api.FeatureRoutesApi

class MediatorManager constructor(
        val routesMediator: FeatureMediator<FeatureRoutesApi>,
        val appMediator: FeatureMediator<FeatureAppApi>
)