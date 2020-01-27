package com.itmoclimbing.feature.routes.presentation.creation

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.itmoclimbing.feature.routes.presentation.RouteCreatedCallback
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.Event
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import toothpick.InjectConstructor

@InjectConstructor
class CreateRouteViewModel(
        private val routesRepository: RoutesRepository,
        private val routesScreenNavigation: RoutesScreenNavigation,
        private val routeCreatedCallback: RouteCreatedCallback
) : BaseViewModel() {

    val loadingStatusLiveData: MutableLiveData<Event> = MutableLiveData()

    fun addRoute(
            name: String,
            grade: String,
            description: String
    ) {
        routesRepository
                .addRoute(name, grade, description)
                .doOnComplete {
                    routeCreatedCallback.result.onNext(true)
                    routesScreenNavigation.back()
                }
                .dispatchTo(loadingStatusLiveData)
                .untilCleared()
    }

}