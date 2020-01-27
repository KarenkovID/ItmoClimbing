package com.itmoclimbing.feature.routes.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.itmoclimbing.domainCommon.model.Route
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.feature.routes.presentation.R
import com.itmoclimbing.feature.routes.presentation.RoutesViewModelFactory
import com.kommander.components.android.extensions.observe
import com.kommander.components.android.presentation.base.BaseFragment
import com.kommander.components.android.recycler.DefaultDiffCallback
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import kotlinx.android.synthetic.main.fragment_routes_list.routesFab
import kotlinx.android.synthetic.main.fragment_routes_list.routesListRecycler
import kotlinx.android.synthetic.main.fragment_routes_list.routesListSwipeRefresh
import timber.log.Timber
import toothpick.ktp.extension.getInstance

internal class RoutesListFragment : BaseFragment(R.layout.fragment_routes_list) {

    companion object {
        fun newInstance() = RoutesListFragment()
    }

    private lateinit var viewModel: RoutesListViewModel

    override fun performOnBackPressed(): Boolean = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders
                .of(this, DI.getRoutesInternalScope().getInstance())
                .get(RoutesListViewModel::class.java)
    }

    @Suppress("ConvertLambdaToReference")
    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        routesFab.setOnClickListener {
            viewModel.onFabClick()
        }
        routesListSwipeRefresh.setOnRefreshListener {
            viewModel.loadRoutes()
        }
        routesListRecycler.adapter = ListDelegationAdapter<List<Route>>(RouteAdapterDelegate {viewModel.onRouteClick(it)})
        viewModel.routesListLiveData.observe(viewLifecycleOwner) { contentEvent ->
            if (contentEvent is ContentEvent.Success) {
                with ((routesListRecycler.adapter as ListDelegationAdapter<List<Route>>)) {
                    val diffResult = DiffUtil.calculateDiff(DefaultDiffCallback(items.orEmpty(), contentEvent.data))
                    items = contentEvent.data
                    diffResult.dispatchUpdatesTo(this)
                }
            }
            routesListSwipeRefresh.isRefreshing = contentEvent.isLoading()
        }
    }

}