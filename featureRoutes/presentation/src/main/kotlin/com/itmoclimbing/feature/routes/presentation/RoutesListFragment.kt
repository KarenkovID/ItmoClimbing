package com.itmoclimbing.feature.routes.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.presentationcommon.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_routes_list.routesFab

internal class RoutesListFragment : BaseFragment(R.layout.fragment_routes_list) {

    companion object {
        fun newInstance() = RoutesListFragment()
    }

    private lateinit var viewModel: RoutesListViewModel

    override fun performOnBackPressed(): Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
                .of(this, DI.getRoutesInternalScope().getInstance(RoutesViewModelFactory::class.java))
                .get(RoutesListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        routesFab.setOnClickListener {
            viewModel.onFabClick()
        }
    }

}