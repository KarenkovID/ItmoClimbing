package com.itmoclimbing.feature.routes.presentation.creation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.itmoclimbing.feature.routes.di.DI
import com.itmoclimbing.feature.routes.presentation.R
import com.kommander.components.android.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_create_route.createRouteCreateButton
import kotlinx.android.synthetic.main.fragment_create_route.createRouteDescriptionEditText
import kotlinx.android.synthetic.main.fragment_create_route.createRouteGradeEditText
import kotlinx.android.synthetic.main.fragment_create_route.createRouteNameEditText
import toothpick.ktp.extension.getInstance

class CreateRouteFragment : BaseFragment(R.layout.fragment_create_route) {

    companion object {
        fun newInstance() = CreateRouteFragment()
    }

    private lateinit var viewModel: CreateRouteViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this, DI.getRoutesInternalScope().getInstance()).get(CreateRouteViewModel::class.java)
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        createRouteCreateButton.setOnClickListener {
            viewModel.addRoute(
                    createRouteNameEditText.text.toString(),
                    createRouteGradeEditText.text.toString(),
                    createRouteDescriptionEditText.text.toString()
            )
        }
    }

    override fun performOnBackPressed(): Boolean = false

}