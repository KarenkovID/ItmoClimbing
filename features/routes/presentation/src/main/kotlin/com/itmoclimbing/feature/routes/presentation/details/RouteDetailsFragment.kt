package com.itmoclimbing.feature.routes.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.feature.routes.presentation.R
import com.kommander.components.android.extensions.observe
import com.kommander.components.android.extra.args
import com.kommander.components.android.presentation.base.BaseFragment
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import kotlinx.android.synthetic.main.fragment_route_details.routeDetailsShowPassedUsers
import kotlinx.android.synthetic.main.item_route.itemRouteGrade
import kotlinx.android.synthetic.main.item_route.itemRouteTitle
import toothpick.ktp.extension.getInstance

class RouteDetailsFragment : BaseFragment(R.layout.fragment_route_details) {

    companion object {
        fun newInstance(routeId: Int) = RouteDetailsFragment().also { it.routeId = routeId }
    }

    private var routeId: Int by args()

    private lateinit var viewModel: RouteDetailsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders
                .of(this, DI.getRoutesInternalScope().getInstance())
                .get(RouteDetailsViewModel::class.java)
                .also { it.init(routeId) }
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.routeLiveData.observe(viewLifecycleOwner) { data ->
            (data as? ContentEvent.Success)?.let { data.data }?.run {
                itemRouteGrade.text = grade
                itemRouteTitle.text = name
            }
        }
        routeDetailsShowPassedUsers.setOnClickListener {
            viewModel.openUsersPassedRoute()
        }
    }

    override fun performOnBackPressed(): Boolean = false

}