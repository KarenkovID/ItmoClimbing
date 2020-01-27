package com.itmoclimbing.feature.users.presentation.creation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.feature.users.di.DI
import com.itmoclimbing.feature.users.presentation.R
import com.kommander.components.android.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_create_user.createUsersCreateButton
import kotlinx.android.synthetic.main.fragment_create_user.createUsersFirstNameEditText
import kotlinx.android.synthetic.main.fragment_create_user.createUsersLastNameEditText
import toothpick.ktp.extension.getInstance

class CreateUserFragment : BaseFragment(R.layout.fragment_create_user) {

    companion object {
        fun newInstance() = CreateUserFragment()
    }

    private lateinit var viewModel: CreateUserViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this, DI.getUsersInternalScope().getInstance()).get(CreateUserViewModel::class.java)
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        createUsersCreateButton.setOnClickListener {
            viewModel.addUser(
                    createUsersFirstNameEditText.text.toString(),
                    createUsersLastNameEditText.text.toString()
            )
        }
    }

    override fun performOnBackPressed(): Boolean = false

}