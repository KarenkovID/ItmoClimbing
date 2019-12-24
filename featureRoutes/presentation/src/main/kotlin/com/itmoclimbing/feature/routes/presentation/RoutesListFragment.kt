package com.itmoclimbing.feature.routes.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.presentationcommon.base.BaseFragment

internal class RoutesListFragment : BaseFragment(R.layout.fragment_routes_list) {

    companion object {
        fun newInstance() = RoutesListFragment()
    }

    private lateinit var viewModel: ViewModel

    override fun performOnBackPressed(): Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
                .of(this, DI.getScopeRoutesScope().getInstance(RoutesViewModelFactory::class.java))
                .get(RoutesListViewModel::class.java)
    }

}