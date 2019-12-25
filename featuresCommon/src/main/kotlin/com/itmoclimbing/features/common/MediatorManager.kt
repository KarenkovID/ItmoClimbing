package com.itmoclimbing.features.common

import com.itmoclimbing.features.common.api.FeatureAppApi
import com.itmoclimbing.features.common.api.FeatureRoutesApi
import com.itmoclimbing.features.common.api.FeatureUsersApi

class MediatorManager constructor(
        val routesMediator: FeatureMediator<FeatureRoutesApi>,
        val appMediator: FeatureMediator<FeatureAppApi>,
        val usersMediator: FeatureMediator<FeatureUsersApi>
)