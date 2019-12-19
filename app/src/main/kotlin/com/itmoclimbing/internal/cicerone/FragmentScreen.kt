package com.itmoclimbing.internal.cicerone

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FragmentScreen(
        private val innerScreenKey: String,
        private val factory: () -> Fragment
) : SupportAppScreen() {

    override fun getScreenKey() = innerScreenKey

    override fun getFragment() = factory()

}