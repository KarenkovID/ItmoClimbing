package com.itmoclimbing.feature.routes.presentation

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.features.common.dependencies.RoutesDependencies
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import com.kommander.components.android.extensions.schedulersIoToMain
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import com.kommander.components.domain.rx.RxSchedulersProvider
import toothpick.InjectConstructor

@InjectConstructor
class RoutesListViewModel(
        private val routesRepository: RoutesRepository,
        private val schedulersProvider: RxSchedulersProvider,
        private val routesDependencies: RoutesDependencies
) : BaseViewModel() {

    val routesListLiveData: MutableLiveData<ContentEvent<List<Route>>> by lazy { MutableLiveData<ContentEvent<List<Route>>>() }

    fun loadRoutes() {
        routesRepository
                .getAllRoutes()
                .schedulersIoToMain(schedulersProvider)
                .dispatchTo(routesListLiveData)
                .untilCleared()
    }

    fun onFabClick() {
        routesDependencies.selectUsersTab()
    }

}