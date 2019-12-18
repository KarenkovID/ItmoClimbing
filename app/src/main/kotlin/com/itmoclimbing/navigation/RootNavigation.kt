package com.itmoclimbing.navigation

import com.itmoclimbing.domain.navigation.AppRouter

class RootNavigation(appRouter: AppRouter) : ScreenNavigation(appRouter) {

    companion object {
        const val NAME = "ROOT_NAVIGATION"
    }

}