package com.itmoclimbing.navigation

import com.itmoclimbing.RootActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class RootNavigator(
    rootActivity: RootActivity,
    containerId: Int
): SupportAppNavigator(rootActivity, containerId) {

}