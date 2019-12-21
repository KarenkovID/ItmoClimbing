package com.itmoclimbing.presentation.routes

import com.itmoclimbing.R
import com.itmoclimbing.presentation.base.BaseFragment

class RoutesListFragment : BaseFragment(R.layout.fragment_routes_list) {

    companion object {
        fun newInstance() = RoutesListFragment()
    }

    override fun performOnBackPressed(): Boolean = false

}