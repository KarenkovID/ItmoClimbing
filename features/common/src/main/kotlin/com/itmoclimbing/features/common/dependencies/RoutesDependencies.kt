package com.itmoclimbing.features.common.dependencies

import androidx.fragment.app.Fragment

interface RoutesDependencies {

    fun selectUsersTab()

    fun getUsersFragment(): Fragment

}