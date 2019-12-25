package com.itmoclimbing.feature.routes.presentation

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.internal.viewmodel.livedata.BaseViewModel
import com.itmoclimbing.internal.viewmodel.livedata.dispatchTo
import com.itmoclimbing.features.common.dependencies.RoutesDependencies
import com.itmoclimbing.presentationcommon.internal.viewmodel.livedata.ContentEvent
import com.kommander.components.android_core.extensions.schedulersIoToMain
import com.kommander.components.domain_core.rx.RxSchedulersProvider
import javax.inject.Inject

class RoutesListViewModel @Inject constructor(
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