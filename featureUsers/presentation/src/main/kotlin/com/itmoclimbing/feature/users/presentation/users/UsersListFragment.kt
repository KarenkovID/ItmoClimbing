package com.itmoclimbing.feature.users.presentation.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.users.di.DI
import com.itmoclimbing.feature.users.navigation.UsersScreenNavigation
import com.itmoclimbing.feature.users.presentation.R
import com.kommander.components.android_core.presentation.base.BaseFragment
import com.kommander.components.android_core.extra.args
import kotlinx.android.synthetic.main.fragment_users_list.fragmentStackText
import kotlinx.android.synthetic.main.fragment_users_list.nextFragmentButton

class UsersListFragment : BaseFragment(R.layout.fragment_users_list) {

    companion object {
        fun newInstance(pagePos: Int): Fragment = UsersListFragment().also {
            it.pagePos = pagePos
        }
    }

    private val usersNavigation: UsersScreenNavigation by lazy {
        DI.getUsersInternalScope().getInstance(UsersScreenNavigation::class.java)
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