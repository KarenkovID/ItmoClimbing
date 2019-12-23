package com.itmoclimbing.presentation.users

import android.os.Bundle
import android.view.View
import com.itmoclimbing.R
import com.itmoclimbing.internal.di.DI
import com.itmoclimbing.internal.di.Scopes
import com.itmoclimbing.internal.navigation.screens.users.UsersScreenNavigation
import com.itmoclimbing.presentationcommon.base.BaseFragment
import com.kommander.components.android_core.extra.args
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersListFragment : BaseFragment(R.layout.fragment_users_list) {

    companion object {
        fun newInstance(pagePos: Int) = UsersListFragment().also {
            it.pagePos = pagePos
        }
    }

    private val usersNavigation: UsersScreenNavigation by lazy {
        DI.getScope(Scopes.APP_SCOPE).getInstance(UsersScreenNavigation::class.java)
    }

    private var pagePos: Int by args()

    override fun performOnBackPressed(): Boolean {
        usersNavigation.back()
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentStackText.text = pagePos.toString()
        nextFragmentButton.setOnClickListener {
            usersNavigation.openUsersList(pagePos + 1)
        }
    }

}