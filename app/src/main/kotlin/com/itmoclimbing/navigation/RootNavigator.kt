package com.itmoclimbing.navigation

import androidx.fragment.app.Fragment
import com.itmoclimbing.RootActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

class RootNavigator(
        rootActivity: RootActivity,
        containerId: Int
) : SupportAppNavigator(rootActivity, containerId) {

    override fun createFragment(screen: SupportAppScreen?): Fragment {
        return super.createFragment(screen)
    }
}