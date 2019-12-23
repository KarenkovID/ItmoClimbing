package com.itmoclimbing.feature.users.api

import androidx.fragment.app.Fragment
import com.itmoclimbing.feature.users.presentation.UsersScreenContainerFragment

object FeatureUsersApi {

    fun getUsersMainFragment(): Fragment = UsersScreenContainerFragment.newInstance()

}