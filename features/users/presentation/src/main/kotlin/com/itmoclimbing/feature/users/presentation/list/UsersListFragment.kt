package com.itmoclimbing.feature.users.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.itmoclimbing.domainCommon.model.User
import com.itmoclimbing.feature.users.di.DI
import com.itmoclimbing.feature.users.presentation.R
import com.kommander.components.android.extensions.observe
import com.kommander.components.android.extra.args
import com.kommander.components.android.presentation.base.BaseFragment
import com.kommander.components.android.recycler.DefaultDiffCallback
import com.kommander.components.android.viewmodel.livedata.ContentEvent
import kotlinx.android.synthetic.main.fragment_users_list.usersAddUser
import kotlinx.android.synthetic.main.fragment_users_list.usersListRecycler
import kotlinx.android.synthetic.main.fragment_users_list.usersListSwipeRefresh
import toothpick.ktp.extension.getInstance

class UsersListFragment : BaseFragment(R.layout.fragment_users_list) {

    companion object {
        fun newInstance(): Fragment = UsersListFragment()

        fun newInstance(routeId: Int): Fragment = UsersListFragment().also { it.routeId = routeId }
    }

    private var routeId: Int? by args<Int?>()

    private lateinit var viewModel: UsersListViewModel

    override fun performOnBackPressed(): Boolean = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders
                .of(this, DI.getUsersInternalScope().getInstance())
                .get(UsersListViewModel::class.java)
                .also { it.init(routeId) }
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        usersAddUser.setOnClickListener {
            viewModel.onFabClick()
        }
        @Suppress("ConvertLambdaToReference")
        usersListSwipeRefresh.setOnRefreshListener {
            viewModel.loadUsers()
        }
        usersListRecycler.adapter = ListDelegationAdapter(UsersAdapterDelegate())
        viewModel.usersListLiveData.observe(viewLifecycleOwner) { contentEvent ->
            if (contentEvent is ContentEvent.Success) {
                with((usersListRecycler.adapter as ListDelegationAdapter<List<User>>)) {
                    val diffResult = DiffUtil.calculateDiff(DefaultDiffCallback(items.orEmpty(), contentEvent.data))
                    items = contentEvent.data
                    diffResult.dispatchUpdatesTo(this)
                }
            }
            usersListSwipeRefresh.isRefreshing = contentEvent.isLoading()
        }
    }

}