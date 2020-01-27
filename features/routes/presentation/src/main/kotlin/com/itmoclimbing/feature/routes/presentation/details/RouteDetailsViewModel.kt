package com.itmoclimbing.feature.routes.presentation.details

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import toothpick.InjectConstructor

@InjectConstructor
class RouteDetailsViewModel(
        private val routesRepository: RoutesRepository,
        private val routesScreenNavigation: RoutesScreenNavigation
) : BaseViewModel() {

    val routeLiveData = MutableLiveData<ContentEvent<Route>>()

    private var routeId: Int = 0

    fun init(routeId: Int) {
        this.routeId = routeId
        routesRepository
                .getRouteById(routeId)
                .dispatchTo(routeLiveData)
                .untilCleared()
    }

    fun openUsersPassedRoute() {
        routesScreenNavigation.openUsersPassedRoute(routeId)
    }

}