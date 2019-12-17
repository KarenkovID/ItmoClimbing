package com.itmoclimbing.navigation

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FragmentScreen private constructor(
        fragmentProvider: () -> Fragment
): SupportAppScreen() {

    companion object {

        fun withoutArguments(screenKey: String, fragmentProvider: () -> Fragment) {

        }

    }

    val fragmentProvider: () -> Fragment

    override fun getFragment(): Fragment {
        return super.getFragment()
    }

}