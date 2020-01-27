package com.itmoclimbing.feature.routes.presentation.list

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.domainCommon.repository.RoutesRepository
import com.itmoclimbing.feature.routes.navigation.RoutesScreenNavigation
import com.itmoclimbing.feature.routes.presentation.RouteCreatedCallback
import com.kommander.components.android.extensions.schedulersIoToMain
import com.kommander.components.android.viewmodel.BaseViewModel
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import com.kommander.components.android.viewmodel.livedata.dispatchTo
import com.kommander.components.domain.rx.RxSchedulersProvider
import io.reactivex.disposables.Disposable
import toothpick.InjectConstructor

@InjectConstructor
class RoutesListViewModel(
        private val routesRepository: RoutesRepository,
        private val schedulersProvider: RxSchedulersProvider,
        private val routesScreenNavigation: RoutesScreenNavigation,
        private val routeCreatedCallback: RouteCreatedCallback
) : BaseViewModel() {

    val routesListLiveData: MutableLiveData<ContentEvent<List<Route>>> by lazy { MutableLiveData<ContentEvent<List<Route>>>() }

    private var loadingDisposable: Disposable? = null
    private var routeCreationDisposable: Disposable? = null

    init {
        loadRoutes()
    }

    fun onFabClick() {
        routeCreationDisposable?.dispose()
        routeCreationDisposable = routeCreatedCallback
                .result
                .subscribe {
                    loadRoutes()
                    routeCreationDisposable?.dispose()
                }
        routesScreenNavigation.openCreateRouter()
    }

    fun loadRoutes() {
        loadingDisposable?.dispose()
        loadingDisposable = routesRepository
                .getRoutes()
                .schedulersIoToMain(schedulersProvider)
                .dispatchTo(routesListLiveData)
    }

    fun onRouteClick(route: Route) {
        routesScreenNavigation.openRouteDetails(route.id)
    }

}