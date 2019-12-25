package com.itmoclimbing.features.common

import com.itmoclimbing.features.common.api.FeatureAppApi
import com.itmoclimbing.features.common.api.FeatureRoutesApi

class MediatorManager constructor(
        val routesMediator: FeatureMediator<FeatureRoutesApi>,
        val appMediator: FeatureMediator<FeatureAppApi>
)